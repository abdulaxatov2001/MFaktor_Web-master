package com.example.adminservice.feignClient;

import com.example.adminservice.entity.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;

@FeignClient(name = "BOT",url = "localhost:8080/api/bot/")
public interface BotFeignClient {

    @PostMapping("sendMessageUsers")
    void setAllMessage(@RequestBody Event event);

}
