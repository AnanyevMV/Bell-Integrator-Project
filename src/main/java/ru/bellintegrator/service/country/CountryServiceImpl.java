package ru.bellintegrator.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.dao.country.CountryDAO;
import ru.bellintegrator.dto.CountryDTO;
import ru.bellintegrator.dto.mapper.CountryMapper;
import ru.bellintegrator.entity.Country;

import java.util.List;

/**
 * Реализация интерфейса CountryService<br>
 * Сервиса предоставляет список стран и их кодов
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDAO countryDAO;

    private final CountryMapper countryMapper;

    /**
     * Конструктор класса CountryServiceImpl
     *
     * @param countryDAO DAO объект для стран
     * @param countryMapper объект для маппинга между Country и CountryDTO
     */
    @Autowired
    public CountryServiceImpl(CountryDAO countryDAO, CountryMapper countryMapper) {
        this.countryDAO = countryDAO;
        this.countryMapper = countryMapper;
    }

    /**
     * Метод позволяет получить список из названий стран и их кодов
     *
     * @return список CountryDTO
     */
    @Override
    @Transactional
    public List<CountryDTO> getCountries() {
        List<Country> countries = countryDAO.getCountries();
        return countryMapper.toDTOList(countries);
    }
}
