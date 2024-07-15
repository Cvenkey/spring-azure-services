package com.practice.cloud.azure.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the annotation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ToUpperCase {
}
