package com.example.catalogservice.service;

import com.example.catalogservice.entity.ArticleCategory;
import com.example.catalogservice.exceptions.ResourceNotFoundException;
import com.example.catalogservice.payload.AdsSourceDto;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.payload.ArticleCategoryDto;
import com.example.catalogservice.repository.ArticleCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.Optional;

@Service
public class ArticleCategoryService {

    @Autowired
    ArticleCategoryRepository articleCategoryRepository;

//    public ArticleCategoryService(ArticleCategoryRepository articleCategoryRepository) {
//        this.articleCategoryRepository = articleCategoryRepository;
//    }
//
//    public ArticleCategoryService() {
//    }

    @SneakyThrows
    public ApiResponse add(ArticleCategory articleCategory) {
//        ArticleCategory articleCategory = new ArticleCategory();
//        articleCategory.setName(dto.getName());
//        articleCategory.setActive(dto.isActive());
        if (articleCategoryRepository.findByName(articleCategory.getName()).isPresent()) {
            throw new ResourceNotFoundException("Bunday nomli bor");
        } else {
            ArticleCategory saveArticleCategory = articleCategoryRepository.save(articleCategory);
            return new ApiResponse("Saqlandi", true, saveArticleCategory);
        }
    }

    public ApiResponse getAll() {
        return new ApiResponse("Found", true, articleCategoryRepository.findAll());
    }

    public ApiResponse getById(Integer id) {
        Optional<ArticleCategory> optionalArticleCategory = articleCategoryRepository.findById(id);
        if (optionalArticleCategory.isPresent()) {
            return new ApiResponse("Found", true, optionalArticleCategory.get());
        }
        return new ApiResponse("Not Found", false, null);
    }

    public ApiResponse edit(Integer id, ArticleCategoryDto dto) {


        Optional<ArticleCategory> byName = articleCategoryRepository.findById(id);
        if (!byName.isPresent()) {
            return new ApiResponse("nhjdvgch", false);
        }
        ArticleCategory articleCategory = byName.get();
        articleCategory.setName(dto.getName());
        articleCategory.setActive(dto.isActive());
        ArticleCategory save = articleCategoryRepository.save(articleCategory);
        return new ApiResponse("Mana", true, save);

//        Optional<ArticleCategory> byId = articleCategoryRepository.findById(id);
//        if (byId.isPresent()) {
//            ArticleCategory articleCategory = byId.get();
//            articleCategory.setName(dto.getName());
//            articleCategory.setActive(dto.isActive());
//            ArticleCategory save = articleCategoryRepository.save(articleCategory);
//            return new ApiResponse("Edited", true, save);
//        }
//        return new ApiResponse("Article Category not found", false, new ArticleCategory());

    }

    public ApiResponse editNotDTO(Integer id, ArticleCategory dto) {

        Optional<ArticleCategory> byName = articleCategoryRepository.findById(id);
        if (!byName.isPresent()) {
            return new ApiResponse("nhjdvgch", false);
        }
        ArticleCategory articleCategory = byName.get();
        articleCategory.setName(dto.getName());
        articleCategory.setActive(dto.isActive());
        ArticleCategory save = articleCategoryRepository.save(articleCategory);
        return new ApiResponse("Mana", true, save);

//        Optional<ArticleCategory> byId = articleCategoryRepository.findById(id);
//        if (byId.isPresent()) {
//            ArticleCategory articleCategory = byId.get();
//            articleCategory.setName(dto.getName());
//            articleCategory.setActive(dto.isActive());
//            ArticleCategory save = articleCategoryRepository.save(articleCategory);
//            return new ApiResponse("Edited", true, save);
//        }
//        return new ApiResponse("Article Category not found", false, new ArticleCategory());

    }

    public ApiResponse delete(Integer id) {

        articleCategoryRepository.deleteById(id);
        return new ApiResponse("Mana", true);
//        Optional<ArticleCategory> byId = articleCategoryRepository.findById(id);
//        if (byId.isPresent()) {
//            ArticleCategory articleCategory = byId.get();
//            articleCategory.setActive(false);
//            ArticleCategory save = articleCategoryRepository.save(articleCategory);
//            return new ApiResponse("active is false", true, save);
//        }
//        return new ApiResponse("Article Category not found", false);

    }
}
