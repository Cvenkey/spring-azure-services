package com.practice.cloud.azure.service;

import com.practice.cloud.azure.model.User;
import com.practice.cloud.azure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> listUsers (){



        return null;
    }

}
