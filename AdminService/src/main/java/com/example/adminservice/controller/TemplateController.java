package com.example.adminservice.controller;

import com.example.adminservice.payload.ApiResponse;
import com.example.adminservice.payload.TemplateDto;
import com.example.adminservice.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.POST;

@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class TemplateController {

    private final TemplateService templateService;

    /**
     * get one template
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public HttpEntity<?> one(@PathVariable Integer id) {
        ApiResponse apiResponse = templateService.one(id);

        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody TemplateDto dto) {
        ApiResponse apiResponse = templateService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
