package ru.bellintegrator.dao.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.entity.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Класс DocumentTypeDAOImpl представляет собой DAO-класс для типов документов
 */
@Repository
public class DocumentTypeDAOImpl implements DocumentTypeDAO {

    private final EntityManager entityManager;

    /**
     * Конструктор класса DocumentTypeDAOImpl
     *
     * @param entityManager менеджер сущностей
     */
    @Autowired
    public DocumentTypeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Метод позволяет получить список всех типов документов
     *
     * @return список DocumentType
     */
    @Override
    public List<DocumentType> getDocumentTypes() {
        TypedQuery<DocumentType> query =
                entityManager.createQuery("select d from DocumentType d", DocumentType.class);
        return query.getResultList();
    }
}
