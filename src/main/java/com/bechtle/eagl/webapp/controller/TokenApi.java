package com.bechtle.eagl.webapp.controller;

import com.bechtle.eagl.webapp.clients.WalletClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TokenApi {


    private WalletClient walletClient;

    public TokenApi(@Autowired WalletClient walletClient) {
        this.walletClient = walletClient;
    }

    @GetMapping(value = "/api/token", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateToken(@RequestParam String login) throws IOException {
        byte[] tokenImage = walletClient.getTokenImage(login);
        return tokenImage;
    }
}
