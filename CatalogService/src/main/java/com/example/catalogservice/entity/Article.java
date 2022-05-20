package com.example.catalogservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    private Attachment attachment;

    private String description;

    @Column(columnDefinition = "text")
    private String articleSource;

    @ManyToOne
    private ArticleCategory articleCategory;

    private boolean active = true;
}
