package ru.bellintegrator.dao.office;

import ru.bellintegrator.entity.Office;
import java.util.List;

/**
 * Интерфейс OfficeDAO определяет методы, которые должен реализовывать DAO-класс офисов
 */
public interface OfficeDAO {

    /**
     * Метод позволяет получить список всех офисов
     *
     * @return список Office
     */
    public List<Office> getOffices();

    /**
     * Метод позволяет получить список офисов по фильтру
     *
     * @param filter фильтр
     * @param orgId идентификатор организации
     * @return список Office
     */
    public List<Office> getOffices(Office filter, Long orgId);

    /**
     * Метод позволяет получить офис по его идентификатору
     *
     * @param id идентификатор офиса
     * @return объект Office
     */
    public Office getOffice(Long id);

    /**
     * Метод позволяет обновить информацию об офисе
     *
     * @param office объект Office
     * @param organizationId идентификатор организации
     */
    public void updateOffice(Office office, Long organizationId);

    /**
     * Метод позволяет сохранить информацию об офисе
     *
     * @param office объект Office
     * @param organizationId идентификатор организации
     */
    public void saveOffice(Office office, Long organizationId);

}
