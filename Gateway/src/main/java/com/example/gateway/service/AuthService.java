package com.example.gateway.service;


import com.example.gateway.model.AuthTokenModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "AUTH")
public interface AuthService {

    @GetMapping(value = "/auth/generate")
    public AuthTokenModel getJWTToken(@RequestHeader("apikey") String apiKey);

}
