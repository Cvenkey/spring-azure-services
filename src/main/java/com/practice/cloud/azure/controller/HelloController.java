package com.practice.cloud.azure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/message")
    public String hello(){
        return "Pinservice deployed successfully in Azure Cloud";
    }
}
