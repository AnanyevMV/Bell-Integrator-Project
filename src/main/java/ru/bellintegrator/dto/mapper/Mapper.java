package ru.bellintegrator.dto.mapper;

import org.modelmapper.Converter;
import ru.bellintegrator.exception.BadInputException;

import java.util.List;
import java.util.Objects;

public interface Mapper<E, D> {

    public E toEntity(D dto);
    public D toDTO(E entity);
    public List<E> toEntityList(List<D> dtoList);
    public List<D> toDTOList(List<E> entityList);

    public static Converter<String, Integer> booleanStrToIntegerConverter() {
        return mappingContext -> {

            if (Objects.isNull(mappingContext.getSource())) {
                return null;
            }

            throwExceptionIfNotTrueOrFalse(mappingContext.getSource());

            if (mappingContext.getSource().equals("false")) {
                return 0;
            } else {
                return 1;
            }
        };
    }

    public static void throwExceptionIfNotTrueOrFalse(String s) {
        if (Objects.isNull(s)) {
            return;
        }
        if (!(s.equals("true") || s.equals("false"))) {
            throw new BadInputException("Значение поля 'isActive' должно быть 'true' или 'false'");
        }
    }

    public static Converter<Integer, String> booleanIntegerToStrConverter() {
        return mappingContext -> {

            if (Objects.isNull(mappingContext.getSource())) {
                return null;
            }
            if (mappingContext.getSource() == 1) {
                return "true";
            } else {
                return "false";
            }
        };
    }

}
