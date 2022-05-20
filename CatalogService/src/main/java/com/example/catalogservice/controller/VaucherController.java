package com.example.catalogservice.controller;

import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.payload.VaucherDto;
import com.example.catalogservice.repository.VaucherRepository;
import com.example.catalogservice.service.VaucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaucher")
public class VaucherController {
    @Autowired
    VaucherRepository vaucherRepository;
    @Autowired
    VaucherService vaucherService;

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse all = vaucherService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse byId = vaucherService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public HttpEntity<?> addVaucher(@RequestBody VaucherDto vaucherDto) {
        ApiResponse apiResponse = vaucherService.addVaucher(vaucherDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editVaucher(@PathVariable Integer id, @RequestBody VaucherDto vaucherDto) {
        ApiResponse apiResponse = vaucherService.edit(id, vaucherDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        boolean b = vaucherRepository.existsById(id);
        if (b) {
            vaucherRepository.deleteById(id);
            return ResponseEntity.ok("Deleted!");
        } else {
            return ResponseEntity.ok("Not found!");
        }
    }

}
