package com.example.adminservice.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponse {
    private String message;
    private boolean success;
    private Object data;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

}