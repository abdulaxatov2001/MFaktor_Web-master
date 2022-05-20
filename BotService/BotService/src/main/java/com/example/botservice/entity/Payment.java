package com.example.botservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    private Double amount;

//    @Enumerated(EnumType.STRING)
//    private PaymentType paymentType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date=new Date();
    @ManyToOne
    private PaymentType paymentType;

}
