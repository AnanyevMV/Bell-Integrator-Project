package ru.bellintegrator.service.organization;

import ru.bellintegrator.dto.OrganizationDTO;

import java.util.List;

public interface OrganizationService {
    public List<OrganizationDTO> getOrganizations();

    public OrganizationDTO getOrganization(Long id);
}
