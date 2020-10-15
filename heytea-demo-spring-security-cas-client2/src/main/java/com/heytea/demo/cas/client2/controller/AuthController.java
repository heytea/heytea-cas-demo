package com.heytea.demo.cas.client2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        log.info("/login called");
        return "redirect:/secured";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response,
            SecurityContextLogoutHandler logoutHandler) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(
                SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
        cookieClearingLogoutHandler.logout(request, response, auth);
        logoutHandler.logout(request, response, auth);
        return "auth/logout";
    }
}