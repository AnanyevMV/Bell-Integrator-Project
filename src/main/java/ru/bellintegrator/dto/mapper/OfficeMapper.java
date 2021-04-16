package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.OfficeDTO;
import ru.bellintegrator.entity.Office;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс OfficeMapper для маппинга между Office и OfficeDTO
 */
@Component
public class OfficeMapper implements Mapper<Office, OfficeDTO> {

    private final ModelMapper modelMapper;

    /**
     * Конструктор класса OfficeMapper
     *
     * @param modelMapper объект класса ModelMapper
     */
    @Autowired
    public OfficeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Настройки объекта ModelMapper для обработки нетривиальных ситуаций.
     */
    @PostConstruct
    private void mapperSettings() {
        modelMapper.typeMap(OfficeDTO.class, Office.class).addMappings(mapper ->
        mapper.using(Mapper.booleanStrToIntegerConverter()).map(OfficeDTO::getIsActive, Office::setIsActive));

        modelMapper.typeMap(Office.class, OfficeDTO.class).addMappings(mapper ->{
            mapper.using(Mapper.booleanIntegerToStrConverter()).map(Office::getIsActive, OfficeDTO::setIsActive);
            mapper.map(m->m.getOrganization().getId(), OfficeDTO::setOrgId);
        });
    }

    /**
     * Маппинг из OfficeDTO в Office
     *
     * @param dto объект OfficeDTO
     * @return объект Office
     */
    @Override
    public Office toEntity(OfficeDTO dto) {
        return modelMapper.map(dto, Office.class);
    }

    /**
     * Маппинг из Office в OfficeDTO
     *
     * @param entity объект Office
     * @return объект OfficeDTO
     */
    @Override
    public OfficeDTO toDTO(Office entity) {
        return modelMapper.map(entity, OfficeDTO.class);
    }

    /**
     * Маппинг из списка OfficeDTO в список Office
     *
     * @param dtoList объект OfficeDTO
     * @return список Office
     */
    @Override
    public List<Office> toEntityList(List<OfficeDTO> dtoList) {
        return dtoList.stream().map
        (officeDTO -> modelMapper.map(officeDTO, Office.class)).collect(Collectors.toList());
    }

    /**
     * Маппинг из списка Office в список OfficeDTO
     *
     * @param entityList список Office
     * @return список OfficeDTO
     */
    @Override
    public List<OfficeDTO> toDTOList(List<Office> entityList) {
        return entityList.stream().map
        (office -> modelMapper.map(office, OfficeDTO.class)).collect(Collectors.toList());
    }
}
