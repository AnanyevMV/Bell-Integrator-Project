package ru.bellintegrator.exception;

public class OrganizationException extends RuntimeException {
    public OrganizationException(String message) {
        super(message);
    }

    public OrganizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
