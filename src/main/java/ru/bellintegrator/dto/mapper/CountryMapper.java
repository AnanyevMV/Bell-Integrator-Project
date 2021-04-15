package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.CountryDTO;
import ru.bellintegrator.entity.Country;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс CountryMapper для маппинга между Country и CountryDTO
 */
@Component
public class CountryMapper implements Mapper<Country, CountryDTO> {

    private final ModelMapper modelMapper;

    /**
     * Конструктор класса CountryMapper
     * @param modelMapper объект класса ModelMapper
     */
    @Autowired
    public CountryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Маппинг из CountryDTO в Country
     * @param countryDTO объект CountryDTO
     * @return объект Country
     */
    @Override
    public Country toEntity(CountryDTO countryDTO) {
        return modelMapper.map(countryDTO, Country.class);
    }

    /**
     * Маппинг из Country в CountryDTO
     * @param country объект Country
     * @return объект CountryDTO
     */
    @Override
    public CountryDTO toDTO(Country country) {
        return modelMapper.map(country, CountryDTO.class);
    }

    /**
     * Маппинг из списка CountryDTO в список Country
     * @param countryDTOList список CountryDTO
     * @return список Country
     */
    @Override
    public List<Country> toEntityList(List<CountryDTO> countryDTOList) {
        return countryDTOList.stream().
        map(countryDTO -> modelMapper.map(countryDTO, Country.class)).collect(Collectors.toList());
    }

    /**
     * Маппинг из списка Country в список CountryDTO
     * @param countryList список Country
     * @return список CountryDTO
     */
    @Override
    public List<CountryDTO> toDTOList(List<Country> countryList) {
        return countryList.stream().
        map(country -> modelMapper.map(country, CountryDTO.class)).collect(Collectors.toList());
    }

}
