package com.practice.cloud.azure.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.cloud.azure.config.ToUpperCase;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class APIResponse {
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Status")
    @ToUpperCase
    private String status;
    @JsonProperty("PostOffice")
    private List<PostOffice> postOffice;
}

