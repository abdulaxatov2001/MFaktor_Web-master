package com.example.catalogservice.controller;

import com.example.catalogservice.payload.AdsSourceDto;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.service.AdsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adsSource")
public class AdsSourceController {

    @Autowired
    AdsSourceService adsSourceService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody AdsSourceDto dto) {
        ApiResponse response = adsSourceService.add(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody AdsSourceDto dto) {
        ApiResponse edit = adsSourceService.edit(id, dto);
        return ResponseEntity.ok(edit);
    }

   /* @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody AdsSourceDto dto){
        ApiResponse edit =adsSourceService.edit(id,dto);
        return ResponseEntity.ok(edit);
    }*/

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse delete = adsSourceService.delete(id);
        return ResponseEntity.ok(delete);
    }

     @GetMapping
     public HttpEntity<?> getAll(){
         ApiResponse all = adsSourceService.getAll();
         return ResponseEntity.ok(all);
     }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse response = adsSourceService.getOne(id);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }
}
