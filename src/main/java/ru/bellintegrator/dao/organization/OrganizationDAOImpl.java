package ru.bellintegrator.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;
import ru.bellintegrator.entity.Organization;
import ru.bellintegrator.exception.BadInputException;
import ru.bellintegrator.exception.OrganizationException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс OrganizationDAOImpl представляет собой DAO-класс для организаций
 */
@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    private final EntityManager entityManager;

    /**
     * Конструктор класса OrganizationDAOImpl
     *
     * @param entityManager менеджер сущностей
     */
    @Autowired
    public OrganizationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Метод позволяет получить список всех организаций
     *
     * @return список Organization
     */
    @Override
    public List<Organization> getOrganizations() {
        TypedQuery<Organization> query = entityManager.createNamedQuery
                ("Organization.getAll", Organization.class);
        return query.getResultList();
    }

    /**
     * Метод позволяет получить список организаций по фильтру
     *
     * @param filter фильтр
     * @return список Organization
     */
    @Override
    public List<Organization> getOrganizations(Organization filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> root = criteriaQuery.from(Organization.class);
        criteriaQuery.select(root);
        List<Predicate> predicateList = getAllPredicates(filter, criteriaBuilder, root);
        criteriaQuery.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Метод позволяет получить список всех предикатов для CriteriaQuery
     *
     * @param filter фильтр
     * @param criteriaBuilder объект CriteriaBuilder
     * @param root корень
     * @return список предикатов
     */
    private List<Predicate> getAllPredicates(Organization filter, CriteriaBuilder criteriaBuilder, Root<Organization> root) {
        List<Predicate> predicateList = new ArrayList<>();

        // Для каждого поля класса Organization происходит проверка на null
        // Если поле не равно null, то добавляем предикат равенства в список
        Field[] declaredFields = filter.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            if (fieldName.equals("version")) {
                continue;
            }
            declaredField.setAccessible(true);
            Object fieldValue = ReflectionUtils.getField(declaredField, filter);
            if (Objects.nonNull(fieldValue)) {
                Predicate predicate = criteriaBuilder.equal(root.get(fieldName), fieldValue);
                predicateList.add(predicate);
            }
        }
        return predicateList;
    }

    /**
     * Метод позволяет получить организацию по её идентификатору
     *
     * @param id идентификатор организации
     * @return объект Organization
     */
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

    /**
     * Метод позволяет обновить информацию об организации
     *
     * @param organization объект Organization
     */
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

    /**
     * Метод позволяет сохранить информацию об организации
     *
     * @param organization объект Organization
     */
    @Override
    public void saveOrganization(Organization organization) {
        try {
            entityManager.persist(organization);
        } catch (Exception exc) {
            throw new OrganizationException("Не удалось сохранить организацию. Проверьте уникальность данных", exc);
        }
    }
}
