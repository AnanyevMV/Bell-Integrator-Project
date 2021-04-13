package ru.bellintegrator.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.entity.Organization;
import ru.bellintegrator.exception.OrganizationException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

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
        if (Objects.isNull(id)) {
            throw new OrganizationException("Не задано id организации");
        }
        Organization organization = entityManager.find(Organization.class, id);
        if (Objects.isNull(organization)) {
            throw new OrganizationException("Нет организации с таким id " + id);
        }
        return organization;
    }

    @Override
    public void updateOrganization(Organization organization) {
        // Получаем persisted объект организации или ошибку
        Organization persistedOrg = this.getOrganization(organization.getId());

        // Если где-то поле не указано (null), то пропускаем изменение, а не устанавливаем null
        if (Objects.nonNull(organization.getName())) { persistedOrg.setName(organization.getName()); }
        if (Objects.nonNull(organization.getFullName())) { persistedOrg.setName(organization.getFullName()); }
        if (Objects.nonNull(organization.getInn())) { persistedOrg.setInn(organization.getInn()); }
        if (Objects.nonNull(organization.getKpp())) { persistedOrg.setKpp(organization.getKpp()); }
        if (Objects.nonNull(organization.getAddress())) { persistedOrg.setAddress(organization.getAddress()); }
        if (Objects.nonNull(organization.getPhone())) { persistedOrg.setPhone(organization.getPhone()); }
        if (Objects.nonNull(organization.getIsActive())) { persistedOrg.setIsActive(organization.getIsActive()); }
    }


    @Override
    public void saveOrganization(Organization organization) {
        try {
            entityManager.persist(organization);
        } catch (Exception exc) {
            throw new OrganizationException("Не удалось сохранить организацию. Проверьте уникальность данных", exc);
        }
    }
}
