package ru.bellintegrator.service.documenttype;

import ru.bellintegrator.dto.DocumentTypeDTO;

import java.util.List;

/**
 * Интерфейс сервиса, который предоставляет список типов документов и их кодов
 */
public interface DocumentTypeService {
    /**
     * Метод позволяет получить список из типов документов и их кодов
     *
     * @return список DocumentTypeDTO
     */
    public List<DocumentTypeDTO> getDocumentTypes();
}
