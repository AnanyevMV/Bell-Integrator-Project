package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.UserDTO;
import ru.bellintegrator.entity.Document;
import ru.bellintegrator.entity.User;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс UserMapper для маппинга между User и UserDTO
 */
@Component
public class UserMapper implements Mapper<User, UserDTO> {

    private ModelMapper modelMapper;

    /**
     * Конструктор класса UserMapper
     *
     * @param modelMapper объект класса ModelMapper
     */
    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Настройки объекта ModelMapper для обработки нетривиальных ситуаций.
     */
    @PostConstruct
    private void mapperSettings() {
        modelMapper.typeMap(UserDTO.class, User.class).addMappings(mapper -> {
            mapper.using(Mapper.booleanStrToIntegerConverter()).map(UserDTO::getIsIdentified, User::setIsIdentified);
        });
        modelMapper.typeMap(UserDTO.class, User.class).addMappings(new PropertyMap<UserDTO, User>() {
            @Override
            protected void configure() {
                this.using((MappingContext<UserDTO, Document> mappingContext) -> {
                    Date docDate = null;
                    if (Objects.nonNull( mappingContext.getSource().getDocDate())) {
                        docDate = Date.valueOf(mappingContext.getSource().getDocDate());
                    }
                    return new Document(mappingContext.getSource().getDocCode(),
                            mappingContext.getSource().getDocNumber(), docDate);
                }).map(source, destination.getDocument());

            }
        });
        modelMapper.typeMap(User.class, UserDTO.class).addMappings(mapper ->{
            mapper.using(Mapper.booleanIntegerToStrConverter()).map(User::getIsIdentified, UserDTO::setIsIdentified);
            mapper.map(m->m.getOffice().getId(), UserDTO::setOfficeId);
            mapper.map(m->m.getDocument().getDocCode(), UserDTO::setDocCode);
            mapper.map(m->m.getDocument().getDocNumber(), UserDTO::setDocNumber);
            mapper.map(m->m.getDocument().getDocDate(), UserDTO::setDocDate);
        });
    }

    /**
     * Маппинг из UserDTO в User
     *
     * @param dto объект UserDTO
     * @return объект User
     */
    @Override
    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    /**
     * Маппинг из User в UserDTO
     *
     * @param entity объект User
     * @return объект UserDTO
     */
    @Override
    public UserDTO toDTO(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    /**
     * Маппинг из списка UserDTO в список User
     *
     * @param dtoList список UserDTO
     * @return список User
     */
    @Override
    public List<User> toEntityList(List<UserDTO> dtoList) {
        return dtoList.stream().map(dto -> modelMapper.map(dto, User.class)).collect(Collectors.toList());
    }

    /**
     * Маппинг из списка User в список UserDTO
     *
     * @param entityList список User
     * @return список UserDTO
     */
    @Override
    public List<UserDTO> toDTOList(List<User> entityList) {
        return entityList.stream().map(entity -> modelMapper.map(entity, UserDTO.class)).collect(Collectors.toList());
    }
}
