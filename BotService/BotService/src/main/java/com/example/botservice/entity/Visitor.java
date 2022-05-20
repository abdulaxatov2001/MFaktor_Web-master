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

public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String phoneNumber;

    @OneToOne
    private Seat seat;

    @ManyToOne
    private Event event;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String organization;

    private String position;

    private String region;

    private Character gender;

    public Visitor(String firstName, String lastName, String phoneNumber, String organization, Character gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.organization = organization;
        this.gender = gender;
    }
}
