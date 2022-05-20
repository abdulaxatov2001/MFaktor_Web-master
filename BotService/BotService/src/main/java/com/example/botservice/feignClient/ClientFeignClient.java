package com.example.botservice.feignClient;

import com.example.botservice.entity.User;
import com.example.botservice.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.GET;
import java.util.Optional;

@FeignClient(name = "ClientService")
public interface ClientFeignClient {

    @GetMapping("/getAll")
    ApiResponse getAll();

    @GetMapping("/getAllByChatId")
    ApiResponse getAllByChatId();

    @GetMapping("/byChatId/{chatId}")
    Optional<User> getbyChatId(@PathVariable String chatId);



}
