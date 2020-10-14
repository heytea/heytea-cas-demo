package com.example.demo.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.producer.model.R;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @GetMapping("/getOne")
    public R<String> getOne() {
        // return R.success();

        // @formatter:off
        return new R<String>()
            .setCode(200)
            .setMessage("Message from producer")
            .setData(this.getClass().getSimpleName());
        // @formatter:on
    }

}
