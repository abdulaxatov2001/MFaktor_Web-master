package com.example.catalogservice.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
public class Vaucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double amount;

    //    private Client client; buyerda client bolishi kerak
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    private boolean active = true;

    @Column(unique = true)
    private String promoCode;
}
