package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Guy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guyId;
    private String guyName;
    private LocalDateTime guyJoinDate;
}
