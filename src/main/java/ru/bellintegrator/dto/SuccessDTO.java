package ru.bellintegrator.dto;

/**
 * Класс SuccessDTO служит для возврата, если void методы в контроллерах отработали без ошибок
 */
public class SuccessDTO {

    /**
     * Сообщение по-умолчанию - "success"
     */
    private String result = "success";

    /**
     * Конструктор без параметров класса SuccessDTO
     */
    public SuccessDTO() {

    }

    /**
     * Конструктор с параметром класса SuccessDTO
     * @param result сообщение о результате
     */
    public SuccessDTO(String result) {
        this.result = result;
    }

    /**
     * Геттер для поля result
     * @return результат
     */
    public String getResult() {
        return result;
    }

    /**
     * Сеттер для поля result
     * @param result результат
     */
    public void setResult(String result) {
        this.result = result;
    }
}
