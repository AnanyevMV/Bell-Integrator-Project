package ru.bellintegrator.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.dao.country.CountryDAO;
import ru.bellintegrator.dto.CountryDTO;
import ru.bellintegrator.dto.mapper.CountryMapper;
import ru.bellintegrator.entity.Country;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDAO countryDAO;

    private final CountryMapper countryMapper;

    @Autowired
    public CountryServiceImpl(CountryDAO countryDAO, CountryMapper countryMapper) {
        this.countryDAO = countryDAO;
        this.countryMapper = countryMapper;
    }

    @Override
    public List<CountryDTO> getCountries() {
        List<Country> countries = countryDAO.getCountries();
        return countryMapper.toDTOList(countries);
    }
}
