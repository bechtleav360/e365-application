package com.bechtle.eagl.webapp.pages;

import com.bechtle.eagl.webapp.clients.WalletClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class ConnectPage {
    private String appMode;
    private WalletClient walletClient;

    @Autowired
    public ConnectPage(
            Environment environment,
            WalletClient walletClient
    ){
        appMode = environment.getProperty("app-mode");
        this.walletClient = walletClient;
    }

    @GetMapping("/user/connect/install")
    public String index(Model model){

        model.addAttribute("progress", "Schritt 1 von 3");
        model.addAttribute("step", 1);
        model.addAttribute("mode", appMode);

        return "connect/install-app";
    }

    @GetMapping("/user/connect/scan")
    public String create_relationship(Model model){


        model.addAttribute("progress", "Schritt 2 von 3");
        model.addAttribute("step", 2);
        model.addAttribute("mode", appMode);

        return "connect/scan-token";
    }



}
