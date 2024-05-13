package com.example.demo.controller;

import com.example.demo.model.Guy;
import com.example.demo.svc.GuyService;
import com.example.demo.svc.SpService;
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

    private SpService spService;

    private GuyService guyService;

    public DemoController(SpService spService, GuyService guyService){
        this.spService = spService;
        this.guyService = guyService;
    }

    @GetMapping("/guy")
    public List<Guy> getAllTheGuys(){
        log.info("guy Called-----------------------------");
        log.warn("guy Called-----------------------------");
        log.error("guy Called-----------------------------");
        log.debug("guy Called-----------------------------");
        List<Guy> rsList = new ArrayList<>();
        rsList = guyService.getAllGuys();
        return rsList;
    }

    @GetMapping("/oneguy")
    public Guy specialGuy(){
        log.info("oneguy Called-----------------------------" + spService.getUserFromSp());
        log.warn("oneguy Called-----------------------------");
        log.error("oneguy Called-----------------------------");
        log.debug("oneguy Called-----------------------------");
        var o = new Guy();
            o.setGuyName("Arnold Schwarzenegger");
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
