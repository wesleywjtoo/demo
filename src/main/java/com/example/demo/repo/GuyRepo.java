package com.example.demo.repo;

import com.example.demo.model.Guy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuyRepo extends JpaRepository<Guy, Long> {
}
