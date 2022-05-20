package com.example.authservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Data
public class PropertySource {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${app.auth.apikey.key}")
    private String appAuthApiKey;

    @Value("${app.auth.token.type}")
    private String appAuthTokenType;

    @Value("${app.auth.secret}")
    private String appAuthSecret;

    @Value("${app.auth.ttl}")
    private long appTimeToLive;

    @Value("${app.auth.header.key}")
    private String appAuthHeaderKey;
}
