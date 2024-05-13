package com.example.demo.repo;

import com.example.demo.model.Sp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DemoRepo extends JpaRepository<Sp, UUID> {
}
