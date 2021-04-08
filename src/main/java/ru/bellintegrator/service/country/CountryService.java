package ru.bellintegrator.service.country;

import ru.bellintegrator.dto.CountryDTO;
import ru.bellintegrator.entity.Country;

import java.util.List;

public interface CountryService {
    public List<CountryDTO> getCountries();
}
