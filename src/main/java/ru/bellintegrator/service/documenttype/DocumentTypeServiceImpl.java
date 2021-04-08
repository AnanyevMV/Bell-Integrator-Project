package ru.bellintegrator.service.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.dao.documenttype.DocumentTypeDAO;
import ru.bellintegrator.dto.DocumentTypeDTO;
import ru.bellintegrator.dto.mapper.DocumentTypeMapper;
import ru.bellintegrator.entity.DocumentType;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeDAO documentTypeDAO;

    private final DocumentTypeMapper documentTypeMapper;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDAO documentTypeDAO, DocumentTypeMapper documentTypeMapper) {
        this.documentTypeDAO = documentTypeDAO;
        this.documentTypeMapper = documentTypeMapper;
    }

    @Override
    public List<DocumentTypeDTO> getDocumentTypes() {
        List<DocumentType> documentTypes = documentTypeDAO.getDocumentTypes();
        return documentTypeMapper.toDTOList(documentTypes);
    }
}
