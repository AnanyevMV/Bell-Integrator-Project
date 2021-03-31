package ru.bellintegrator.dao.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountryDAOImpl implements CountryDAO {

    private final EntityManager entityManager;

    @Autowired
    public CountryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Country> getCountries() {
        TypedQuery<Country> query = entityManager.createQuery("select c from Country c", Country.class);
        return query.getResultList();
    }
}
