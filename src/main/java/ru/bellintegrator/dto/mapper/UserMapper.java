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
