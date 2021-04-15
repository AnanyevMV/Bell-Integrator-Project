package ru.bellintegrator.dto.mapper;

import org.modelmapper.Converter;
import ru.bellintegrator.exception.BadInputException;

import java.util.List;
import java.util.Objects;

/**
 * Интерфейс Mapper для маппинга между Entity и DTO
 * @param <E> Entity
 * @param <D> DTO
 */
public interface Mapper<E, D> {

    /**
     * Маппинг из DTO в Entity
     * @param dto DTO
     * @return Entity
     */
    public E toEntity(D dto);

    /**
     * Маппинг из Entity в DTO
     * @param entity Entity
     * @return DTO
     */
    public D toDTO(E entity);

    /**
     * Маппинг из списка DTO в список Entity
     * @param dtoList список DTO
     * @return список Entity
     */
    public List<E> toEntityList(List<D> dtoList);

    /**
     * Маппинг из списка Entity в список DTO
     * @param entityList список Entity
     * @return список DTO
     */
    public List<D> toDTOList(List<E> entityList);

    /**
     * Конвертер из "true"/"false" в 1/0
     * @return из "true"/"false" в 1/0
     */
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

    /**
     * Вспомогательный метод, который бросает ошибку, если строка не равна "true" или "false"
     * @param s входная строка на проверку
     */
    public static void throwExceptionIfNotTrueOrFalse(String s) {
        if (Objects.isNull(s)) {
            return;
        }
        if (!(s.equals("true") || s.equals("false"))) {
            throw new BadInputException("Значение поля 'isActive' должно быть 'true' или 'false'");
        }
    }

    /**
     * Конвертер из 1/0 в "true"/"false"
     * @return из 1/0 в "true"/"false"
     */
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
