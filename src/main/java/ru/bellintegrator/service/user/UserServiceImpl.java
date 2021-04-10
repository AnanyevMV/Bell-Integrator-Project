package ru.bellintegrator.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.dao.user.UserDAO;
import ru.bellintegrator.dto.UserDTO;
import ru.bellintegrator.dto.mapper.UserMapper;
import ru.bellintegrator.entity.User;

import java.util.List;

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
        userDTO.setId(null);
        userDAO.saveUser(userDTO);
    }

    @Override
    @Transactional
    public void updateUser(UserDTO userDTO) {
        userDAO.updateUser(userDTO);
    }
}
