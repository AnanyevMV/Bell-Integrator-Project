package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.entity.Organization;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс OrganizationMapper для маппинга между Organization и OrganizationDTO
 */
@Component
public class OrganizationMapper implements Mapper<Organization, OrganizationDTO> {

    private final ModelMapper modelMapper;

    /**
     * Конструктор класса OrganizationMapper
     * @param modelMapper объект класса ModelMapper
     */
    @Autowired
    public OrganizationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Настройки объекта ModelMapper для обработки нетривиальных ситуаций.
     */
    @PostConstruct
    private void mapperSettings() {
        modelMapper.typeMap(OrganizationDTO.class, Organization.class).addMappings(mapper ->
        mapper.using(Mapper.booleanStrToIntegerConverter()).map(OrganizationDTO::getIsActive, Organization::setIsActive));

        modelMapper.typeMap(Organization.class, OrganizationDTO.class).addMappings(mapper ->
        mapper.using(Mapper.booleanIntegerToStrConverter()).map(Organization::getIsActive, OrganizationDTO::setIsActive));
    }

    /**
     * Маппинг из OrganizationDTO в Organization
     * @param dto объект OrganizationDTO
     * @return объект Organization
     */
    @Override
    public Organization toEntity(OrganizationDTO dto) {
        return modelMapper.map(dto, Organization.class);
    }

    /**
     * Маппинг из Organization в OrganizationDTO
     * @param entity объект Organization
     * @return объект OrganizationDTO
     */
    @Override
    public OrganizationDTO toDTO(Organization entity) {
        return modelMapper.map(entity, OrganizationDTO.class);
    }

    /**
     * Маппинг из списка OrganizationDTO в список Organization
     * @param dtoList список OrganizationDTO
     * @return список Organization
     */
    @Override
    public List<Organization> toEntityList(List<OrganizationDTO> dtoList) {
        return dtoList.stream().map(dto -> modelMapper.map(dto, Organization.class)).collect(Collectors.toList());
    }

    /**
     * Маппинг из списка Organization в список OrganizationDTO
     * @param entityList список Organization
     * @return список OrganizationDTO
     */
    @Override
    public List<OrganizationDTO> toDTOList(List<Organization> entityList) {
        return entityList.stream().map(organization ->
        modelMapper.map(organization, OrganizationDTO.class)).collect(Collectors.toList());
    }
}
