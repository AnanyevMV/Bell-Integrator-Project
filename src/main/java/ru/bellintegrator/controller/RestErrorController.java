package ru.bellintegrator.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestErrorController implements ErrorController {
    @RequestMapping("/error")
    public void handleError() {
        throw new RuntimeException();
    }

    @Override
    public String getErrorPath() {
        // Метод deprecated, путь берется из property server.error.path=/error
        return null;
    }
}
