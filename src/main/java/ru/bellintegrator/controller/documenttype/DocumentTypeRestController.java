package ru.bellintegrator.controller.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.dto.DocumentTypeDTO;
import ru.bellintegrator.service.documenttype.DocumentTypeService;

import java.util.List;

@RestController
@RequestMapping("/api")
/**
 * REST-контроллер, отвечающий за типы документов.<br>
 * Данный контроллер содержит единственный метод, обрабатывающий GET-запрос /api/docs<br>
 * Выходные данные этого метода являются справочными данными о названиях документов и их кодах.
 */
public class DocumentTypeRestController {

    /**
     * У контроллера имеется зависимость documentTypeService, которая возвращает список DocumentTypeDTO
     */
    private final DocumentTypeService documentTypeService;

    /**
     * Конструктор класса DocumentTypeRestService. Используется внедрение зависимости<br>
     * DocumentTypeService через конструктор.
     * @param documentTypeService - сервис, возвращающий список DocumentTypeDTO
     */
    @Autowired
    public DocumentTypeRestController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    /**
     * Справочный метод контроллера, возвращающий названия документов и их коды
     * @return список документов и их кодов
     */
    @GetMapping("/docs")
    public List<DocumentTypeDTO> getDocumentTypes() {
        return documentTypeService.getDocumentTypes();
    }
}
