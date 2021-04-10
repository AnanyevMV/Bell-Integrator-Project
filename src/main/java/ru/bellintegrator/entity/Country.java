package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    private Country() {

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
