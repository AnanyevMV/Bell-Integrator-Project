package ru.bellintegrator.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.dao.user.UserDAO;
import ru.bellintegrator.dto.UserDTO;
import ru.bellintegrator.dto.mapper.UserMapper;
import ru.bellintegrator.entity.Document;
import ru.bellintegrator.entity.User;
import ru.bellintegrator.exception.BadInputException;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public List<UserDTO> getUsers() {
        List<User> users = userDAO.getUsers();
        return userMapper.toDTOList(users);
    }

    @Override
    @Transactional
    public UserDTO getUser(Long id) {
        User user = userDAO.getUser(id);
        return userMapper.toDTO(user);
    }

    @Override
    @Transactional
    public void saveUser(UserDTO userDTO) {
        throwExceptionIfIsIdentifiedFieldIsNotTrueOrFalse(userDTO.getIsIdentified());
        userDTO.setId(null);
        User user = userMapper.toEntity(userDTO);
        userDAO.saveUser(user, userDTO.getOfficeId());
    }

    @Override
    @Transactional
    public void updateUser(UserDTO userDTO) {
        throwExceptionIfIsIdentifiedFieldIsNotTrueOrFalse(userDTO.getIsIdentified());
        User user = userMapper.toEntity(userDTO);
        userDAO.updateUser(user, userDTO.getOfficeId());
    }

    private void throwExceptionIfIsIdentifiedFieldIsNotTrueOrFalse(String isIdentified) {
        if (Objects.isNull(isIdentified)) {
            return;
        }
        if (!(isIdentified.equals("true") || isIdentified.equals("false"))) {
            throw new BadInputException("Значение поля 'isIdentified' должно быть 'true' или 'false'");
        }
    }
}
