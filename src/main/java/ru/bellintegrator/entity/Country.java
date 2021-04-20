package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity-класс стран
 */
@Entity
@Table(name = "country")
@NamedQueries(value = {
    @NamedQuery(name = "Country.getAll", query = "select c from Country c"),
    @NamedQuery(name = "Country.checkCitizenshipCode", query = "select c from Country c where c.code = :citizenshipCode")
})

public class Country {
    /**
     * Код страны
     */
    @Id
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    /**
     * Название страны
     */
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /**
     * Конструктор класса Country
     */
    private Country() {

    }

    /**
     * Геттер для поля code
     *
     * @return код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Геттер для поля name
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    /**
     * Переопределение метода toString()
     *
     * @return строковое представление объекта Country
     */
    @Override
    public String toString() {
        return "Country{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
