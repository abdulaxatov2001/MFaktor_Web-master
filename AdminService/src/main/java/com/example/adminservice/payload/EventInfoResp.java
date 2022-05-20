package com.example.adminservice.payload;


import com.example.adminservice.entity.Event;
import com.example.adminservice.entity.Seat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class EventInfoResp {
    private Integer allSeats;
    private Integer soldSeats;
    private Integer emptySeats;
    private List<Seat> seats;
    private Event event;
    private double summ;
}
