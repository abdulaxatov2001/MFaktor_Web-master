package com.example.clientservice.controller;

import com.example.clientservice.entity.Payment;
import com.example.clientservice.entity.Visitor;
import com.example.clientservice.payload.ApiResponse;
import com.example.clientservice.payload.PaymentDto;
import com.example.clientservice.payload.PaymentTypeDto;
import com.example.clientservice.repository.PaymentRepository;
import com.example.clientservice.repository.VisitorRepository;
import com.example.clientservice.service.PaymentService;
import com.example.clientservice.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/visitor")
public class VisitorController {


    final VisitorRepository visitorRepository;
    final VisitorService visitorService;
    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok(visitorRepository.findAll());
    }

   @GetMapping("/{id}")
   public HttpEntity<?> getById(@PathVariable Long id){
       Optional<Visitor> optionalVisitor = visitorRepository.findById(id);
       return ResponseEntity.status(optionalVisitor.isPresent()?200:404).body(optionalVisitor.orElseThrow(() -> new ResourceAccessException("This visitor not found")));
   }
    @PostMapping
    public HttpEntity<?> addVisitor(@RequestBody Visitor visitor){
        ApiResponse apiResponse=visitorService.addVisitor(visitor);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PostMapping("/event/add")
    public HttpEntity<?> addVisitorEvent(@RequestBody Visitor visitor){
        ApiResponse apiResponse=visitorService.addVisitorEvent(visitor);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }


    @PutMapping("/{id}")
    public HttpEntity<?> editVisitorById(@PathVariable Long id,@RequestBody Visitor visitor){
        ApiResponse apiResponse = visitorService.editVisitor(id, visitor);
        return ResponseEntity.status(apiResponse.isSuccess()?200: 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable Long id){
        visitorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

@GetMapping("/visitor/check")
    public ApiResponse checkVisitor(@RequestParam String phoneNumber){
    boolean b = visitorRepository.existsByPhoneNumber(phoneNumber);

        return new ApiResponse("Mana",b);
}










}
