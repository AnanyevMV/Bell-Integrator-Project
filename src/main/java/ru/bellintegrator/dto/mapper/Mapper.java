package ru.bellintegrator.dto.mapper;

import java.util.List;

public interface Mapper<E, D> {
public E toEntity(D dto);
public D toDTO(E entity);
public List<E> toEntityList(List<D> dtoList);
public List<D> toDTOList(List<E> entityList);
}
