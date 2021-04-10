package ru.bellintegrator.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.dao.organization.OrganizationDAO;
import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.dto.mapper.Mapper;
import ru.bellintegrator.dto.mapper.OrganizationMapper;
import ru.bellintegrator.entity.Organization;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDAO organizationDAO;

    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO organizationDAO, OrganizationMapper organizationMapper) {
        this.organizationDAO = organizationDAO;
        this.organizationMapper = organizationMapper;
    }

    @Override
    @Transactional
    public List<OrganizationDTO> getOrganizations() {
        List<Organization> organizations = organizationDAO.getOrganizations();
        return organizationMapper.toDTOList(organizations);
    }

    @Override
    @Transactional
    public OrganizationDTO getOrganization(Long id) {
        Organization organization = organizationDAO.getOrganization(id);
        return organizationMapper.toDTO(organization);
    }

    @Override
    @Transactional
    public void saveOrganization(OrganizationDTO organizationDTO) {
        // ModelMapper использует прокси и таким образом перехватывает exception и нужное сообщение и возвращает свой
        // exception. Поэтому вручную вызываем метод проверки
        Mapper.throwExceptionIfNotTrueOrFalse(organizationDTO.getIsActive());
        Organization organization = organizationMapper.toEntity(organizationDTO);
        organization.setId(null);
        organizationDAO.saveOrganization(organization);
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationDTO organizationDTO) {
        // ModelMapper использует прокси и таким образом перехватывает exception и нужное сообщение и возвращает свой
        // exception. Поэтому вручную вызываем метод проверки
        Mapper.throwExceptionIfNotTrueOrFalse(organizationDTO.getIsActive());
        Organization organization = organizationMapper.toEntity(organizationDTO);
        organizationDAO.updateOrganization(organization);
    }
}
