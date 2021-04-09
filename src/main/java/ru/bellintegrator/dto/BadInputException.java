package ru.bellintegrator.dto;

public class BadInputException extends RuntimeException {
    public BadInputException(String message) {
        super(message);
    }
}
