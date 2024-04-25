package com.example.demo.controller;

import com.example.demo.model.Guy;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
public class DemoController {
    public static final Logger log = LoggerFactory.getLogger(DemoController.class.getName());

    @GetMapping("/guy")
    public List<Guy> getAllTheGuys(){
        log.info("guy Called-----------------------------");
        log.warn("guy Called-----------------------------");
        log.error("guy Called-----------------------------");
        log.debug("guy Called-----------------------------");
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
        log.info("oneguy Called-----------------------------");
        log.warn("oneguy Called-----------------------------");
        log.error("oneguy Called-----------------------------");
        log.debug("oneguy Called-----------------------------");
        var o = new Guy();
            o.setGuyName("SPECIAL SOMEONE");
            o.setGuyJoinDate(LocalDateTime.now());
        return o;
    }

    @GetMapping("/whichguy")
    public Guy getWhichGuy(){
        log.info("whichguy Called-----------------------------");
        log.warn("whichguy Called-----------------------------");
        log.error("whichguy Called-----------------------------");
        log.debug("whichguy Called-----------------------------");
        var o = new Guy();
        o.setGuyName("THIS GUY LA");
        o.setGuyJoinDate(LocalDateTime.now());
        return o;
    }
}
