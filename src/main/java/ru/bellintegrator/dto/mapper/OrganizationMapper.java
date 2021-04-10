package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.entity.Organization;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizationMapper implements Mapper<Organization, OrganizationDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public OrganizationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void mapperSettings() {
        modelMapper.typeMap(OrganizationDTO.class, Organization.class).addMappings(mapper ->
        mapper.using(Mapper.booleanStrToIntegerConverter()).map(OrganizationDTO::getIsActive, Organization::setIsActive));

        modelMapper.typeMap(Organization.class, OrganizationDTO.class).addMappings(mapper ->
        mapper.using(Mapper.booleanIntegerToStrConverter()).map(Organization::getIsActive, OrganizationDTO::setIsActive));
    }

    @Override
    public Organization toEntity(OrganizationDTO dto) {
        return modelMapper.map(dto, Organization.class);
    }

    @Override
    public OrganizationDTO toDTO(Organization entity) {
        return modelMapper.map(entity, OrganizationDTO.class);
    }

    @Override
    public List<Organization> toEntityList(List<OrganizationDTO> dtoList) {
        return dtoList.stream().map(dto -> modelMapper.map(dto, Organization.class)).collect(Collectors.toList());
    }

    @Override
    public List<OrganizationDTO> toDTOList(List<Organization> entityList) {
        return entityList.stream().map(organization ->
        modelMapper.map(organization, OrganizationDTO.class)).collect(Collectors.toList());
    }
}
