package com.example.adminservice.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Attachment attachment;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String middleName;

    private String companyName;

    private String position;

    private String bio;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private boolean active = true;
}

