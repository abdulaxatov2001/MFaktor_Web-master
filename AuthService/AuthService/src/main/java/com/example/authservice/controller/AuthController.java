package com.example.authservice.controller;

import com.example.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    //authService
    private final AuthService authService;

    @GetMapping(value = "/generate", produces = "application/json")
    public ResponseEntity<?> getJWTToken(@RequestHeader("apiKey") String apiKey) {
//        authService chaqiriladi
        return ResponseEntity.ok(authService.validateApiKeyAndGetJwtToken(apiKey));
    }
}
