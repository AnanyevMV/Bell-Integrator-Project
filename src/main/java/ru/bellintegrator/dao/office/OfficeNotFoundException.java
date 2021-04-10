package ru.bellintegrator.dao.office;

public class OfficeNotFoundException extends RuntimeException {
    public OfficeNotFoundException(String message) {
        super(message);
    }
}
