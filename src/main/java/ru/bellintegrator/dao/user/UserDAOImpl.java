package ru.bellintegrator.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;
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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс UserDAOImpl представляет собой DAO-класс для пользователей
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    /**
     * Конструктор класса UserDAOImpl
     *
     * @param entityManager менеджер сущностей
     */
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Метод позволяет получить список всех пользователей
     *
     * @return список User
     */
    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }

    /**
     * Метод позволяет получить список пользователей по фильтру
     *
     * @param filter фильтр
     * @return список User
     */
    @Override
    public List<User> getUsers(User filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        List<Predicate> predicateList = getAllPredicates(filter, criteriaBuilder, root);
        addDocumentPredicates(filter, criteriaBuilder, root, predicateList);
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
    private List<Predicate> getAllPredicates(User filter, CriteriaBuilder criteriaBuilder, Root<User> root) {
        List<Predicate> predicateList = new ArrayList<>();
        // Для каждого поля класса Organization происходит проверка на null
        // Если поле не равно null, то добавляем предикат равенства в список
        Field[] declaredFields = filter.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            if (fieldName.equals("version")) {
                continue;
            }
            if (fieldName.equals("document")) {
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
     * Метод добавляем предикаты для документов
     *
     * @param filter фильтр
     * @param criteriaBuilder объект CriteriaBuilder
     * @param root корень
     * @param predicateList список предикатов
     */
    private void addDocumentPredicates(User filter, CriteriaBuilder criteriaBuilder, Root<User> root, List<Predicate> predicateList) {
        if (Objects.nonNull(filter.getDocument())) {
            Document d = filter.getDocument();
            if (Objects.nonNull(d.getDocCode())) {
                Predicate predicate = criteriaBuilder.equal(root.get("document").get("docCode"), d.getDocCode());
                predicateList.add(predicate);
            }
            if (Objects.nonNull(d.getDocNumber())) {
                Predicate predicate = criteriaBuilder.equal(root.get("document").get("docNumber"), d.getDocNumber());
                predicateList.add(predicate);
            }
            if (Objects.nonNull(d.getDocDate())) {
                Predicate predicate = criteriaBuilder.equal(root.get("document").get("docDate"), d.getDocDate());
                predicateList.add(predicate);
            }
        }
    }

    /**
     * Метод позволяет получить пользователя по его идентификатору
     *
     * @param id идентификатор пользователя
     * @return объект User
     */
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

    /**
     * Метод позволяет обновить информацию о пользователе
     *
     * @param user     объект User
     * @param officeId идентификатор офиса
     */
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
        // Обработка входных данных о пользователе
        processUserFields(user, persistedUser);
        // Обработка входных данных документа
        processDocumentInput(persistedUser, user.getDocument());
    }

    /**
     * Метод обрабатывает поля объекта User. Если поле не null, то оно обновляется в persisted-объекте User
     *
     * @param user объект User, полученный из UserDTO
     * @param persistedUser persisted-объект User
     */
    private void processUserFields(User user, User persistedUser) {
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
    }

    /**
     * Метод обрабатывает поля объекта Document и обновляет информацию в persisted-объекте User
     *
     * @param persistedUser persisted-объект User
     * @param document объект Document
     */
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

    /**
     * Метод позволяет сохранить информацию о пользователе
     *
     * @param user     объект User
     * @param officeId идентификатор офиса
     */
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
            throw new UserException("Не удалось сохранить пользователя", e);
        }
    }

    /**
     * Метод бросает исключение, если не существует такого кода страны
     *
     * @param citizenshipCode код страны
     */
    private void throwExceptionIfCitizenshipCodeDoesNotExist(String citizenshipCode) {
        if (Objects.isNull(citizenshipCode)) {
            throw new BadInputException("Не задан код страны");
        }
        TypedQuery<Country> query = entityManager.createNamedQuery
        ("Country.checkCitizenshipCode", Country.class);
        query.setParameter("citizenshipCode", citizenshipCode);
        try {
            query.getSingleResult();
        } catch (Exception e) {
            throw new BadInputException("Неверный код страны " + citizenshipCode);
        }
    }

    /**
     * Метод бросает исключение, если не существует такого кода документа или если поле docNumber равно null
     *
     * @param docCode код документа
     * @param docNumber номер документа
     */
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

    /**
     * Метод бросает исключение, если пара (код документа, номер документа) уже существует
     *
     * @param docCode код документа
     * @param docNumber номер документа
     */
    private void throwExceptionIfDocCodeAndDocNumberAlreadyExist(String docCode, String docNumber) {
        DocumentId documentId = new DocumentId(docCode, docNumber);
        Document document = entityManager.find(Document.class, documentId);
        if (Objects.nonNull(document)) {
            throw new BadInputException("Документ с кодом " + docCode + " и номером " + docNumber + " уже существует");
        }
    }

}
