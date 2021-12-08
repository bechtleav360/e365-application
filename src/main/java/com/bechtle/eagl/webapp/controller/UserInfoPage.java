package com.bechtle.eagl.webapp.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@Log
public class UserInfoPage {
    private String appMode;

    @Autowired
    public UserInfoPage(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/user/info")
    public String index(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model){
        log.info("Accessing secured site");

        model.addAttribute("username", principal.getAttribute("username"));

        return "user_info";
    }







}
