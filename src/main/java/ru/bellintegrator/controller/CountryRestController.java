package ru.bellintegrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.entity.Country;
import ru.bellintegrator.service.CountryService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CountryRestController {

    private final CountryService countryService;

    @Autowired
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/countries")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }
}
