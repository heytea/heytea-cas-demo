package com.example.demo.consumer.feignclient.impl;

import org.springframework.stereotype.Component;

import com.example.demo.consumer.feignclient.ProducerFeignClient;
import com.example.demo.consumer.model.R;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProducerFeignClientImpl implements ProducerFeignClient {
    
    @Setter
    private Throwable cause;

    @Override
    public R<String> getOne() {
        log.error("[远程调用服务降级]-服务名: XXX, 服务方法: YYY, 返回信息: ZZZ");
        return new R<String>().setData(cause.getMessage());
    }


}
