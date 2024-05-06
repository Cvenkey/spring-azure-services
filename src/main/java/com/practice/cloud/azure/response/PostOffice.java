package com.practice.cloud.azure.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostOffice {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("poName")
    private String poName;
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
