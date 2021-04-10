package ru.bellintegrator.service.user;

import ru.bellintegrator.dto.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> getUsers();
    public UserDTO getUser(Long id);
    public void saveUser(UserDTO userDTO);
    public void updateUser(UserDTO userDTO);
}
