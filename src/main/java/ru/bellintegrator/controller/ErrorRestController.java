package ru.bellintegrator.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-контроллер, отвечающий за переопределение стандартной html-страницы ошибки
 */
@RestController
public class ErrorRestController implements ErrorController {
    /**
     * Метод переопределяет стандартную html-страницу ошибки<br>
     * Метод выбрасывает ошибку RuntimeException, которая будет перехвачена RestExceptionHandler'ом.<br>
     * RestExceptionHandler перехватит ошибку и вернёт ResponseEntity&lt;ErrorDTO&gt; с сообщением 'BAD REQUEST'
     */
    @RequestMapping("/error")
    public void handleError() {
        throw new RuntimeException();
    }

    /**
     * Данный метод является @Deprecated.<br>
     * Путь содержится в property 'server.error.path=/error'
     */
    @Override
    public String getErrorPath() {
        return null;
    }
}
