package com.example.clientservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(mappedBy = "template")
    private List<Seat> seats;

    private Integer countOfChairsInRaw;


    private boolean priceByPlace;  // joy bo'yicha

    private Double maxPrice;

    private Double minPrice;

}

