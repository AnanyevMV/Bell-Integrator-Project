package ru.bellintegrator.dto;

/**
 * Класс-обёртка для возврата объекта в RestResponseBodyHandler.<br>
 * Формат JSON'a будет {"data" : {*JSON из Object*}}
 */
public class DataDTO {
    private Object data;

    /**
     * Конструктор без параметров класса DataDTO
     */
    public DataDTO() {

    }

    /**
     * Конструктор с параметром Object класса DataDTO
     * @param data любой объект, который будет обёрнут.
     */
    public DataDTO(Object data) {
        this.data = data;
    }

    /**
     * Геттер для поля data
     * @return любой объект, что был обёрнут
     */
    public Object getData() {
        return data;
    }

    /**
     * Сеттер для поля data
     * @param data любой объект, предназначенный для обёртки
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Переопределение метода toString()
     * @return строковое представление объекта DataDTO
     */
    @Override
    public String toString() {
        return "DataDTO{" +
                "data=" + data +
                '}';
    }
}
