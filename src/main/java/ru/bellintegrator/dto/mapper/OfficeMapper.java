package ru.bellintegrator.dto.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.BadInputException;
import ru.bellintegrator.dto.OfficeDTO;
import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.entity.Office;
import ru.bellintegrator.entity.Organization;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfficeMapper implements Mapper<Office, OfficeDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public OfficeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void mapperSettings() {
        modelMapper.typeMap(OfficeDTO.class, Office.class).addMappings(mapper ->
        mapper.using(Mapper.booleanStrToIntegerConverter()).map(OfficeDTO::getIsActive, Office::setIsActive));

        modelMapper.typeMap(Office.class, OfficeDTO.class).addMappings(mapper ->{
            mapper.using(Mapper.booleanIntegerToStrConverter()).map(Office::getIsActive, OfficeDTO::setIsActive);
            mapper.map(m->m.getOrganization().getId(), OfficeDTO::setOrgId);
        });
    }

    @Override
    public Office toEntity(OfficeDTO dto) {
        return modelMapper.map(dto, Office.class);
    }

    @Override
    public OfficeDTO toDTO(Office entity) {
        return modelMapper.map(entity, OfficeDTO.class);
    }

    @Override
    public List<Office> toEntityList(List<OfficeDTO> dtoList) {
        return dtoList.stream().map
        (officeDTO -> modelMapper.map(officeDTO, Office.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfficeDTO> toDTOList(List<Office> entityList) {
        return entityList.stream().map
        (office -> modelMapper.map(office, OfficeDTO.class)).collect(Collectors.toList());
    }
}
