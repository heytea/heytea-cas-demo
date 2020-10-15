package com.heytea.demo.cas.client2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SecuredController {

    @GetMapping("/secured")
    public String securedIndex(ModelMap modelMap) {

        log.info("/secured called");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getPrincipal() instanceof UserDetails)
            modelMap.put("username", ((UserDetails) auth.getPrincipal()).getUsername());

        return "secure/index";
    }

}