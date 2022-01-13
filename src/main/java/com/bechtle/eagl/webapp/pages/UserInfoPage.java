package com.bechtle.eagl.webapp.pages;

import com.bechtle.eagl.webapp.config.SecurityConfiguration;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
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
import java.util.List;

@Controller
@Slf4j
public class UserInfoPage {
    private String appMode;

    @Autowired
    public UserInfoPage(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/user/info")
    public String index(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model){
        log.info("Accessing user info page, the following attributes are configured: {}", principal.getAttributes());
        List<String> relationshipIds = principal.<String>getAttribute(SecurityConfiguration.USER_DETAILS_RELATION_ID);
        if(relationshipIds != null && relationshipIds.size() > 0) {
            model.addAttribute("relationshipId", relationshipIds.get(0));
        }

        model.addAttribute("relationshipId", principal.getFirstAttribute(SecurityConfiguration.USER_DETAILS_RELATION_ID));
        model.addAttribute("username", principal.getFirstAttribute(SecurityConfiguration.USER_DETAILS_LOGIN));

        return "user_info";
    }







}
