package com.example.adminservice.payload;

import com.example.adminservice.entity.Attachment;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SpeakerDTO {

    private Integer attachmentId;

    @NotNull(message = "Speaker name required")
    private String firstName;

    @NotNull(message = "Speaker surname required")
    private String lastName;

    private String middleName;

    private String companyName;

    private String position;

    private String bio;

    @NotNull(message = "Phone number required")
    private String phoneNumber;

    @Column(nullable = false)
    private boolean active = true;
}
