package ru.bellintegrator.service.organization;

import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.entity.Organization;

import java.util.List;

public interface OrganizationService {
    public List<OrganizationDTO> getOrganizations();

    public OrganizationDTO getOrganization(Long id);

    public void saveOrganization(OrganizationDTO organizationDTO);

    public void updateOrganization(OrganizationDTO organizationDTO);
}
