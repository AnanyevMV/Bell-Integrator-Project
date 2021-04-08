package ru.bellintegrator.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.dto.DocumentTypeDTO;
import ru.bellintegrator.entity.DocumentType;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentTypeMapper implements Mapper<DocumentType, DocumentTypeDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public DocumentTypeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DocumentType toEntity(DocumentTypeDTO documentTypeDTO) {
        return modelMapper.map(documentTypeDTO, DocumentType.class);
    }

    @Override
    public DocumentTypeDTO toDTO(DocumentType documentType) {
        return modelMapper.map(documentType, DocumentTypeDTO.class);
    }

    @Override
    public List<DocumentType> toEntityList(List<DocumentTypeDTO> documentTypeDTOList) {
        return documentTypeDTOList.stream().
                map(documentTypeDTO -> modelMapper.map(documentTypeDTO, DocumentType.class)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentTypeDTO> toDTOList(List<DocumentType> documentTypeList) {
        return documentTypeList.stream().
                map(documentType -> modelMapper.map(documentType, DocumentTypeDTO.class)).collect(Collectors.toList());
    }
}
