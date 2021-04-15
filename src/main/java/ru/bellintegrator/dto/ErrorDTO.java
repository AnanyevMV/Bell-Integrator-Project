package ru.bellintegrator.dto;

/**
 * Класс DTO для сообщениях об ошибках
 */
public class ErrorDTO {

    private String error;

    /**
     * Конструктор без параметров класса ErrorDTO
     */
    public ErrorDTO() {

    }

    /**
     * Конструктор с параметрами класса ErrorDTO
     * @param error сообщение об ошибке
     */
    public ErrorDTO(String error) {
        this.error = error;
    }

    /**
     * Геттер для поля error
     * @return сообщение об ошибке
     */
    public String getError() {
        return error;
    }

    /**
     * Сеттер для поля error
     * @param error сообщение об ошибке
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Переопределение метода toString()
     * @return строковое представление объекта ErrorDTO
     */
    @Override
    public String toString() {
        return "ErrorDTO{" +
                "error='" + error + '\'' +
                '}';
    }
}
