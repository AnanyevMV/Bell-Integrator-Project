package ru.bellintegrator.service.user;

import ru.bellintegrator.dto.UserDTO;

import java.util.List;

/**
 * Интерфейс сервиса для CRUD-операций, связанных с пользователями
 */
public interface UserService {
    /**
     * Метод позвволяет получить список пользователей
     *
     * @return список UserDTO
     */
    public List<UserDTO> getUsers();

    /**
     * Метод позволяет получить список пользователей согласно фильтру
     *
     * @param filter фильтр
     * @return список UserDTO
     */
    public List<UserDTO> getUsers(UserDTO filter);

    /**
     * Метод позволяет получить пользователя по его идентификатору
     *
     * @param id идентификатор пользователя
     * @return объект UserDTO
     */
    public UserDTO getUser(Long id);

    /**
     * Метод позволяет сохранить пользователя
     *
     * @param userDTO объект UserDTO
     */
    public void saveUser(UserDTO userDTO);

    /**
     * Метод позволяет обновить пользователя
     *
     * @param userDTO объект UserDTO
     */
    public void updateUser(UserDTO userDTO);
}
