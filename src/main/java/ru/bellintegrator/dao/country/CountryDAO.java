package ru.bellintegrator.dao.country;

import ru.bellintegrator.entity.Country;
import java.util.List;

/**
 * Интерфейс CountryDAO определяет методы, которые должен реализовывать DAO-класс стран
 */
public interface CountryDAO {
    /**
     * Метод позволяет получить список всех стран
     *
     * @return список Country
     */
    public List<Country> getCountries();
}
