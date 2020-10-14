package com.example.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@EnableSwagger2Doc
@EnableFeignClients
public class HeyteaDemoSpringCloudEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeyteaDemoSpringCloudEurekaConsumerApplication.class, args);
    }

}
