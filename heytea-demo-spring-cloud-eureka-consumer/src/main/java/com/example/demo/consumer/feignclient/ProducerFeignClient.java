package com.example.demo.consumer.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.consumer.feignclient.fallback.CenterMemberFeignFallbackFactory;
import com.example.demo.consumer.model.R;

@FeignClient(value = "HEYTEA-DEMO-SPRING-CLOUD-EUREKA-PRODUCER", path = ProducerFeignClient.PATH,
    fallbackFactory = CenterMemberFeignFallbackFactory.class)
public interface ProducerFeignClient {
    
    public static final String PATH = "/api/heytea-demo-spring-cloud-eureka-producer";

    @GetMapping("/producer/getOne")
    R<String> getOne();

}
