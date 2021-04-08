package ru.bellintegrator.dao.organization;

import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.entity.Organization;

import java.util.List;

public interface OrganizationDAO {
    public List<Organization> getOrganizations();

    public Organization getOrganization(Long id);

    public void updateOrganization(Organization organization);

    public void saveOrganization(Organization organization);
}
