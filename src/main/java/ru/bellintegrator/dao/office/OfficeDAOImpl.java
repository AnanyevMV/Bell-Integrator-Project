package ru.bellintegrator.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.exception.OrganizationException;
import ru.bellintegrator.entity.Office;
import ru.bellintegrator.entity.Organization;
import ru.bellintegrator.exception.OfficeException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

/**
 * Класс OfficeDAOImpl представляет собой DAO-класс для офисов
 */
@Repository
public class  OfficeDAOImpl implements OfficeDAO {

    private final EntityManager entityManager;

    /**
     * Конструктор класса OfficeDAOImpl
     *
     * @param entityManager менеджер сущностей
     */
    @Autowired
    public OfficeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Метод позволяет получить список всех офисов
     *
     * @return список Office
     */
    @Override
    public List<Office> getOffices() {
        TypedQuery<Office> query = entityManager.createQuery("select o from Office o", Office.class);
        return query.getResultList();
    }

    /**
     * Метод позволяет получить офис по его идентификатору
     *
     * @param id идентификатор офиса
     * @return объект Office
     */
    @Override
    public Office getOffice(Long id) {
        if (Objects.isNull(id)) {
            throw new OfficeException("Не задано id офиса");
        }

        Office office = entityManager.find(Office.class, id);
        if (Objects.isNull(office)) {
            throw new OfficeException("Нет офиса с таким id " + id);
        }
        return office;
    }

    /**
     * Метод позволяет обновить информацию об офисе
     *
     * @param office         объект Office
     * @param organizationId идентификатор организации
     */
    @Override
    public void updateOffice(Office office, Long organizationId) {
        // Получаем persisted объект офиса или ошибку
        Office persistedOffice = this.getOffice(office.getId());

        // Если параметр orgId null, считаем, что организацию менять не нужно
        if (Objects.nonNull(organizationId)) {
            Organization newOrganization = entityManager.find(Organization.class, organizationId);
            if (Objects.isNull(newOrganization)) {
                throw new OrganizationException("Нет организации с таким id " + organizationId);
            }
            persistedOffice.setOrganization(newOrganization);
        }
        // Если где-то поле не указано (null), то пропускаем изменение, а не устанавливаем null
        if (Objects.nonNull(office.getName())) { persistedOffice.setName(office.getName()); }
        if (Objects.nonNull(office.getAddress())) { persistedOffice.setAddress(office.getAddress()); }
        if (Objects.nonNull(office.getPhone())) { persistedOffice.setPhone(office.getPhone()); }
        if (Objects.nonNull(office.getIsActive())) { persistedOffice.setIsActive(office.getIsActive()); }
    }

    /**
     * Метод позволяет сохранить информацию об офисе
     *
     * @param office         объект Office
     * @param organizationId идентификатор организации
     */
    @Override
    public void saveOffice(Office office, Long organizationId) {
        if (Objects.isNull(organizationId)) {
            throw new OrganizationException("Не указано id организации");
        }
        Organization organization = entityManager.find(Organization.class, organizationId);
        if (Objects.isNull(organization)) {
            throw new OrganizationException("Нет организации с таким id " + organizationId);
        }
        office.setOrganization(organization);
        entityManager.persist(office);
    }
}
