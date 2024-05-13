package com.example.demo;

import com.example.demo.repo.DemoRepo;
import com.example.demo.repo.GuyRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

	@MockBean
	private DemoRepo demoRepo;

	@MockBean
	private GuyRepo guyRepo;

	@Test
	void contextLoads() {
	}

}
