package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Entity-класс организаций
 */
@Entity
@Table(name = "organization")
@NamedQuery(name = "Organization.getAll", query = "select o from Organization o")
public class Organization {
    /**
     * Идентификатор организаций
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
     * Короткое название организации
     */
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    /**
     * Полное название организации
     */
    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", nullable = false,length = 255)
    private String inn;

    /**
     * КПП
     */
    @Column(name = "kpp", nullable = false, length = 255)
    private String kpp;

    /**
     * Адрес организации
     */
    @Column(name = "address", nullable = false, length = 255)
    private String address;

    /**
     * Телефон организации
     */
    @Column(name = "phone", length = 255)
    private String phone;

    /**
     * Активна ли организация (формат 1/0)
     */
    @Column(name = "is_active")
    private Integer isActive;

    /**
     * Конструктор без параметров класса Organization
     */
    public Organization() {

    }

    /**
     * Конструктор с параметрами класса Organization
     *
     * @param name короткое название организации
     * @param fullName полное название организации
     * @param inn ИНН
     * @param kpp КПП
     * @param address адрес организации
     * @param phone телефон организации
     */
    public Organization(String name, String fullName, String inn, String kpp, String address, String phone) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Геттер для поля id
     *
     * @return идентификатор организации
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер для поля id
     *
     * @param id идентификатор организации
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
     * Геттер для поля name
     *
     * @return короткое название организации
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для поля name
     *
     * @param name короткое название организации
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер для поля fullName
     *
     * @return полное название организации
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Сеттер для поля fullName
     *
     * @param fullName полное название организации
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Геттер для поля inn
     *
     * @return ИНН
     */
    public String getInn() {
        return inn;
    }

    /**
     * Сеттер для поля inn
     *
     * @param inn ИНН
     */
    public void setInn(String inn) {
        this.inn = inn;
    }

    /**
     * Геттер для поля kpp
     *
     * @return КПП
     */
    public String getKpp() {
        return kpp;
    }

    /**
     * Сеттер для поля kpp
     *
     * @param kpp КПП
     */
    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    /**
     * Геттер для поля address
     *
     * @return адрес организации
     */
    public String getAddress() {
        return address;
    }

    /**
     * Сеттер для поля address
     *
     * @param address адрес организации
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Геттер для поля phone
     *
     * @return телефон организации
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Сеттер для поля phone
     *
     * @param phone телефон организации
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Геттер для поля isActive
     *
     * @return активна ли организация (формат 1/0)
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * Сеттер для поля isActive
     *
     * @param isActive активна ли организация (формат 1/0)
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * Переопределение метода toString()
     *
     * @return строковое представление объекта Organization
     */
    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
