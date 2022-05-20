package com.example.adminservice.controller;

import com.example.adminservice.payload.ApiResponse;
import com.example.adminservice.payload.EventDto;
import com.example.adminservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    final EventService eventService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody EventDto eventDto){
        ApiResponse apiResponse = eventService.add(eventDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping("/{id}")
    public  HttpEntity<?> findByID(@PathVariable Integer id){
        ApiResponse apiResponse = eventService.findById(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public  HttpEntity<?> findAll(){
        ApiResponse apiResponse = eventService.findAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }


}
