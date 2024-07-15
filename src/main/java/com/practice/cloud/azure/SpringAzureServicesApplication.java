package com.practice.cloud.azure;

import com.practice.cloud.azure.model.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
public class SpringAzureServicesApplication implements ApplicationContextAware {

	private static ApplicationContext context;
	public static void main(String[] args) {

		SpringApplication.run(SpringAzureServicesApplication.class, args);
		log.info(" ======user dir ===="+System.getProperty("user.dir"));
	}

	@Bean
    RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory  = new SimpleClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(10_000);
		clientHttpRequestFactory.setReadTimeout(10_000);
		return clientHttpRequestFactory;
	}

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		context = applicationContext;
	}

	@Bean
	public TestBean testBean(){
		return  new TestBean("Shital","Delhi");
	}
}
