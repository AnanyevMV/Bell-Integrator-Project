package ru.bellintegrator.dao.documenttype;

import ru.bellintegrator.entity.DocumentType;

import java.util.List;

/**
 * Интерфейс DocumentTypeDAO определяет методы, которые должен реализовывать DAO-класс типов документов
 */
public interface DocumentTypeDAO {
    /**
     * Метод позволяет получить список всех типов документов
     *
     * @return список DocumentType
     */
    public List<DocumentType> getDocumentTypes();
}
