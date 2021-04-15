package ru.bellintegrator.controller.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.dto.CountryDTO;
import ru.bellintegrator.service.country.CountryService;

import java.util.List;


/**
 * REST-контроллер, отвечающий за страны.<br>
 * Данный контроллер содержит единственный метод, обрабатывающий GET-запрос /api/countries <br>
 * Выходные данные этого метода являются справочными данными о странах и их кодах.
 */
@RestController
@RequestMapping(value = "/api")
public class CountryRestController {

    /**
     * У контроллера имеется зависимость CountryService, которая возвращает список CountryDTO
     */
    private final CountryService countryService;

    /**
     * Конструктор класса CountryRestController. Используется внедрение зависимости CountryService через конструктор.
     * @param countryService - сервис, возвращающий список CountryDTO
     */
    @Autowired
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Справочный метод контроллера, возвращающий страны и их коды.
     * @return список стран и их кодов
     */
    @GetMapping(value = "/countries")
    public List<CountryDTO> getCountries() {
        return countryService.getCountries();
    }
}
