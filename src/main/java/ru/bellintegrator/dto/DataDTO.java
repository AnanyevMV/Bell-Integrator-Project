package ru.bellintegrator.dto;

public class DataDTO {
    private Object data;

    public DataDTO() {

    }

    public DataDTO(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "data=" + data +
                '}';
    }
}
