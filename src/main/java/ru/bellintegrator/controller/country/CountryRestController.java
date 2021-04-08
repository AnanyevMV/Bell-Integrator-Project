package ru.bellintegrator.controller.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.dto.CountryDTO;
import ru.bellintegrator.service.country.CountryService;

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
    public List<CountryDTO> getCountries() {
    //        if (true) {
    //            throw new RuntimeException();
    //        }
        return countryService.getCountries();
    }
}
