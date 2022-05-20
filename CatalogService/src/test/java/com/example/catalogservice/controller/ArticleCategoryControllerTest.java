package com.example.catalogservice.controller;

import com.example.catalogservice.entity.ArticleCategory;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.service.ArticleCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@AutoConfigureWebMvc
//@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest
@SpringBootTest(classes = ArticleCategoryController.class)
@AutoConfigureMockMvc
public class ArticleCategoryControllerTest {
    //    @InjectMocks
//    ArticleCategoryController articleCategoryController;
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleCategoryService articleCategoryService;

//    @Autowired
//    ObjectMapper objectMapper;

//    @Test
//    public void saveArticleCategoryTest() throws Exception {
//        //given
//        ArticleCategory articleCategory = ArticleCategory.builder().active(true).name("Ketmon").build();
//
////        System.out.println(articleCategoryService);
//        given(articleCategoryService.add(any(ArticleCategory.class))).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
//
//
//        //urlga mock zapros beryapti
//        ResultActions resultActions = mockMvc.perform(post("http://localhost:8080/api/catalog/articleCategory").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(articleCategory))).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//
//        System.out.println(resultActions);
//
////        resultActions.andDo(print()).andExpect(status().isOk());
//
//    }

//@Test
//    public void getAll() throws Exception{
//
//    List<ArticleCategory> articleCategoryList= new ArrayList<>();
//    articleCategoryList.add(new ArticleCategory(1,"nimadur",true));
//    articleCategoryList.add(new ArticleCategory(2,"ketmon",true));
//   given(articleCategoryService.getAll()).willReturn(new ApiResponse("MANa",true,articleCategoryList));
//        ResultActions resultActions = mockMvc.perform(get("http://localhost:8081/api/catalog/articleCategory"));
//
//        resultActions.andExpect(status().is2xxSuccessful()).andDo(print());
//        System.out.println(resultActions);
//
////        resultActions.andDo(print()).andExpect(status().isOk());
//
//}

}
