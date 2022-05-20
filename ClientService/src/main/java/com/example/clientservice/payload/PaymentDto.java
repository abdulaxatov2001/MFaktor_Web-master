package com.example.clientservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor@NoArgsConstructor
public class PaymentDto {

    private Long userId;
    private Double amount;
    private Date date;
    private Integer paymentTypeId;
}
