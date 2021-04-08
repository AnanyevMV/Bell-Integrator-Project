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

@RestControllerAdvice
public class RestResponseBodyHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

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

        DataDTO dataDTO = new DataDTO(body);
        return dataDTO;
    }
}
