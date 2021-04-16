package ru.bellintegrator.exception;

/**
 * Класс для исключений, связанных с пользователями
 */
public class UserException extends RuntimeException {
    /**
     * Конструктор с параметром класса UserException
     *
     * @param message сообщение об ошибке
     */
    public UserException(String message) {
        super(message);
    }

    /**
     * Конструктор с параметрами класса UserException
     *
     * @param message сообщение об ошибке
     * @param cause причина ошибки
     */
    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
