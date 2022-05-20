package com.example.catalogservice.controller;

import com.example.catalogservice.entity.PaymentColor;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.repository.PaymentColorRepository;
import com.example.catalogservice.service.PaymentColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paymentcolor")
public class PaymentColorController {

//catalog Serviceda qilish kk
    final PaymentColorService paymentColorService;
    final PaymentColorRepository paymentColorRepository;
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(paymentColorRepository.findAll());
    }

   @GetMapping("/{id}")
   public HttpEntity<?> getById(@PathVariable Integer id){
       Optional<PaymentColor> optionalPaymentColor = paymentColorRepository.findById(id);
       return ResponseEntity.status(optionalPaymentColor.isPresent()?200:404).body(optionalPaymentColor.orElseThrow());
   }
    @PostMapping
    public HttpEntity<?> addPaymentColor(@RequestBody PaymentColor paymentColor){
        ApiResponse apiResponse=paymentColorService.addPaymentColor(paymentColor);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editById(@PathVariable Integer id,@RequestBody PaymentColor paymentColor){
        ApiResponse apiResponse = paymentColorService.editPaymentColor(paymentColor, id);
        return ResponseEntity.status(apiResponse.isSuccess()?200: 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable Integer id){
        paymentColorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
