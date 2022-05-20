package com.example.adminservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "templates")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)  // unique bo'lishi kerak
    private String name;

    private Integer count; // default

    //    @JsonIgnore
    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    private List<Seat> seats;

    private Integer countOfChairsInRaw;

    private boolean priceByPlace;  // joy bo'yicha

    private Double maxPrice;

    private Double minPrice;

}

