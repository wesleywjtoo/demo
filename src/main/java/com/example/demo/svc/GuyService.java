package com.example.demo.svc;

import com.example.demo.model.Guy;
import com.example.demo.repo.GuyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuyService {
    @Autowired
    private GuyRepo guyRepo;

    public List<Guy> getAllGuys(){
        return guyRepo.findAll();
    }
}
