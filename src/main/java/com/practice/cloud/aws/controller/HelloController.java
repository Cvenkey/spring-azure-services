package com.practice.cloud.aws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/message")
    public String hello(){
        return "application deployed successfully in Azure Cloud";
    }
}
