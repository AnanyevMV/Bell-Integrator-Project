package ru.bellintegrator.dto;

/**
 * Класс CountryDTO отвечает за DTO объекты стран
 */
public class CountryDTO {
    /**
     * Название страны
     */
    private String name;
    /**
     * Код страны
     */
    private String code;

    /**
     * Конструктор без параметров класса CountryDTO
     */
    public CountryDTO() {

    }

    /**
     * Конструктор с параметрами класса CountryDTO
     *
     * @param name название страны
     * @param code код страны
     */
    public CountryDTO(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * Геттер для названия страны
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для названия страны
     *
     * @param name название страны
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер для кода страны
     *
     * @return код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Сеттер для кода страны
     *
     * @param code код страны
     */
    public void setCode(String code) {
        this.code = code;
    }
}
