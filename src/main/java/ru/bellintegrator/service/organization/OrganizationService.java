package ru.bellintegrator.service.organization;

import ru.bellintegrator.dto.OrganizationDTO;

import java.util.List;

/**
 * Интерфейс сервиса для CRUD-операций, связанных с организациями
 */
public interface OrganizationService {
    /**
     * Метод позволяет получить список организаций
     *
     * @return список OrganizationDTO
     */
    public List<OrganizationDTO> getOrganizations();

    /**
     * Метод позволяет получить информацию об организации по её идентификатору
     * @param id идентификтор организации
     * @return объект OrganizationDTO
     */
    public OrganizationDTO getOrganization(Long id);

    /**
     * Метод позволяет сохранить организацию
     *
     * @param organizationDTO объект OrganizationDTO
     */
    public void saveOrganization(OrganizationDTO organizationDTO);

    /**
     * Метод позволяет обновить информцию об организации
     *
     * @param organizationDTO объект OrganizationDTO
     */
    public void updateOrganization(OrganizationDTO organizationDTO);
}
