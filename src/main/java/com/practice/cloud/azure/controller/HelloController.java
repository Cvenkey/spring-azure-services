package com.practice.cloud.azure.controller;

import com.practice.cloud.azure.model.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    TestBean testBean;
    @GetMapping("/message")
    public String hello(){
        return "Pinservice deployed successfully in Azure Cloud with docker-compose"+testBean.toString() ;
    }

    @RequestMapping("/logLevels")
    public void testLogLevel() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
    }

}
