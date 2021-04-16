package ru.bellintegrator.exception;

/**
 * Класс для исключений, связанных с неверными входными данными
 */
public class BadInputException extends RuntimeException {
    /**
     * Конструктор с параметром класса BadInputException
     *
     * @param message сообщение об ошибке
     */
    public BadInputException(String message) {
        super(message);
    }
}
