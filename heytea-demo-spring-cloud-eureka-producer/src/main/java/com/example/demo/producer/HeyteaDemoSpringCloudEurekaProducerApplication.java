package com.example.demo.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@EnableSwagger2Doc
public class HeyteaDemoSpringCloudEurekaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeyteaDemoSpringCloudEurekaProducerApplication.class, args);
    }

}
