package com.example.demo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Guy {
    private String guyName;
    private LocalDateTime guyJoinDate;
}
