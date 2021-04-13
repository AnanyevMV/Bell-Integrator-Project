package ru.bellintegrator.dao.office;

import ru.bellintegrator.entity.Office;

import java.util.List;

public interface OfficeDAO {

    public List<Office> getOffices();

    public Office getOffice(Long id);

    public void updateOffice(Office office, Long organizationId);

    public void saveOffice(Office office, Long organizationId);

}
