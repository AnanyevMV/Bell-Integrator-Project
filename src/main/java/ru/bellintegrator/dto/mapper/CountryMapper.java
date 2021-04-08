package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.CountryDTO;
import ru.bellintegrator.entity.Country;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CountryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Country toEntity(CountryDTO countryDTO) {
        return modelMapper.map(countryDTO, Country.class);
    }

    public CountryDTO toDTO(Country country) {
        return modelMapper.map(country, CountryDTO.class);
    }

    public List<Country> toEntityList(List<CountryDTO> countryDTOList) {
        return countryDTOList.stream().
        map(countryDTO -> modelMapper.map(countryDTO, Country.class)).collect(Collectors.toList());
    }

    public List<CountryDTO> toDTOList(List<Country> countryList) {
        return countryList.stream().
        map(country -> modelMapper.map(country, CountryDTO.class)).collect(Collectors.toList());
    }

}
