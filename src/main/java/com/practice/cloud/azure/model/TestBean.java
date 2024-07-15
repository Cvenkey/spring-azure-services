package com.practice.cloud.azure.model;

import com.practice.cloud.azure.config.ToUpperCase;
import lombok.Data;
public class TestBean {
  @ToUpperCase
  private String name;
  private String location;

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "TestBean{" +
            "name='" + name + '\'' +
            ", location='" + location + '\'' +
            '}';
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public TestBean(String name, String location) {
    this.name = name;
    this.location = location;
  }
}
