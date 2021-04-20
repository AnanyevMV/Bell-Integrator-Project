package ru.bellintegrator.dao.user;

import ru.bellintegrator.entity.User;
import java.util.List;

/**
 * Интерфейс UserDAO определяет методы, которые должен реализовывать DAO-класс пользователей
 */
public interface UserDAO {

    /**
     * Метод позволяет получить список всех пользователей
     *
     * @return список User
     */
    public List<User> getUsers();

    /**
     * Метод позволяет получить список пользователей по фильтру
     *
     * @param filter фильтр
     * @return список User
     */
    public List<User> getUsers(User filter);

    /**
     * Метод позволяет получить пользователя по его идентификатору
     *
     * @param id идентификатор пользователя
     * @return объект User
     */
    public User getUser(Long id);

    /**
     * Метод позволяет обновить информацию о пользователе
     *
     * @param user объект User
     * @param officeId идентификатор офиса
     */
    public void updateUser(User user, Long officeId);

    /**
     * Метод позволяет сохранить информацию о пользователе
     *
     * @param user объект User
     * @param officeId идентификатор офиса
     */
    public void saveUser(User user, Long officeId);
}
