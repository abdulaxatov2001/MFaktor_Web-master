package com.example.adminservice.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Double balance=0.0;

    private String organization;

    private Character gender;

    private boolean isActive=true;

    @ManyToOne
    private AdsSource adsSource;

    public User(String password, String firstName, String lastName, String phoneNumber, String organization, Character gender) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.organization = organization;
        this.gender = gender;
    }

    public User(String password, String firstName, String lastName, String phoneNumber, Double balance, String organization, Character gender, boolean isActive) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.organization = organization;
        this.gender = gender;
        this.isActive = isActive;
    }
// Advertise  bilan boglanadi

    // EVENT bilan boglash
}
