package ru.bellintegrator.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.dto.ErrorDTO;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleGeneralException(Exception exception) {
        ErrorDTO errorDTO = new ErrorDTO("BAD REQUEST");
        return new ResponseEntity<>(errorDTO,HttpStatus.BAD_REQUEST);
    }
}
