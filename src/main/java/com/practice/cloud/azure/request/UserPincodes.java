package com.practice.cloud.azure.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserPincodes {
    private String userName;
    private List<Pincode> pincodes;

}

