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

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/list")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/user/save")
    public void saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    @PutMapping("/user/update")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }
}
