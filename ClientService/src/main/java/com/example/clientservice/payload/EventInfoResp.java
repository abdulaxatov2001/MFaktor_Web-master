package com.example.clientservice.payload;

import com.example.clientservice.entity.Event;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EventInfoResp {
    private Integer allSeats;
    private Integer soldSeats;
    private Integer emptySeats;
    private Event event;
    private double summ;
}
