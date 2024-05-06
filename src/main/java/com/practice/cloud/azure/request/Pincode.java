package com.practice.cloud.azure.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pincode {
    private String pincode;
    private String poName;
    private String branchType;
    private String district;
    private String region;
    private String state;
    private String country;
}
