package com.practice.cloud.azure.controller;

import com.practice.cloud.azure.response.APIResponse;
import com.practice.cloud.azure.service.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PinServiceController {

    @Autowired
    PinService pinService;

    @GetMapping("/pinservices/{pincode}")
    public ResponseEntity<APIResponse> fetchPincodeDetails(@PathVariable String pincode){
        return new ResponseEntity<>(pinService.fetchDetailsByPin(pincode), HttpStatus.ACCEPTED);
    }
}
