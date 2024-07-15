package com.practice.cloud.azure.util;

import com.practice.cloud.azure.SpringAzureServicesApplication;
import com.practice.cloud.azure.config.ToUpperCase;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

//@Aspect
//@Component
public class UpperCaseAspect {

    @Pointcut("execution(* com.practice.cloud.azure..*.*(..))")
    public void anyMethod() {}

    @Before("anyMethod()")
    public void processUpperCaseAnnotations() throws Throwable {
        for (Object bean : SpringAzureServicesApplication.getApplicationContext().getBeansOfType(Object.class).values()) {
            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(ToUpperCase.class)) {
                    field.setAccessible(true);
                    Object value = field.get(bean);
                    if (value instanceof String) {
                        String upperCaseValue = ((String) value).toUpperCase();
                        field.set(bean, upperCaseValue);
                    }
                }
            }
        }
    }
}
