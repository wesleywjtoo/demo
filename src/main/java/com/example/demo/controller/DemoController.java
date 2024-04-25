package com.example.demo.controller;

import com.example.demo.model.Guy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/guy")
    public List<Guy> getAllTheGuys(){
        System.out.println("/guy called");
        List<Guy> rsList = new ArrayList<>();
        String[] guys = {"Biacht","Shoot","MundleBundle","Liang","John"};
        for(var x : guys){
            var o = new Guy();
            o.setGuyName(x);
            o.setGuyJoinDate(LocalDateTime.now());
            rsList.add(o);
        }
        return rsList;
    }

    @GetMapping("/oneguy")
    public Guy specialGuy(){
        System.out.println("/oneguy called");
        var o = new Guy();
            o.setGuyName("SPECIAL SOMEONE");
            o.setGuyJoinDate(LocalDateTime.now());
        return o;
    }

    @GetMapping("/whichguy")
    public Guy getWhichGuy(){
        System.out.println("/whichguy called");
        var o = new Guy();
        o.setGuyName("THIS GUY LA");
        o.setGuyJoinDate(LocalDateTime.now());
        return o;
    }
}
