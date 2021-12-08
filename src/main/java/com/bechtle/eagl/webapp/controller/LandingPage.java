package com.bechtle.eagl.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class LandingPage {
    private String appMode;

    @Autowired
    public LandingPage(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        model.addAttribute("mode", appMode);

        return "welcome";
    }



}
