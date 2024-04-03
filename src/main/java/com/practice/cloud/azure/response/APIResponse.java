package com.practice.cloud.azure.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class APIResponse {
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("PostOffice")
    private List<PostOffice> postOffice;

}

class PostOffice{
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("BranchType")
    private String branchType;
    @JsonProperty("DeliveryStatus")
    private String deliveryStatus;
    @JsonProperty("Circle")
    private String circle;
    @JsonProperty("District")
    private String district;
    @JsonProperty("Division")
    private String division;
    @JsonProperty("Region")
    private String region;
    @JsonProperty("Block")
    private String block;
    @JsonProperty("State")
    private String state;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Pincode")
    private String pincode;

}