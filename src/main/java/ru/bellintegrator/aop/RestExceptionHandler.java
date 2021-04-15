package ru.bellintegrator.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.exception.OfficeException;
import ru.bellintegrator.exception.OrganizationException;
import ru.bellintegrator.exception.BadInputException;
import ru.bellintegrator.dto.ErrorDTO;
import ru.bellintegrator.exception.UserException;

/**
 * Обработчик исключений, который обрабатывает все исключения, которые возникли в контроллерах
 */
@RestControllerAdvice
public class RestExceptionHandler{
    /**
     * Метод обрабатывает те исключения, которые не были перехвачены другими обработчиками исключений
     * @param exception Общее исключение
     * @return ResponseEntity - объект, который отвечает за тело, заголовки и статус HTTP-запроса
     */
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleGeneralException(Exception exception) {
        ErrorDTO errorDTO = new ErrorDTO("BAD REQUEST");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Метод обрабатывает исключения, связанные с органнизациями
     * @param exc исключение, связанное с организациями
     * @return ResponseEntity - объект, который отвечает за тело, заголовки и статус HTTP-запроса
     */
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleOrganizationException(OrganizationException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Метод обрабатывает исключения, связанные с офисами
     * @param exc исключение, связанное с офисами
     * @return ResponseEntity - объект, который отвечает за тело, заголовки и статус HTTP-запроса
     */
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleOfficeException(OfficeException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Метод обрабатывает исключения, связанные с пользователями
     * @param exc исключение, связанное с пользователями
     * @return ResponseEntity - объект, который отвечает за тело, заголовки и статус HTTP-запроса
     */
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleUserException(UserException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }



    /**
     * Метод обрабатывает исключения, связанные с неверными входными данными
     * @param exc исключение, связанное с неверными входными данными
     * @return ResponseEntity - объект, который отвечает за тело, заголовки и статус HTTP-запроса
     */
    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleBadInputException(BadInputException exc) {
        ErrorDTO errorDTO = new ErrorDTO(exc.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
