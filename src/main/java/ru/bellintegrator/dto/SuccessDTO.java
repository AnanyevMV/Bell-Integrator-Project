package ru.bellintegrator.dto;

public class SuccessDTO {
    private String result = "success";

    public SuccessDTO() {

    }

    public SuccessDTO(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
