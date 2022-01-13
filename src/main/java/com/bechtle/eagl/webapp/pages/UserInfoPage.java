package com.bechtle.eagl.webapp.pages;

import com.bechtle.eagl.webapp.config.SecurityConfiguration;
import com.bechtle.eagl.webapp.services.AuthenticationAttributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class UserInfoPage {
    private String appMode;
    private final AuthenticationAttributes authenticationAttributes;

    @Autowired
    public UserInfoPage(Environment environment, AuthenticationAttributes authenticationAttributes){
        appMode = environment.getProperty("app-mode");
        this.authenticationAttributes = authenticationAttributes;
    }

    @RequestMapping("/user/info")
    public String index(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model){
        log.info("Accessing user info page, the following attributes are configured: {}", principal.getAttributes());
        if(StringUtils.hasLength(authenticationAttributes.getWalletId(principal))) {
            model.addAttribute("relationshipId", authenticationAttributes.getWalletId(principal));
        }

        model.addAttribute("firstname",authenticationAttributes.getFirstName(principal));
        model.addAttribute("lastname",authenticationAttributes.getLastName(principal));
        model.addAttribute("login", authenticationAttributes.getUid(principal));

        return "user_info";
    }







}
