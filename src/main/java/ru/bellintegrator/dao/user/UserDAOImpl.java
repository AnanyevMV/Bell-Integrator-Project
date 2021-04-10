package ru.bellintegrator.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.dto.UserDTO;
import ru.bellintegrator.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
        if (Objects.isNull(id)) {
            throw new UserNotFoundException("Не задано id пользователя");
        }
        User user = entityManager.find(User.class, id);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException("Нет пользователя с таким id " + id);
        }

        return user;
    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }

    @Override
    public void saveUser(UserDTO userDTO) {

    }
}
