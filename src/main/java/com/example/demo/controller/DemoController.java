package com.example.demo.controller;

import com.example.demo.model.Guy;
import com.example.demo.model.Sp;
import com.example.demo.svc.GuyService;
import com.example.demo.svc.SpService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/sp")
    public List<Sp> getAllTheGuys(){
        log.info("guy Called-----------------------------");
        log.warn("guy Called-----------------------------");
        log.error("guy Called-----------------------------");
        log.debug("guy Called-----------------------------");
        List<Sp> rsList = new ArrayList<>();
        rsList = spService.getAllSp();
        return rsList;
    }

    @GetMapping("/sp/{id}")
    public ResponseEntity<Optional<Sp>> specialGuy(@PathVariable("id") UUID spId){
        log.info("oneguy Called-----------------------------");
        log.warn("oneguy Called-----------------------------");
        log.error("oneguy Called-----------------------------");
        log.debug("oneguy Called-----------------------------");
        var o = spService.getUserFromSp(spId);

        return ResponseEntity.ok(o);
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
