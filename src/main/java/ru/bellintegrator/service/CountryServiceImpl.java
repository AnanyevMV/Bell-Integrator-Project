package ru.bellintegrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.dao.CountryDAO;
import ru.bellintegrator.entity.Country;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDAO countryDAO;

    @Autowired
    public CountryServiceImpl(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Override
    public List<Country> getCountries() {
        return countryDAO.getCountries();
    }
}
