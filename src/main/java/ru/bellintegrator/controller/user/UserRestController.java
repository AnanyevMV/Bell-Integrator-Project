package ru.bellintegrator.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.dto.UserDTO;
import ru.bellintegrator.service.user.UserService;

import java.util.List;

/**
 * REST-контроллер, отвечающий за REST-запросы, связанные с пользователями
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

    /**
     * У контроллера имеется зависимость userService - сервис, предоставляющий методы для<br>
     * получения, сохранения и обновления пользователей.
     */
    private final UserService userService;

    /**
     * Конструктор класса UserRestController. Используется внедрение зависимости userService<br>
     * через конструктор
     *
     * @param userService - сервис для получения, сохранения, обновления пользователей.
     */
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Метод обрабатывает GET-запрос для получения списка всех пользователей.
     *
     * @return список UserDTO
     */
    @GetMapping("/user/list")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    /**
     * Метод обрабатывает POST-запрос для получения списка пользователей по фильтру
     *
     * @param filter фильтр
     * @return список UserDTO
     */
    @PostMapping("/user/list")
    public List<UserDTO> getUsers(@RequestBody UserDTO filter) {
        return userService.getUsers(filter);
    }

    /**
     * Метод обрабатывает GET-запрос для получения пользователя по его идентификатору
     *
     * @param id идентификатор пользователя
     * @return UserDTO
     */
    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    /**
     * Метод обрабатывает POST-запрос для сохранения пользователя
     *
     * @param userDTO DTO-объект, полученный из тела HTTP-запроса
     */
    @PostMapping("/user/save")
    public void saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    /**
     * Метод обрабатывает PUT-запрос для обновления пользователя
     *
     * @param userDTO DTO-объект, полученный из тела HTTP-запроса
     */
    @PutMapping("/user/update")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }
    
}
