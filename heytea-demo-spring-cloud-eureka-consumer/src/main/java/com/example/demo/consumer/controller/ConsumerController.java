package com.example.demo.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.feignclient.ProducerFeignClient;
import com.example.demo.consumer.model.R;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/consumer")
public class ConsumerController {
    
    private ProducerFeignClient producerFeignClient;
    
    @GetMapping("/getOne")
    public R<R<String>> getOne() {

        // @formatter:off
        return new R<R<String>>()
            .setCode(200)
            .setMessage("Message from consumer " + getClass().getSimpleName())
            .setData(producerFeignClient.getOne());
        // @formatter:on
    }

}
