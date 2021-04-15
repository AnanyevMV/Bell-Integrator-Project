package ru.bellintegrator.aop;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.bellintegrator.dto.DataDTO;
import ru.bellintegrator.dto.ErrorDTO;
import ru.bellintegrator.dto.SuccessDTO;

/**
 * Аспект, перехватывающий все ответы от методов контроллеров с аннотацией @ResponseBody.<br>
 * Метод также перехватывает все ResponseEntity от методов класса RestExceptionHandler, <br>
 * т.к. аннотация @RestControllerAdvice также помечена аннотацией @ResponseBody
 */
@RestControllerAdvice
public class RestResponseBodyHandler implements ResponseBodyAdvice<Object> {
    /**
     * Метод всегда возвращает true. Таким образом, метод beforeBodyWrite всегда будет вызываться для любых ответовв
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * Метод, отвечающий за предобработку HTTP-ответов<br>
     * В случае исключения метод вернет ErrorDTO<br>
     * В случае, когда исключения не произошло, то метод вернёт объект DataDTO, который<br>
     * оборачивает объект ответа. В случае, когда был вызван метод с параметром void в контроллере<br>
     * и не произошло ошибки, метод вернёт DataDTO, в который обернёт {"result" : "success"}
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
    Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
    ServerHttpResponse serverHttpResponse) {
        if (body instanceof ErrorDTO) {
            return body;
        }

        // Если метод void и не произошло ошибки, то возвращаем {"result" : "success"}
        if (methodParameter.getParameterType() == void.class) {
            return new DataDTO(new SuccessDTO());
        }

        return new DataDTO(body);
    }
}
