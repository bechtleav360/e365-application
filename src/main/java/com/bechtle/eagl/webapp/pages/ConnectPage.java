package com.bechtle.eagl.webapp.pages;

import com.bechtle.eagl.webapp.clients.WalletClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String create_relationship(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model){

        String username = principal.getAttribute("username").get(0).toString();
        model.addAttribute("progress", "Schritt 2 von 3");
        model.addAttribute("step", 2);
        model.addAttribute("login", username);
        model.addAttribute("mode", appMode);

        return "connect/scan-token";
    }

    @GetMapping("/user/connect/link")
    public String sync(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model){
        String username = principal.getAttribute("username").get(0).toString();
        walletClient.sync(username);

        model.addAttribute("progress", "Schritt 3 von 3");
        model.addAttribute("login", username);
        model.addAttribute("step", 2);
        model.addAttribute("mode", appMode);

        return "connect/sync";
    }


    @PostMapping("/user/connect/code")
    public String insertCode(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, @RequestParam("linkingCode")  String code, Model model){
        walletClient.link(principal.getAttribute("username").get(0).toString(), code);

        model.addAttribute("progress", "Abgeschlossen");
        model.addAttribute("step", 2);
        model.addAttribute("mode", appMode);

        return "user_info";
    }


}
