package com.example.adminservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventResponse {
    private Integer attachmentId;
    private String name;
    private String speaker;
    private Integer placeCapacity;
    private Integer unsold;
    private Double totalSum;
    private Timestamp startTime;

}
