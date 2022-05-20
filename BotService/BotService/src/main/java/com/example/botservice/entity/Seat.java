package com.example.botservice.entity;
//package com.example.clientservice.entity;

import com.example.botservice.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private Double price; // narxi

    @ManyToOne
    private Event event;

    private Integer raw;

    @ManyToOne
    private User user;

     @ManyToOne
    private Visitor visitor;

    @JsonIgnore
    @ManyToOne
    private Template template;


    @Enumerated(EnumType.STRING)
    private Status status = Status.EMPTY;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;






}
