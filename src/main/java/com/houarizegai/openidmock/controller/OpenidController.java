package com.houarizegai.openidmock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OpenidController {

    @Value("classpath:data/oidc/token.json")
    private Resource openIdToken;

    @Value("classpath:data/oidc/user_info.json")
    private Resource openIdUserInfo;

    @Value("classpath:data/oidc/openid_config,json")
    private Resource openIdConfig;

    @Value("classpath:data/oidc/jwks.json")
    private Resource openIdJwks;

    @PostMapping(value = "/oauth/token", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public String getToken() {
        return extractContent(openIdToken);
    }

    @GetMapping(value = "/oauth/userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUserInfo() {
        return extractContent(openIdUserInfo);
    }


    @GetMapping(value = "/.well-known/openid-configuration", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getConfig() {
        return extractContent(openIdConfig);
    }


    @GetMapping(value = "/oauth/jwks", produces = MediaType.APPLICATION_JSON_VALUE)
    public String jwks() {
        return extractContent(openIdJwks);
    }

    private String extractContent(Resource resource) {
        try {
            return new String(resource.getInputStream().readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
