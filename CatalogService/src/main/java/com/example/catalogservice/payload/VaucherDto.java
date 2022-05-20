package com.example.catalogservice.payload;

import lombok.Data;

import java.util.Date;
@Data
public class VaucherDto {
    private Integer id;
    private double amount;
    private String promoCode;
    private Date expireDate;
}
