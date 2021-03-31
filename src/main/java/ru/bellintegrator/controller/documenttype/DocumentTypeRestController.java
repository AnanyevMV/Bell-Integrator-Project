package ru.bellintegrator.controller.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.entity.DocumentType;
import ru.bellintegrator.service.documenttype.DocumentTypeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentTypeRestController {
    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeRestController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @GetMapping("/docs")
    public List<DocumentType> getDocumentTypes() {
        return documentTypeService.getDocumentTypes();
    }
}
