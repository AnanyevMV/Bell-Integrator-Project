package ru.bellintegrator.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.dao.office.OfficeNotFoundException;
import ru.bellintegrator.dto.BadInputException;
import ru.bellintegrator.dto.UserDTO;
import ru.bellintegrator.dto.mapper.UserMapper;
import ru.bellintegrator.entity.Country;
import ru.bellintegrator.entity.Document;
import ru.bellintegrator.entity.DocumentId;
import ru.bellintegrator.entity.DocumentType;
import ru.bellintegrator.entity.Office;
import ru.bellintegrator.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.print.Doc;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    private final UserMapper userMapper;

    @Autowired
    public UserDAOImpl(EntityManager entityManager, UserMapper userMapper) {
        this.entityManager = entityManager;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
        if (Objects.isNull(id)) {
            throw new UserNotFoundException("Не задано id пользователя");
        }
        User user = entityManager.find(User.class, id);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException("Нет пользователя с таким id " + id);
        }
        return user;
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        // Получаем persisted объект офиса или ошибку
        User user = this.getUser(userDTO.getId());

        // Если параметр officeId равен null, то считаем что офис менять не нужно
        if (Objects.nonNull(userDTO.getOfficeId())) {
            Office office = entityManager.find(Office.class, userDTO.getOfficeId());
            if (Objects.isNull(office)) {
                throw new OfficeNotFoundException("Нет офиса с таким id " + userDTO.getOfficeId());
            }
            user.setOffice(office);
        }

        // Если где-то поле не указано (null), то пропускаем изменение, а не устанавливаем null
        if (Objects.nonNull(userDTO.getFirstName())) { user.setFirstName(userDTO.getFirstName()); }
        if (Objects.nonNull(userDTO.getLastName())) { user.setLastName(userDTO.getLastName()); }
        if (Objects.nonNull(userDTO.getMiddleName())) { user.setMiddleName(userDTO.getMiddleName()); }
        if (Objects.nonNull(userDTO.getPosition())) { user.setPosition(userDTO.getPosition()); }
        if (Objects.nonNull(userDTO.getPhone())) { user.setPhone(userDTO.getPhone()); }

        // Меняем поле типа String ("false"/"true") на (0/1)
        if (Objects.nonNull(userDTO.getIsIdentified())) {
            throwExceptionIfIsIdentifiedFieldIsNotTrueOrFalse(userDTO.getIsIdentified());
            if (userDTO.getIsIdentified().equals("false")) {
                user.setIsIdentified(0);
            } else {
                user.setIsIdentified(1);
            }
        }

        if (Objects.nonNull(userDTO.getCitizenshipCode())) {
            throwExceptionIfCitizenshipCodeDoesNotExist(userDTO.getCitizenshipCode());
            user.setCitizenshipCode(userDTO.getCitizenshipCode());
        }

        if (Objects.nonNull(userDTO.getDocCode())) {
            throwExceptionIfDocCodeDoesNotExistAndCheckDocNumber(userDTO.getDocCode(), userDTO.getDocNumber());
            Document document = new Document(userDTO.getDocCode(), userDTO.getDocNumber(), Date.valueOf(userDTO.getDocDate()));
            user.setDocument(document);
        }
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        throwExceptionIfIsIdentifiedFieldIsNotTrueOrFalse(userDTO.getIsIdentified());
        throwExceptionIfCitizenshipCodeDoesNotExist(userDTO.getCitizenshipCode());

        if (Objects.isNull(userDTO.getOfficeId())) {
            throw new OfficeNotFoundException("Не указано id офиса");
        }

        Office office = entityManager.find(Office.class, userDTO.getOfficeId());
        if (Objects.isNull(office)) {
            throw new OfficeNotFoundException("Нет офиса с таким id " + userDTO.getOfficeId());
        }

        throwExceptionIfDocCodeDoesNotExistAndCheckDocNumber(userDTO.getDocCode(), userDTO.getDocNumber());
        Document document = new Document(userDTO.getDocCode(), userDTO.getDocNumber(), Date.valueOf(userDTO.getDocDate()));

        User user = userMapper.toEntity(userDTO);
        user.setOffice(office);
        user.setDocument(document);

        entityManager.persist(user);
    }

    private void throwExceptionIfCitizenshipCodeDoesNotExist(String citizenshipCode) {
        if (Objects.isNull(citizenshipCode)) {
            throw new BadInputException("Не задан код страны");
        }
        TypedQuery<Country> query = entityManager.createQuery
        ("select c from Country c where c.code = :citizenshipCode", Country.class);
        query.setParameter("citizenshipCode", citizenshipCode);
        Country country = query.getSingleResult();
        if (Objects.isNull(country)) {
            throw new BadInputException("Неверный код страны " + citizenshipCode);
        }
    }

    private void throwExceptionIfDocCodeDoesNotExistAndCheckDocNumber(String docCode, String docNumber) {

        if (Objects.isNull(docNumber)) {
            throw new BadInputException("Номер документа не может быть null");
        }

        TypedQuery<DocumentType> query = entityManager.createQuery
        ("select dt from DocumentType dt where dt.docCode = :docCode", DocumentType.class);
        query.setParameter("docCode", docCode);
        DocumentType documentType = query.getSingleResult();
        if (Objects.isNull(documentType)) {
            throw new BadInputException("Неверный код докуумента " + docCode);
        }
    }


    private void throwExceptionIfIsIdentifiedFieldIsNotTrueOrFalse(String isIdentified) {
        if (Objects.isNull(isIdentified)) {
            return;
        }

        if (!(isIdentified.equals("true") || isIdentified.equals("false"))) {
            throw new BadInputException("Значение поля 'isIdentified' должно быть 'true' или 'false'");
        }
    }

}
