package com.example.resttemplateproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateProjectApplication.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
