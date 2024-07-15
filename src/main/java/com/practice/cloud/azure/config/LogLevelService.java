package com.practice.cloud.azure.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class LogLevelService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/changeLogLevel/{loggerName}/{logLevel}")
    public void changeLogLevel(@PathVariable  String loggerName, @PathVariable String logLevel) {
        String url = "http://localhost:8080/actuator/loggers/" + loggerName;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String jsonBody = "{\"configuredLevel\":\"" + logLevel + "\"}";
        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Log level changed successfully");
        } else {
            System.out.println("Failed to change log level");
        }
    }
}
