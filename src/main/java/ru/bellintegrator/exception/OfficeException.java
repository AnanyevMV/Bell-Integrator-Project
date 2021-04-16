package ru.bellintegrator.exception;

/**
 * Класс для исключений, связанных с офисами
 */
public class OfficeException extends RuntimeException {
    /**
     * Конструктор с параметром класса OfficeException
     *
     * @param message сообщение об ошибке
     */
    public OfficeException(String message) {
        super(message);
    }
}
