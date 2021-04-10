package ru.bellintegrator.dto.mapper;

import org.modelmapper.Converter;
import ru.bellintegrator.dto.BadInputException;

import java.util.List;

public interface Mapper<E, D> {
public E toEntity(D dto);
public D toDTO(E entity);
public List<E> toEntityList(List<D> dtoList);
public List<D> toDTOList(List<E> entityList);

public static Converter<String, Integer> booleanStrToIntegerConverter() {
    return mappingContext -> {
        if (mappingContext.getSource().equals("false")) {
            return 0;
        } else if (mappingContext.getSource().equals("true")) {
            return 1;
        } else {
            throw new BadInputException("Field 'isActive' should be 'true' or 'false'");
        }
    };
}

public static Converter<Integer, String> booleanIntegerToStrConverter() {
    return mappingContext -> {
        if (mappingContext.getSource() == 1) {
            return "true";
        } else {
            return "false";
        }
    };
}
}
