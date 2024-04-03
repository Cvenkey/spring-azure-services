package com.practice.cloud.azure.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.cloud.azure.config.ApplicationConfig;
import com.practice.cloud.azure.response.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PinService {

    private final ApplicationConfig applicationConfig;

    @Autowired
    public PinService(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public APIResponse fetchDetailsByPin(String pin) {
        APIResponse apiResponse = null;
        RestTemplate restTemplate;
        try {
            restTemplate = new RestTemplateBuilder().build();
            String json = restTemplate.getForObject(applicationConfig.getUrl() + pin, String.class);
            ObjectMapper mapper = new ObjectMapper();
            apiResponse = mapper.readValue(json, APIResponse[].class)[0];
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return apiResponse;
    }
}
