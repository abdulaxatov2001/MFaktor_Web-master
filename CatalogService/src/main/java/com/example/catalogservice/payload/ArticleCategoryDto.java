package com.example.catalogservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleCategoryDto {


    private String name;

    private boolean active=true;
}
