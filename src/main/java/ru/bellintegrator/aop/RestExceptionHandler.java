package ru.bellintegrator.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.exception.OfficeNotFoundException;
import ru.bellintegrator.exception.OrganizationNotFoundException;
import ru.bellintegrator.exception.BadInputException;
import ru.bellintegrator.dto.ErrorDTO;

@RestControllerAdvice
public class RestExceptionHandler{
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleGeneralException(Exception exception) {
        ErrorDTO errorDTO = new ErrorDTO("BAD REQUEST");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleOrganizationNotFoundException(OrganizationNotFoundException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleOfficeNotFoundException(OfficeNotFoundException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleBadInputException(BadInputException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
