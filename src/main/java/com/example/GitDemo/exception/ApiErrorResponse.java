package com.example.GitDemo.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiErrorResponse {

    private String message;
    private String error;
    private int status;
    private String path;
    private LocalDateTime timestamp;


}
