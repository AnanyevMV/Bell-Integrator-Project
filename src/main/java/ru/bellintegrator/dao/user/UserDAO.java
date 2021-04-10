package ru.bellintegrator.dao.user;

import ru.bellintegrator.dto.UserDTO;
import ru.bellintegrator.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUsers();

    public User getUser(Long id);

    public void updateUser(UserDTO userDTO);

    public void saveUser(UserDTO userDTO);
}
