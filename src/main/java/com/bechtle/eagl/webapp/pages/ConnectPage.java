package com.bechtle.eagl.webapp.pages;

import com.bechtle.eagl.webapp.clients.UsersClient;
import com.bechtle.eagl.webapp.clients.WalletClient;
import com.bechtle.eagl.webapp.model.Relationships;
import com.bechtle.eagl.webapp.model.User;
import com.bechtle.eagl.webapp.services.AuthenticationAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ScheduledFuture;

@Controller
public class ConnectPage {
    private final WalletClient walletClient;
    private final UsersClient usersClient;
    private final AuthenticationAttributes authenticationAttributes;
    private final TaskScheduler taskScheduler;

    @Autowired
    public ConnectPage(
            Environment environment,
            WalletClient walletClient,
            UsersClient usersClient, AuthenticationAttributes authenticationAttributes,
            TaskScheduler taskScheduler) {
        this.walletClient = walletClient;
        this.usersClient = usersClient;
        this.authenticationAttributes = authenticationAttributes;
        this.taskScheduler = taskScheduler;
    }

    @GetMapping("/user/connect/install")
    public String index(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model) {

        model.addAttribute("progress", "Schritt 1 von 3");
        model.addAttribute("step", 1);
        model.addAttribute("login", authenticationAttributes.getUid(principal));

        return "connect/install-app";
    }

    @GetMapping("/user/connect/scan")
    public String create_relationship(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model) {

        model.addAttribute("progress", "Schritt 2 von 3");
        model.addAttribute("step", 2);
        model.addAttribute("login", authenticationAttributes.getUid(principal));

        return "connect/scan-token";
    }

    @GetMapping("/user/connect/link")
    public String sync(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model) {
        this.taskScheduler.scheduleWithFixedDelay(walletClient::sync, Duration.ofSeconds(1));

        model.addAttribute("progress", "Schritt 3 von 3");
        model.addAttribute("login", authenticationAttributes.getUid(principal));
        model.addAttribute("step", 2);

        return "connect/sync";
    }


    @PostMapping("/user/connect/code")
    public String insertCode(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, @RequestParam("linkingCode") String code, Model model) throws IOException {
        String login = authenticationAttributes.getUid(principal);

        // link
        walletClient.link(login, code);
        // then fetch user again, this time with relationship
        User user = usersClient.getUser(login);

        Relationships relationship = user.getRelationships().stream().findFirst().orElseGet(Relationships::new);

        authenticationAttributes.setWalletId(principal, relationship);
        model.addAttribute("relationshipId", relationship.getRelationshipId());
        model.addAttribute("progress", "Abgeschlossen");
        model.addAttribute("step", 2);

        return "connect/success";
    }


}
