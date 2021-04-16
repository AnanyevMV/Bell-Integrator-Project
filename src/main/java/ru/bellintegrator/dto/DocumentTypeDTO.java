package ru.bellintegrator.dto;

/**
 * Класс DocumentTypeDTO отвечает за DTO объекты типов документов
 */
public class DocumentTypeDTO {
    /**
     * Название документа
     */
    private String name;

    /**
     * Код документа
     */
    private String code;

    /**
     * Конструктор без параметров класса DocumentTypeDTO
     */
    public DocumentTypeDTO() {

    }

    /**
     * Конструктор с параметрами класса DocumentTypeDTO
     *
     * @param name название документа
     * @param code код документа
     */
    public DocumentTypeDTO(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * Геттер для поля name
     *
     * @return название документа
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для поля name
     *
     * @param name название документа
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер для поля code
     *
     * @return код документа
     */
    public String getCode() {
        return code;
    }

    /**
     * Сеттер для поля code
     *
     * @param code код документа
     */
    public void setCode(String code) {
        this.code = code;
    }
}
