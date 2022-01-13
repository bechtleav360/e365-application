package com.bechtle.eagl.webapp.pages;

import com.bechtle.eagl.webapp.clients.UsersClient;
import com.bechtle.eagl.webapp.clients.WalletClient;
import com.bechtle.eagl.webapp.model.User;
import com.bechtle.eagl.webapp.config.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class ConnectPage {
    private final WalletClient walletClient;
    private final UsersClient usersClient;

    @Autowired
    public ConnectPage(
            Environment environment,
            WalletClient walletClient,
            UsersClient usersClient){
        this.walletClient = walletClient;
        this.usersClient = usersClient;
    }

    @GetMapping("/user/connect/install")
    public String index(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model){


        model.addAttribute("progress", "Schritt 1 von 3");
        model.addAttribute("step", 1);
        model.addAttribute("login",  principal.getFirstAttribute(SecurityConfiguration.USER_DETAILS_LOGIN));

        return "connect/install-app";
    }

    @GetMapping("/user/connect/scan")
    public String create_relationship(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model){

        model.addAttribute("progress", "Schritt 2 von 3");
        model.addAttribute("step", 2);
        model.addAttribute("login",  principal.getFirstAttribute(SecurityConfiguration.USER_DETAILS_LOGIN));

        return "connect/scan-token";
    }

    @GetMapping("/user/connect/link")
    public String sync(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model){
        walletClient.sync(principal.getFirstAttribute(SecurityConfiguration.USER_DETAILS_LOGIN));

        model.addAttribute("progress", "Schritt 3 von 3");
        model.addAttribute("login",  principal.getFirstAttribute(SecurityConfiguration.USER_DETAILS_LOGIN));
        model.addAttribute("step", 2);

        return "connect/sync";
    }


    @PostMapping("/user/connect/code")
    public String insertCode(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, @RequestParam("linkingCode")  String code, Model model) throws IOException {
        String login = principal.<String>getFirstAttribute(SecurityConfiguration.USER_DETAILS_LOGIN);



        walletClient.link(login, code);
        User user = usersClient.getUser(login);
        user.getRelationships().stream().findFirst()
                .map(relationships -> principal.getAttributes().put(SecurityConfiguration.USER_DETAILS_RELATION_ID, List.of(relationships)));
        model.addAttribute("relationshipId", user.getRelationships());
        model.addAttribute("progress", "Abgeschlossen");
        model.addAttribute("step", 2);

        return "connect/success";
    }


}
