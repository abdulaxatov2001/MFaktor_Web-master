package com.example.clientservice.entity;

import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();
    @ManyToOne
    private PaymentType paymentType;

}
