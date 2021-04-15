package ru.bellintegrator.dto;

/**
 * Класс UserDTO отвечает за DTO объекты пользователей
 */
public class UserDTO {

    /**
     * Идентификатор пользователя
     */
    private Long id;

    /**
     * Идентификатор офиса
     */
    private Long officeId;

    /**
     * Имя пользователя
     */
    private String firstName;

    /**
     * Фамилия пользователя
     */
    private String lastName;

    /**
     * Второе личное имя пользователя
     */
    private String middleName;

    /**
     * Должность пользователя
     */
    private String position;

    /**
     * Телефон пользователя
     */
    private String phone;

    /**
     * Код документа
     */
    private String docCode;

    /**
     * Номер документа
     */
    private String docNumber;

    /**
     * Дата документа (формат yyyy-mm-dd)
     */
    private String docDate;

    /**
     * Код страны
     */
    private String citizenshipCode;

    /**
     * Идентифицирован ли пользователь (формат "true"/"false")
     */
    private String isIdentified;

    /**
     * Конструктор без параметров класса UserDTO
     */
    public UserDTO() {

    }

    /**
     * Геттер для поля id
     * @return идентификатор пользователя
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер для поля id
     * @param id идентификатор пользователя
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер для поля officeId
     * @return идентификатор офиса
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * Сеттер для поля officeId
     * @param officeId идентификатор офиса
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * Геттер для поля firstName
     * @return имя пользователя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Сеттер для поля firstName
     * @param firstName имя пользователя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Геттер для поля lastName
     * @return фамилия пользователя
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Сеттер для поля lastName
     * @param lastName фамилия пользователя
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Геттер для поля middleName
     * @return второе личное имя пользователя
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Сеттер для поля middleName
     * @param middleName второе личное имя пользователя
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Геттер для поля position
     * @return должность пользователя
     */
    public String getPosition() {
        return position;
    }

    /**
     * Сеттер для поля position
     * @param position должность пользователя
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Геттер для поля phone
     * @return телефон пользователя
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Сеттер для поля phone
     * @param phone телефон пользователя
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Геттер для поля docCode
     * @return код документа
     */
    public String getDocCode() {
        return docCode;
    }

    /**
     * Сеттер для поля docCode
     * @param docCode код документа
     */
    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    /**
     * Геттер для поля docNumber
     * @return номер документа
     */
    public String getDocNumber() {
        return docNumber;
    }

    /**
     * Сеттер для поля docNumber
     * @param docNumber номер документа
     */
    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    /**
     * Геттер для поля citizenshipCode
     * @return код страны
     */
    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    /**
     * Сеттер для поля citizenshipCode
     * @param citizenshipCode код страны
     */
    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    /**
     * Геттер для поля isIdentified
     * @return идентифецирован ли пользователь (формат "true"/"false")
     */
    public String getIsIdentified() {
        return isIdentified;
    }

    /**
     * Сеттер для поля isIdentified
     * @param isIdentified идентифецирован ли пользователь (формат "true"/"false")
     */
    public void setIsIdentified(String isIdentified) {
        this.isIdentified = isIdentified;
    }

    /**
     * Геттер для поля docDate
     * @return дата документа
     */
    public String getDocDate() {
        return docDate;
    }

    /**
     * Сеттер для поля docDate
     * @param docDate дата документа
     */
    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    /**
     * Переопределение метода toString()
     * @return строковое представление объекта UserDTO
     */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", docCode='" + docCode + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate='" + docDate + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", isIdentified='" + isIdentified + '\'' +
                '}';
    }
}
