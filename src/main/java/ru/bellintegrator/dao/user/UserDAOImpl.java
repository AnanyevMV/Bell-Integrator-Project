package ru.bellintegrator.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.exception.OfficeException;
import ru.bellintegrator.exception.BadInputException;
import ru.bellintegrator.entity.Country;
import ru.bellintegrator.entity.Document;
import ru.bellintegrator.entity.DocumentId;
import ru.bellintegrator.entity.DocumentType;
import ru.bellintegrator.entity.Office;
import ru.bellintegrator.entity.User;
import ru.bellintegrator.exception.UserException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
        if (Objects.isNull(id)) {
            throw new UserException("Не задано id пользователя");
        }
        User user = entityManager.find(User.class, id);
        if (Objects.isNull(user)) {
            throw new UserException("Нет пользователя с таким id " + id);
        }
        return user;
    }

    @Override
    public void updateUser(User user, Long officeId) {
        // Получаем persisted объект пользователя или ошибку
        User persistedUser = this.getUser(user.getId());

        // Если параметр officeId равен null, то считаем что офис менять не нужно
        if (Objects.nonNull(officeId)) {
            Office office = entityManager.find(Office.class, officeId);
            if (Objects.isNull(office)) {
                throw new OfficeException("Нет офиса с таким id " + officeId);
            }
            persistedUser.setOffice(office);
        }

        // Если где-то поле не указано (null), то пропускаем изменение, а не устанавливаем null
        if (Objects.nonNull(user.getFirstName())) { persistedUser.setFirstName(user.getFirstName()); }
        if (Objects.nonNull(user.getLastName())) { persistedUser.setLastName(user.getLastName()); }
        if (Objects.nonNull(user.getMiddleName())) { persistedUser.setMiddleName(user.getMiddleName()); }
        if (Objects.nonNull(user.getPosition())) { persistedUser.setPosition(user.getPosition()); }
        if (Objects.nonNull(user.getPhone())) { persistedUser.setPhone(user.getPhone()); }
        if (Objects.nonNull(user.getIsIdentified())) { persistedUser.setIsIdentified(user.getIsIdentified()); }

        if (Objects.nonNull(user.getCitizenshipCode())) {
            throwExceptionIfCitizenshipCodeDoesNotExist(user.getCitizenshipCode());
            persistedUser.setCitizenshipCode(user.getCitizenshipCode());
        }
        // Обработка входных данных документа
        processDocumentInput(persistedUser, user.getDocument());
    }

    private void processDocumentInput(User persistedUser, Document document) {
        // Если дата не null, то меняем дату документа
        if (Objects.nonNull(document.getDocDate())) {
            persistedUser.getDocument().setDocDate(document.getDocDate());
        }

        // Если код документа не null, то возможно меняем код и номер документа после проверок
        if (Objects.nonNull(document.getDocCode())) {
            throwExceptionIfDocCodeDoesNotExistAndCheckDocNumber(document.getDocCode(), document.getDocNumber());
            // Если код или номер документа не совпадают, то проверяем что код и номер документа ещё не существуют
            // Если совпадают, то ничего не меняем
            if (!persistedUser.getDocument().getDocCode().equals(document.getDocCode()) || !persistedUser.getDocument().getDocNumber().equals(document.getDocNumber())) {
                throwExceptionIfDocCodeAndDocNumberAlreadyExist(document.getDocCode(), document.getDocNumber());
                Document oldDocument = persistedUser.getDocument();
                Date date = oldDocument.getDocDate();
                entityManager.remove(oldDocument);
                Document newDocument = new Document(document.getDocCode(), document.getDocNumber(), date);
                persistedUser.setDocument(newDocument);
            }
        }
    }



    @Override
    public void saveUser(User user, Long officeId) {
        throwExceptionIfCitizenshipCodeDoesNotExist(user.getCitizenshipCode());

        if (Objects.isNull(officeId)) {
            throw new OfficeException("Не указано id офиса");
        }

        Office office = entityManager.find(Office.class, officeId);
        if (Objects.isNull(office)) {
            throw new OfficeException("Нет офиса с таким id " + officeId);
        }

        throwExceptionIfDocCodeDoesNotExistAndCheckDocNumber(user.getDocument().getDocCode(), user.getDocument().getDocNumber());
        throwExceptionIfDocCodeAndDocNumberAlreadyExist(user.getDocument().getDocCode(), user.getDocument().getDocNumber());

        user.setOffice(office);

        try {
            entityManager.persist(user);
        } catch (Exception e) {
            throw new UserException("Не удалось сохранить пользователя. Проверьте входные данные", e);
        }
    }

    private void throwExceptionIfCitizenshipCodeDoesNotExist(String citizenshipCode) {
        if (Objects.isNull(citizenshipCode)) {
            throw new BadInputException("Не задан код страны");
        }
        TypedQuery<Country> query = entityManager.createQuery
        ("select c from Country c where c.code = :citizenshipCode", Country.class);
        query.setParameter("citizenshipCode", citizenshipCode);
        try {
            query.getSingleResult();
        } catch (Exception e) {
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
        try {
            query.getSingleResult();
        } catch (Exception e) {
            throw new BadInputException("Неверный код документа " + docCode);
        }
    }

    private void throwExceptionIfDocCodeAndDocNumberAlreadyExist(String docCode, String docNumber) {
        DocumentId documentId = new DocumentId(docCode, docNumber);
        Document document = entityManager.find(Document.class, documentId);
        if (Objects.nonNull(document)) {
            throw new BadInputException("Документ с кодом " + docCode + " и номером " + docNumber + " уже существует");
        }
    }

}
