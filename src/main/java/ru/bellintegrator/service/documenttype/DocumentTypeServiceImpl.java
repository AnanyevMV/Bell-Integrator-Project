package ru.bellintegrator.service.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.dao.documenttype.DocumentTypeDAO;
import ru.bellintegrator.entity.DocumentType;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeDAO documentTypeDAO;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDAO documentTypeDAO) {
        this.documentTypeDAO = documentTypeDAO;
    }

    @Override
    public List<DocumentType> getDocumentTypes() {
        return documentTypeDAO.getDocumentTypes();
    }
}
