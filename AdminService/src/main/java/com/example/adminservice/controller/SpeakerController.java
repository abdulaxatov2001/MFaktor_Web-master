package com.example.adminservice.controller;

import com.example.adminservice.entity.Speaker;
import com.example.adminservice.payload.ApiResponse;
import com.example.adminservice.payload.SpeakerDTO;
import com.example.adminservice.repository.SpeakerRepository;
import com.example.adminservice.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/speaker")
public class SpeakerController {

    final SpeakerRepository speakerRepository;
    final SpeakerService speakerService;

    @GetMapping("/test")
    public String test() {
        return "Qanisan";
    }

    @GetMapping
    public HttpEntity<?> getSpeakers(@RequestParam(defaultValue = "0") int size, @RequestParam(defaultValue = "0") int page) {
        if (size == 0 || page == 0) {
            List<Speaker> speakers = speakerRepository.findAllByActive(true);
            return ResponseEntity.ok().body(speakers);
        } else {
            Pageable pageable = PageRequest.of(page, size);
            Page<Speaker> speakers = (Page<Speaker>) speakerRepository.findAllByActive(true, pageable);
            return ResponseEntity.ok().body(speakers);
        }
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getSpeaker(@PathVariable Integer id) {
        ApiResponse apiResponse = speakerService.getSpeaker(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getData());
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody SpeakerDTO dto) {
        ApiResponse apiResponse = speakerService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody SpeakerDTO dto) {
        ApiResponse apiResponse = speakerService.edit(id, dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = speakerService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
