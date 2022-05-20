package com.example.clientservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTypeDto {
    private String name;
    private boolean active;
    private Integer paymentColorId;

    public PaymentTypeDto(String name, boolean active) {
        this.name = name;
        this.active = active;
    }
}
