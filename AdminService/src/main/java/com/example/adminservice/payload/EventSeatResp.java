package com.example.adminservice.payload;

import com.example.adminservice.entity.enums.RegionEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Sanjarbek Allayev, пт 7:12. 15.04.2022
 */
@Data
public class EventSeatResp {

    private String firstName;

    private String lastName;

    private String middleName;

    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String organization;

    private String position;

    @Enumerated(EnumType.STRING)
    private RegionEnum region;

    private Character gender;

}
