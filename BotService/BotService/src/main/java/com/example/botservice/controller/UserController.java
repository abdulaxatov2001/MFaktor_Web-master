package com.example.botservice.controller;

import com.example.botservice.feignClient.ClientFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    final ClientFeignClient clientFeignClient;




}
