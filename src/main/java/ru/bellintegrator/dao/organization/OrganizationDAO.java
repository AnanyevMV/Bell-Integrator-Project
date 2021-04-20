package ru.bellintegrator.dao.organization;

import ru.bellintegrator.entity.Organization;
import java.util.List;

/**
 * Интерфейс OrganizationDAO определяет методы, которые должен реализовывать DAO-класс организаций
 */
public interface OrganizationDAO {
    /**
     * Метод позволяет получить список всех организаций
     *
     * @return список Organization
     */
    public List<Organization> getOrganizations();

    /**
     * Метод позволяет получить список организаций по фильтру
     *
     * @param filter фильтр
     * @return список Organization
     */
    public List<Organization> getOrganizations(Organization filter);

    /**
     * Метод позволяет получить организацию по её идентификатору
     *
     * @param id идентификатор организации
     * @return объект Organization
     */
    public Organization getOrganization(Long id);

    /**
     * Метод позволяет обновить информацию об организации
     *
     * @param organization объект Organization
     */
    public void updateOrganization(Organization organization);

    /**
     * Метод позволяет сохранить информацию об организации
     *
     * @param organization объект Organization
     */
    public void saveOrganization(Organization organization);
}
