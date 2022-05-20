package com.example.adminservice.payload;

import com.example.adminservice.entity.Event;
import com.example.adminservice.entity.Template;
import com.example.adminservice.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeatDto {
    private String name;
    private Double price; // narxi
    private Integer eventId;
    private Integer raw;
    private Integer templateId;
    private Status status = Status.EMPTY;
    private Date bookedDate;
    private Date expireDate;

}
