package com.example.clientservice.controller;

import com.example.clientservice.entity.Payment;
import com.example.clientservice.payload.ApiResponse;
import com.example.clientservice.payload.PaymentDto;
import com.example.clientservice.repository.PaymentRepository;
import com.example.clientservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {

    final PaymentRepository  paymentRepository;
    final PaymentService paymentService;
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(paymentRepository.findAll());
    }

   @GetMapping("/{id}")
   public HttpEntity<?> getById(@PathVariable Integer id){
       Optional<Payment> optionalPayment = paymentRepository.findById(id);
       return ResponseEntity.status(optionalPayment.isPresent()?200:404).body(optionalPayment.orElseThrow());
   }
    @PostMapping
    public HttpEntity<?> makePayment(@RequestBody PaymentDto dto){
        ApiResponse apiResponse=paymentService.makePayment(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }


    @GetMapping("/user/{id}")
    public HttpEntity<?> getAll(@PathVariable Long id){
        return ResponseEntity.ok(paymentRepository.findAllByUserId(id));
    }












}
