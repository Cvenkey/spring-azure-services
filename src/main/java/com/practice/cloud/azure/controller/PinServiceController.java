package com.practice.cloud.azure.controller;

import com.practice.cloud.azure.request.UserPincodes;
import com.practice.cloud.azure.response.APIResponse;
import com.practice.cloud.azure.service.PinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PinServiceController {

    @Autowired
    PinService pinService;

    @GetMapping("/pinservices/{pincode}")
    public ResponseEntity<APIResponse> fetchPincodeDetails(@PathVariable String pincode){
        log.info("Invoking {}::{} with request:{}","PinServiceController","fetchPincodeDetails",pincode);
        return new ResponseEntity<>(pinService.fetchDetailsByPin(pincode), HttpStatus.ACCEPTED);
    }
    @PostMapping("/registerUserPincodes")
    public ResponseEntity<APIResponse> savePincodes(@RequestBody UserPincodes userPincodes){
        log.info("Invoking {}::{} with request:{}","PinServiceController","savePincodes",userPincodes);
        return  new ResponseEntity<>(pinService.saveUserPincodes(userPincodes),HttpStatus.CREATED);
    }
}
