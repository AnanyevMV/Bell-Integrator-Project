package ru.bellintegrator.service.country;

import ru.bellintegrator.dto.CountryDTO;

import java.util.List;

/**
 * Интерфейс сервиса, который предоставляет список стран и их кодов
 */
public interface CountryService {
    /**
     * Метод позволяет получить список из названий стран и их кодов
     *
     * @return список CountryDTO
     */
    public List<CountryDTO> getCountries();
}
