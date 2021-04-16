package ru.bellintegrator.service.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.dao.documenttype.DocumentTypeDAO;
import ru.bellintegrator.dto.DocumentTypeDTO;
import ru.bellintegrator.dto.mapper.DocumentTypeMapper;
import ru.bellintegrator.entity.DocumentType;

import java.util.List;

/**
 * Реализация интерфейса DocumentTypeService<br>
 * Сервис предоставляет список типов документов и их кодов
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeDAO documentTypeDAO;

    private final DocumentTypeMapper documentTypeMapper;

    /**
     * Конструктор класса DocumentTypeServiceImpl
     *
     * @param documentTypeDAO DAO объект для типов документов
     * @param documentTypeMapper объект для маппинга между DocumentType и DocumentTypeDTO
     */
    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDAO documentTypeDAO, DocumentTypeMapper documentTypeMapper) {
        this.documentTypeDAO = documentTypeDAO;
        this.documentTypeMapper = documentTypeMapper;
    }

    /**
     * Метод позволяет получить список из типов документов и их кодов
     *
     * @return список DocumentTypeDTO
     */
    @Override
    @Transactional
    public List<DocumentTypeDTO> getDocumentTypes() {
        List<DocumentType> documentTypes = documentTypeDAO.getDocumentTypes();
        return documentTypeMapper.toDTOList(documentTypes);
    }
}
