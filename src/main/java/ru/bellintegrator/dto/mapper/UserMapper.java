package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.UserDTO;
import ru.bellintegrator.entity.User;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements Mapper<User, UserDTO> {

    private ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void mapperSettings() {
        modelMapper.typeMap(UserDTO.class, User.class).addMappings(mapper ->
                mapper.using(Mapper.booleanStrToIntegerConverter()).map(UserDTO::getIsIdentified, User::setIsIdentified));

        modelMapper.typeMap(User.class, UserDTO.class).addMappings(mapper ->{
            mapper.using(Mapper.booleanIntegerToStrConverter()).map(User::getIsIdentified, UserDTO::setIsIdentified);
            mapper.map(m->m.getOffice().getId(), UserDTO::setOfficeId);
            mapper.map(m->m.getDocument().getDocCode(), UserDTO::setDocCode);
            mapper.map(m->m.getDocument().getDocNumber(), UserDTO::setDocNumber);
            mapper.map(m->m.getDocument().getDocDate(), UserDTO::setDocDate);
        });
    }

    @Override
    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserDTO toDTO(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public List<User> toEntityList(List<UserDTO> dtoList) {
        return dtoList.stream().map(dto -> modelMapper.map(dto, User.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> toDTOList(List<User> entityList) {
        return entityList.stream().map(entity -> modelMapper.map(entity, UserDTO.class)).collect(Collectors.toList());
    }
}
