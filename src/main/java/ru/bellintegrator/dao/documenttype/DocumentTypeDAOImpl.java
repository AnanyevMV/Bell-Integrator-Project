package ru.bellintegrator.dao.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.entity.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocumentTypeDAOImpl implements DocumentTypeDAO {

    private final EntityManager entityManager;

    @Autowired
    public DocumentTypeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<DocumentType> getDocumentTypes() {
        TypedQuery<DocumentType> query =
        entityManager.createQuery("select d from DocumentType d", DocumentType.class);
        return query.getResultList();
    }
}
