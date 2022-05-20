package com.example.adminservice.payload;

import com.example.adminservice.entity.Attachment;
import com.example.adminservice.entity.Speaker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDto {
    private Integer attachmentId;
    private String name;
    private Integer speakerId;
    private String description;
    private Timestamp startTime;
    private Boolean byPlace;
    private Integer templateId;
}
