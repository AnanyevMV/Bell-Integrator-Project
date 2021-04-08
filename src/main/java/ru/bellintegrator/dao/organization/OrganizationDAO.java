package ru.bellintegrator.dao.organization;

import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.entity.Organization;

import java.util.List;

public interface OrganizationDAO {
    public List<Organization> getOrganizations();

    public Organization getOrganization(Long id);

    public void updateOrganization(OrganizationDTO organizationDTO);

    public void saveOrganization(OrganizationDTO organizationDTO);
}
