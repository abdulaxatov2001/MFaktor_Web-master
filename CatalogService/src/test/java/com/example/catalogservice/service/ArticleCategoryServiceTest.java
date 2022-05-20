package com.example.catalogservice.service;

import com.example.catalogservice.entity.ArticleCategory;
import com.example.catalogservice.exceptions.ResourceNotFoundException;
import com.example.catalogservice.payload.ApiResponse;
import com.example.catalogservice.payload.ArticleCategoryDto;
import com.example.catalogservice.repository.ArticleCategoryRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.IllegalFormatConversionException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) //shu siz ishlamaydi qatiylikning yengil versiyasi
public class ArticleCategoryServiceTest {

    @Mock
    private ArticleCategoryRepository articleCategoryRepository;

    @InjectMocks
    private ArticleCategoryService articleCategoryService;

    private ArticleCategory articleCategory;


    @BeforeEach
    public void setup() {
//        articleCategoryRepository = Mockito.mock(ArticleCategoryRepository.class);
//        articleCategoryService = new ArticleCategoryService(articleCategoryRepository);

        articleCategory = ArticleCategory.builder().id(1).name("Test").active(true).build();
    }

    @Test
    @DisplayName("Save articleCategory ")
    public void saveTest() {
        //given data bunaqasi bazada yoq degandan keyin
        given(articleCategoryRepository.findByName(articleCategory.getName())).willReturn(Optional.empty());

        //then
        System.out.println(articleCategory);
        //fake ish
        given(articleCategoryRepository.save(articleCategory)).willReturn(articleCategory);

        System.out.println(articleCategoryService);

        //when
        ApiResponse response = articleCategoryService.add(articleCategory);
        ArticleCategory articleCategory = (ArticleCategory) response.getObject();

        System.out.println(articleCategory);

        assertThat(response.isSuccess()).isFalse();
        assertThat(articleCategory).isNotNull(); //qo'shildi rostanam deyishi un
    }

    @Test
    @DisplayName("Get All")
    public void getAllTest() {

        ArticleCategory ketmon = ArticleCategory.builder().id(2).name("Ketmon").active(true).build();

        //berilgan malumot
        given(articleCategoryRepository.findAll()).willReturn(List.of(articleCategory, ketmon));


        ApiResponse response = articleCategoryService.getAll();
        List<ArticleCategory> articleCategoryList = (List<ArticleCategory>) response.getObject();


        System.out.println(articleCategoryList);
//        articleCategoryList = null; //bo'sh qilib tekshirib ko'rdim
        //verify

        assertThat(articleCategoryList).isNotEmpty();
        assertThat(articleCategoryList.size()).isEqualTo(2);
    }


    @Test
    @DisplayName("Get One")
    public void getOneTest() {

        //given
        given(articleCategoryRepository.findById(1)).willReturn(Optional.of(articleCategory));

        //then
        ApiResponse response = articleCategoryService.getById(articleCategory.getId());
        articleCategory = (ArticleCategory) response.getObject();

        assertThat(articleCategory).isNotNull();
    }

    @Test
    @DisplayName("Edit articlecategory")
    public void editTest() {
        //then
        System.out.println(articleCategory);
        given(articleCategoryRepository.save(articleCategory)).willReturn(articleCategory);
        //o'zgardi
        ArticleCategoryDto dto = new ArticleCategoryDto("Qani", false);
//        articleCategory.setName("Yangi");
//        articleCategory.setActive(false);


//        System.out.println(articleCategory);
        //then
        System.out.println(dto);
        System.out.println(articleCategory.getId());
        ApiResponse response = articleCategoryService.edit(articleCategory.getId(), dto);

        given(articleCategoryRepository.findByName(articleCategory.getName())).willReturn(Optional.ofNullable(articleCategory));
        System.out.println(articleCategory);

        ApiResponse apiResponse = articleCategoryService.edit(articleCategory.getId(), dto);
        ArticleCategory edited = (ArticleCategory) apiResponse.getObject();

        System.out.println(edited);
        //        articleCategory = (ArticleCategory) response.getObject();


//        assertThat(articleCategory.getName()).isEqualTo("Qani");
//        assertThat(articleCategory.isActive()).isFalse();
//        assertThat(edited).isNotNull();
        assertThat(articleCategory).isNull();
    }


    @Test
    @DisplayName("Edit with not dto")
    public void editTestNotDTO() {
        given(articleCategoryRepository.save(articleCategory)).willReturn(articleCategory);


        articleCategory.setActive(false);
        articleCategory.setName("Salom");

        System.out.println(articleCategory);

        ApiResponse apiResponse = articleCategoryService.editNotDTO(1, articleCategory);
        ArticleCategory category = (ArticleCategory) apiResponse.getObject();

        System.out.println(apiResponse);
        System.out.println(category);

        assertThat(category).isNotNull();
        assertThat(category.getName()).isEqualTo("Salom");

    }

    @Test
    @DisplayName("Delete ")
    public void deleteTest() {
//fake bazaga malumot yozdi
        given(articleCategoryRepository.save(articleCategory)).willReturn(articleCategory);

        System.out.println(articleCategory);
        willDoNothing().given(articleCategoryRepository).deleteById(1);

        System.out.println(articleCategory);

        ApiResponse response = articleCategoryService.delete(articleCategory.getId());
        System.out.println(response);


        //1-variant
//        assertThat(response.isSuccess()).isTrue();

        //2-variant
        verify(articleCategoryRepository).deleteById(1);
//        verify(articleCategoryRepository, times(10)).deleteById(2);
    }


    @Test
    @DisplayName("Save articlecategory With Throw")
    public void saveWithThrow() {

        given(articleCategoryRepository.findByName(articleCategory.getName())).willReturn(Optional.of(articleCategory));

        given(articleCategoryRepository.save(articleCategory)).willReturn(articleCategory);

        assertThrows(IllegalFormatConversionException.class, () -> {
            articleCategoryService.add(articleCategory);
        });

        verify(articleCategoryRepository, never()).save(any(ArticleCategory.class));

    }


    //throw
//    @Test
//    void testExpectedExceptionWithParentType() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            Integer.parseInt("One1234");
//        });
//    }

}
