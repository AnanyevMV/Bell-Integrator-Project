package ru.bellintegrator.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.dto.OrganizationDTO;
import ru.bellintegrator.entity.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    private final EntityManager entityManager;

    @Autowired
    public OrganizationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Organization> getOrganizations() {
        TypedQuery<Organization> query = entityManager.createQuery
        ("select o from Organization o", Organization.class);
        return query.getResultList();
    }

    @Override
    public Organization getOrganization(Long id) {
        Organization organization = entityManager.find(Organization.class, id);
        if (organization == null) {
            throw new OrganizationNotFoundException("Нет организации с таким id " + id);
        }
        return organization;
    }

    @Override
    public void updateOrganization(Organization organization) {
        // Проверка, есть ли организация с таким id
        this.getOrganization(organization.getId());
        entityManager.merge(organization);
    }

    @Override
    public void saveOrganization(Organization organization) {
        entityManager.persist(organization);
    }
}
