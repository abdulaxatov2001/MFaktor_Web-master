package com.example.clientservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;
    private String organization;

    private Character gender;

    private Integer adsSourceId;
}
