package ru.bellintegrator.dao.user;

import ru.bellintegrator.entity.Document;
import ru.bellintegrator.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUsers();

    public User getUser(Long id);

    public void updateUser(User user, Long officeId);

    public void saveUser(User user, Long officeId);
}
