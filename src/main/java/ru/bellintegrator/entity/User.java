package ru.bellintegrator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


/**
 * Entity-класс пользователей
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.getAll", query = "select u from User u join fetch u.office")
public class User {
    /**
     * Идентификатор пользователя
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Поле version для оптимистичной блокировки
     */
    @Version
    @Column(name = "version")
    private long version = 0;

    /**
     * Офис
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Имя пользователя
     */
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    /**
     * Второе личное имя пользователя
     */
    @Column(name = "middle_name", nullable = true, length = 255)
    private String middleName;

    /**
     * Должность
     */
    @Column(name = "position", nullable = false, length = 255)
    private String position;

    /**
     * Телефон пользователя
     */
    @Column(name = "phone", nullable = true, length = 255)
    private String phone;

    /**
     * Идентифицирован ли пользователь (формат 1/0)
     */
    @Column(name = "is_identified")
    private Integer isIdentified;

    /**
     * Документ
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumns({
        @JoinColumn(name="doc_code", referencedColumnName = "doc_code"),
        @JoinColumn(name="doc_number", referencedColumnName = "doc_number")
    })
    private Document document;

    /**
     * Код гражданства
     */
    @Column(name = "citizenship_code", nullable = false, length = 255)
    private String citizenshipCode;

    /**
     * Конструктор без параметров класса User
     */
    public User() {

    }

    /**
     * Конструктор с параметрами класса User
     *
     * @param firstName имя пользователя
     * @param lastName фамилия пользователя
     * @param middleName второе личное имя пользователя
     * @param position должность
     * @param phone телефон пользователя
     * @param citizenshipCode код гражданства
     */
    public User(String firstName, String lastName, String middleName,
        String position, String phone, String citizenshipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.citizenshipCode = citizenshipCode;
    }

    /**
     * Геттер для поля id
     *
     * @return идентификатор пользователя
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер для поля id
     *
     * @param id идентификатор пользователя
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер для поля version
     *
     * @return поле version для оптимистичной блокировки
     */
    public long getVersion() {
        return version;
    }

    /**
     * Сеттер для поля version
     *
     * @param version поле version для оптимистичной блокировки
     */
    private void setVersion(long version) {
        this.version = version;
    }

    /**
     * Геттер для поля office
     *
     * @return офис
     */
    public Office getOffice() {
        return office;
    }

    /**
     * Сеттер для поля office
     *
     * @param office офис
     */
    public void setOffice(Office office) {
        this.office = office;
    }

    /**
     * Геттер для поля firstName
     *
     * @return имя пользователя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Сеттер для поля firstName
     *
     * @param firstName имя пользователя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Геттер для поля lastName
     *
     * @return фамилия пользователя
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Сеттер для поля lastName
     *
     * @param lastName фамилия пользователя
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Геттер для поля middleName
     *
     * @return второе личное имя пользователя
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Сеттер для поля middleName
     *
     * @param middleName второе личное имя пользователя
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Геттер для поля position
     *
     * @return должность
     */
    public String getPosition() {
        return position;
    }

    /**
     * Сеттер для поля position
     *
     * @param position должность
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Геттер для поля phone
     *
     * @return телефон пользователя
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Сеттер для поля phone
     *
     * @param phone телефон пользователя
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Геттер для поля citizenshipCode
     *
     * @return код страны
     */
    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    /**
     * Сеттер для поля citizenshipCode
     *
     * @param citizenshipCode код страны
     */
    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    /**
     * Геттер для поля isIdentified
     *
     * @return идентифицирован ли пользователь (формат 1/0)
     */
    public Integer getIsIdentified() {
        return isIdentified;
    }

    /**
     * Сеттер для поля isIdentified
     *
     * @param isIdentified идентифицирован ли пользователь (формат 1/0)
     */
    public void setIsIdentified(Integer isIdentified) {
        this.isIdentified = isIdentified;
    }

    /**
     * Геттер для поля document
     *
     * @return документ
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Сеттер для поля document
     *
     * @param document документ
     */
    public void setDocument(Document document) {
        this.document = document;
    }

    /**
     * Переопределение метода toString()
     *
     * @return строковое представление объекта User
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", version=" + version +
                ", office=" + office +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", document=" + document +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", isIdentified=" + isIdentified +
                '}';
    }

}
