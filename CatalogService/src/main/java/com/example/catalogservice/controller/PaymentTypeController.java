package com.example.catalogservice.controller;

import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.payload.PaymentTypeDto;
import com.example.catalogservice.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paymentType")
public class PaymentTypeController {
    @Autowired
    PaymentTypeService paymentTypeService;

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse all = paymentTypeService.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse response = paymentTypeService.getOne(id);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }
    @PostMapping
    public HttpEntity<?> save(@RequestBody PaymentTypeDto dto) {
        ApiResponse response = paymentTypeService.add(dto);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }
}
