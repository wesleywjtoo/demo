package com.example.demo.svc;

import com.example.demo.model.Sp;
import com.example.demo.repo.DemoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpService {
    public static final Logger log = LoggerFactory.getLogger(SpService.class);

    @Autowired
    private DemoRepo demoRepo;

    public List<Sp> getAllSp(){
        return demoRepo.findAll();
    }

    public String getUserFromSp(){
        return "Johnny Nnemonic";
    }
}
