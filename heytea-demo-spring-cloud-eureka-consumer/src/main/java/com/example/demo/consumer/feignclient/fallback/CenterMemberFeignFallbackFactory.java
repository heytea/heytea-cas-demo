package com.example.demo.consumer.feignclient.fallback;

import org.springframework.stereotype.Component;

import com.example.demo.consumer.feignclient.ProducerFeignClient;
import com.example.demo.consumer.feignclient.impl.ProducerFeignClientImpl;

import feign.hystrix.FallbackFactory;

@Component
public class CenterMemberFeignFallbackFactory implements FallbackFactory<ProducerFeignClient> {

    @Override
    public ProducerFeignClient create(Throwable cause) {
        ProducerFeignClientImpl centerMemberFeign = new ProducerFeignClientImpl();
        centerMemberFeign.setCause(cause);
        return centerMemberFeign;
    }

}
