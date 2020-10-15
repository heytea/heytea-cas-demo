package com.heytea.demo.cas.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author houyehua
 *
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        log.info("Index controller called");
        return "index";
    }

}