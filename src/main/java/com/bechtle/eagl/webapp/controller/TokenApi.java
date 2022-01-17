package com.bechtle.eagl.webapp.controller;

import com.bechtle.eagl.webapp.clients.WalletClient;
import com.bechtle.eagl.webapp.services.AuthenticationAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TokenApi {


    private final WalletClient walletClient;
    private final AuthenticationAttributes authenticationAttributes;

    public TokenApi(@Autowired WalletClient walletClient, AuthenticationAttributes authenticationAttributes) {
        this.walletClient = walletClient;
        this.authenticationAttributes = authenticationAttributes;
    }

    @GetMapping(value = "/api/token", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateToken(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, @RequestParam String login) throws IOException {
        if(! StringUtils.hasLength(login)) {
            login = authenticationAttributes.getUid(principal);
        }

        byte[] tokenImage = walletClient.getTokenImage(login);
        return tokenImage;
    }
}
