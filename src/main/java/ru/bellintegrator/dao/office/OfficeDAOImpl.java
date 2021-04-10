package ru.bellintegrator.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.dao.organization.OrganizationNotFoundException;
import ru.bellintegrator.dto.BadInputException;
import ru.bellintegrator.dto.OfficeDTO;
import ru.bellintegrator.dto.mapper.Mapper;
import ru.bellintegrator.dto.mapper.OfficeMapper;
import ru.bellintegrator.entity.Office;
import ru.bellintegrator.entity.Organization;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class  OfficeDAOImpl implements OfficeDAO {

    private final EntityManager entityManager;

    private final OfficeMapper officeMapper;

    @Autowired
    public OfficeDAOImpl(EntityManager entityManager, OfficeMapper officeMapper) {
        this.entityManager = entityManager;
        this.officeMapper = officeMapper;
    }

    @Override
    public List<Office> getOffices() {
        TypedQuery<Office> query = entityManager.createQuery("select o from Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public Office getOffice(Long id) {
        if (Objects.isNull(id)) {
            throw new OfficeNotFoundException("Не задано id офиса");
        }

        Office office = entityManager.find(Office.class, id);
        if (Objects.isNull(office)) {
            throw new OfficeNotFoundException("Нет офиса с таким id " + id);
        }
        return office;
    }

    @Override
    public void updateOffice(OfficeDTO officeDTO) {

        // Получаем persisted объект офиса или ошибку
        Office office = this.getOffice(officeDTO.getId());

        // Если параметр orgId null, считаем, что организацию менять не нужно
        if (Objects.nonNull(officeDTO.getOrgId())) {
            Organization newOrganization = entityManager.find(Organization.class, officeDTO.getOrgId());
            if (Objects.isNull(newOrganization)) {
                throw new OrganizationNotFoundException("Нет организации с таким id " + officeDTO.getOrgId());
            }
            office.setOrganization(newOrganization);
        }
        // Если где-то поле не указано (null), то пропускаем изменение, а не устанавливаем null
        if (Objects.nonNull(officeDTO.getName())) { office.setName(officeDTO.getName()); }
        if (Objects.nonNull(officeDTO.getAddress())) { office.setAddress(officeDTO.getAddress()); }
        if (Objects.nonNull(officeDTO.getPhone())) { office.setPhone(officeDTO.getPhone()); }

        // Меняем поле типа String ("false"/"true") на (0/1)
        if (Objects.nonNull(officeDTO.getIsActive())) {
            if (officeDTO.getIsActive().equals("false")) {
                office.setIsActive(0);
            } else if (officeDTO.getIsActive().equals("true")) {
                office.setIsActive(1);
            } else {
                throw new BadInputException("Значение поля 'isActive' должно быть 'true' или 'false'");
            }
        }
    }

    @Override
    public void saveOffice(OfficeDTO officeDTO) {
        // ModelMapper использует прокси и таким образом перехватывает exception и нужное сообщение и возвращает свой
        // exception. Поэтому вручную вызываем метод проверки
        Mapper.throwExceptionIfNotTrueOrFalse(officeDTO.getIsActive());

        Organization organization = entityManager.find(Organization.class, officeDTO.getOrgId());
        if (Objects.isNull(organization)) {
            throw new OrganizationNotFoundException("Нет организации с таким id " + officeDTO.getOrgId());
        }
        Office office = officeMapper.toEntity(officeDTO);
        office.setOrganization(organization);
        entityManager.persist(office);
    }
}
