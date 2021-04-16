package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.DocumentTypeDTO;
import ru.bellintegrator.entity.DocumentType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс DocumentTypeMapper для маппинга между DocumentType и DocumentTypeDTO
 */
@Component
public class DocumentTypeMapper implements Mapper<DocumentType, DocumentTypeDTO> {

    private final ModelMapper modelMapper;

    /**
     * Конструктор класса DocumentTypeMapper
     *
     * @param modelMapper объект класса ModelMapper
     */
    @Autowired
    public DocumentTypeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Маппинг из DocumentTypeDTO в DocumentType
     *
     * @param documentTypeDTO объект DocumentTypeDTO
     * @return объект DocumentType
     */
    @Override
    public DocumentType toEntity(DocumentTypeDTO documentTypeDTO) {
        return modelMapper.map(documentTypeDTO, DocumentType.class);
    }

    /**
     * Маппинг из DocumentType в DocumentTypeDTO
     *
     * @param documentType объект DocumentType
     * @return объект DocumentTypeDTO
     */
    @Override
    public DocumentTypeDTO toDTO(DocumentType documentType) {
        return modelMapper.map(documentType, DocumentTypeDTO.class);
    }

    /**
     * Маппинг из списка DocumentTypeDTO в список DocumentType
     *
     * @param documentTypeDTOList список DocumentTypeDTO
     * @return список DocumentType
     */
    @Override
    public List<DocumentType> toEntityList(List<DocumentTypeDTO> documentTypeDTOList) {
        return documentTypeDTOList.stream().
                map(documentTypeDTO -> modelMapper.map(documentTypeDTO, DocumentType.class)).collect(Collectors.toList());
    }

    /**
     * Маппинг из списка DocumentType в список DocumentTypeDTO
     *
     * @param documentTypeList список DocumentType
     * @return список DocumentTypeDTO
     */
    @Override
    public List<DocumentTypeDTO> toDTOList(List<DocumentType> documentTypeList) {
        return documentTypeList.stream().
                map(documentType -> modelMapper.map(documentType, DocumentTypeDTO.class)).collect(Collectors.toList());
    }
}
