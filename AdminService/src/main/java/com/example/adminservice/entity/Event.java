package com.example.adminservice.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Attachment attachment;

    private String name;

    @ManyToOne
    private Speaker speaker;

    @Column(columnDefinition = "text")
    private String description;

    private Timestamp startTime;

    private boolean byPlace = true;
    @ManyToOne
    private Template template;
    @ManyToMany
    private List<Seat> seats;

    @Transient
    private Double summa;
}

