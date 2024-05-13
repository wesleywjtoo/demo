# Use a base image with Maven to build the Spring Boot application
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven configuration file
COPY pom.xml .

# Download dependencies and package the application
RUN mvn -B -f pom.xml dependency:go-offline package -DskipTests

# Copy the application's source code
COPY src ./src

# Build the application
RUN mvn -B clean package -DskipTests

# Use a base WildFly image
# FROM jboss/wildfly:23.0.0.Final

FROM default-route-openshift-image-registry.apps.sandbox-m2.ll9k.p1.openshiftapps.com/openshift/jboss-eap74-openjdk11-openshift:latest

# Add a management user (adjust username and password)
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#20240101 --silent

# Set the working directory
WORKDIR /opt/jboss/wildfly

# Add the PostgreSQL driver module
ADD ./postgresql-42.7.3.jar /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/postgresql-42.7.3.jar

# Add module.xml
ADD ./module.xml /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/module.xml

# Configure WildFly/JBoss
# RUN /opt/jboss/wildfly/bin/jboss-cli.sh --commands="embed-server,/subsystem=datasources/jdbc-driver=postgresql:add(driver-name=postgresql,driver-module-name=org.postgresql,driver-xa-datasource-class-name=org.postgresql.xa.PGXADataSource)"

# Copy the custom standalone.xml
COPY custom-standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml


# Set environment variables for WildFly configuration
ENV JAVA_OPTS="-Djboss.bind.address.management=0.0.0.0 -Djboss.bind.address=0.0.0.0 -Dlogging.level.org.springframework=DEBUG"

# Copy the WAR file from the previous stage to the deployments directory in WildFly
COPY --from=build /app/target/*.war /opt/jboss/wildfly/standalone/deployments/

# Expose the port WildFly is listening on
EXPOSE 8080 9990

# Start WildFly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]