package com.practice.cloud.azure.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.cloud.azure.config.ApplicationConfig;
import com.practice.cloud.azure.model.PincodeData;
import com.practice.cloud.azure.model.User;
import com.practice.cloud.azure.repository.PincodeRepository;
import com.practice.cloud.azure.repository.UserRepository;
import com.practice.cloud.azure.request.Pincode;
import com.practice.cloud.azure.request.UserPincodes;
import com.practice.cloud.azure.response.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class PinService {

    private final ApplicationConfig applicationConfig;
    private final PincodeRepository pincodeRepository;
    private final UserRepository userRepository;

    @Autowired
    public PinService(ApplicationConfig applicationConfig, PincodeRepository pincodeRepository, UserRepository userRepository) {
        this.applicationConfig = applicationConfig;
        this.pincodeRepository = pincodeRepository;
        this.userRepository = userRepository;
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
            log.error("PinService :: fetchDetailsByPin, exception: {}", e);
            e.printStackTrace();
        }
        log.info("Invoked {}::{}","PinService","fetchDetailsByPin");
        return apiResponse;
    }

    @Transactional
    public APIResponse saveUserPincodes(UserPincodes userPincodes) {
        APIResponse apiResponse = new APIResponse();;
        try {
            User user = new User();
            Set<PincodeData> pincodeDatas = new HashSet<>();
            BeanUtils.copyProperties(userPincodes, user);
            user.setCreatedDate(LocalDateTime.now());
            user = userRepository.save(user);

            for(Pincode pincode : userPincodes.getPincodes()){
                PincodeData pData = new PincodeData();
                BeanUtils.copyProperties(pincode, pData);
                pData.setCreatedDate(LocalDateTime.now());
                pData.setUser(user);
                pincodeDatas.add(pData);
            }
            pincodeRepository.saveAll(pincodeDatas);
            apiResponse.setMessage("Pincodes are successfully saved");
            apiResponse.setStatus("success");

        }catch (Exception e) {
            apiResponse.setMessage("Error while saving codes");
            apiResponse.setStatus("error");
            log.error("PinService :: saveUserPincodes, exception: {}", e);
            e.printStackTrace();
        }
        log.info("Invoked {}::{}","PinService","saveUserPincodes");
        return apiResponse;
    }
}



