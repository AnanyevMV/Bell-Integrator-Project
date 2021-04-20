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

/**
 * Реализация интерфейса OrganizationService<br>
 * Сервис для CRUD-операций, связанных с организациями
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDAO organizationDAO;

    private final OrganizationMapper organizationMapper;

    /**
     * Конструктор класса OrganizationServiceImpl
     *
     * @param organizationDAO DAO объект для организаций
     * @param organizationMapper объект для маппинга между Organization и OrganizationDTO
     */
    @Autowired
    public OrganizationServiceImpl(OrganizationDAO organizationDAO, OrganizationMapper organizationMapper) {
        this.organizationDAO = organizationDAO;
        this.organizationMapper = organizationMapper;
    }

    /**
     * Метод позволяет получить список организаций
     *
     * @return список OrganizationDTO
     */
    @Override
    @Transactional
    public List<OrganizationDTO> getOrganizations() {
        List<Organization> organizations = organizationDAO.getOrganizations();
        return organizationMapper.toDTOList(organizations);
    }

    /**
     * Метод позволяет получить список организаций согласно фильтру
     *
     * @param filter фильтр
     * @return список OrganizationDTO
     */
    @Override
    @Transactional
    public List<OrganizationDTO> getOrganizations(OrganizationDTO filter) {
        Organization orgFilter = organizationMapper.toEntity(filter);
        List<Organization> organizations = organizationDAO.getOrganizations(orgFilter);
        return organizationMapper.toDTOList(organizations);
    }

    /**
     * Метод позволяет получить информацию об организации по её идентификатору
     *
     * @param id идентификтор организации
     * @return объект OrganizationDTO
     */
    @Override
    @Transactional
    public OrganizationDTO getOrganization(Long id) {
        Organization organization = organizationDAO.getOrganization(id);
        return organizationMapper.toDTO(organization);
    }

    /**
     * Метод позволяет сохранить организацию
     *
     * @param organizationDTO объект OrganizationDTO
     */
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

    /**
     * Метод позволяет обновить информцию об организации
     *
     * @param organizationDTO объект OrganizationDTO
     */
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
