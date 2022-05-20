package com.example.catalogservice.controller;

import com.example.catalogservice.entity.ArticleCategory;
import com.example.catalogservice.payload.AdsSourceDto;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.payload.ArticleCategoryDto;
import com.example.catalogservice.service.AdsSourceService;
import com.example.catalogservice.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articleCategory")
public class ArticleCategoryController {

    @Autowired
    ArticleCategoryService articleCategoryService;

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse response = articleCategoryService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse response = articleCategoryService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody ArticleCategory articleCategory) {
        ApiResponse response = articleCategoryService.add(articleCategory);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody ArticleCategoryDto dto) {
        ApiResponse edit = articleCategoryService.edit(id, dto);
        return ResponseEntity.ok(edit);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse delete = articleCategoryService.delete(id);
        return ResponseEntity.ok(delete);
    }

//    @GetMapping
//    public HttpEntity<?> getAll(){
//        ApiResponse all = adsSourceService.getAll();
//        return ResponseEntity.ok(all);
//    }
}
