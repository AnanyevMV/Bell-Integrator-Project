package ru.bellintegrator.exception;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(String message) {
        super(message);
    }
}
