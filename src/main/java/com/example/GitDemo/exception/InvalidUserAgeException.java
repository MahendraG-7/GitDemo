package com.example.GitDemo.exception;

public class InvalidUserAgeException extends RuntimeException {
    public InvalidUserAgeException(String message) {
        super(message);
    }
}
