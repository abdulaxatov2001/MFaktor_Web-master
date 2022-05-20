package com.example.catalogservice.payload;

import lombok.Data;

@Data
public class PaymentTypeDto {
    private String name;
    private Integer paymentColorId;
    private boolean active;
}
