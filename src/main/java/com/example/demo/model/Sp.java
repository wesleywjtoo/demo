package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Sp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID spId;

    private String spCode;
    private String spName;
    private LocalDateTime joinDate;
}
