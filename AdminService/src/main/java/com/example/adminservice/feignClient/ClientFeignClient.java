package com.example.adminservice.feignClient;

import com.example.adminservice.entity.Event;
import com.example.adminservice.entity.Seat;
import com.example.adminservice.entity.Visitor;
import com.example.adminservice.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "CLIENT")
public interface ClientFeignClient {
    //@GetMapping("visitor/{id}")
    @GetMapping("/visitor/check")
    public ApiResponse checkVisitor(@RequestParam String phoneNumber);

    @PostMapping("/visitor/event/add")
    public ApiResponse save(@RequestBody Visitor visitor);

    @GetMapping("/getAll")
    ApiResponse getAll();

    @GetMapping("/getAllByChatId")
    ApiResponse getAllByChatId();

    @GetMapping("/{id}")
    ApiResponse getById(@PathVariable Long id);

    @PostMapping("/balance")
    ApiResponse changeBalance(@RequestParam Double balance, @RequestParam Long id);

}
