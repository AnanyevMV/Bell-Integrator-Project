package ru.bellintegrator.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.entity.Office;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficeDAOImpl implements OfficeDAO {

    private final EntityManager entityManager;

    @Autowired
    public OfficeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Office> getOffices() {
        TypedQuery<Office> query = entityManager.createQuery("select o from Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public Office getOffice(Long id) {
        if (id == null) {
            throw new OfficeNotFoundException("Не задано id офиса");
        }

        Office office = entityManager.find(Office.class, id);
        if (office == null) {
            throw new OfficeNotFoundException("Нет офиса с таким id " + id);
        }
        return office;
    }

    @Override
    public void updateOffice(Office office) {

    }

    @Override
    public void saveOffice(Office office) {

    }
}
