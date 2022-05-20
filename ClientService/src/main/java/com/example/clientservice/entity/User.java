package com.example.clientservice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "users")
public class User implements Serializable {

//    @Serial
//    private static final long serialVersionUID = -2744057715673660467L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp createdAt;

    private String chatId;

    private String position;

    private String companyName;

    private String lang;

    private String state;
    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Double balance = 0.0;

    private String organization;

    private Character gender;

    private boolean isActive = true;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private AdsSource adsSource;

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

}
