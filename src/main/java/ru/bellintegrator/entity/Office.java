package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity-класс офисов
 */
@Entity
@Table(name = "office")
public class Office {
    /**
     * Идентификатор организации
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Поле version для оптимистичной блокировки
     */
    @Column(name = "version")
    private long version = 0;

    /**
     * Название офиса
     */
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(name = "address", nullable = false, length = 255)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(name = "phone", nullable = true, length = 255)
    private String phone;

    /**
     * Организация
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="org_id")
    private Organization organization;

    /**
     * Активен ли офис (формат 1/0)
     */
    @Column(name = "is_active")
    private Integer isActive;

    /**
     * Конструктор без параметров класса Office
     */
    public Office() {

    }

    /**
     * Конструктор с параметрами Office
     *
     * @param name название офиса
     * @param address адрес офиса
     * @param phone телефон офиса
     */
    public Office(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Геттер для поля id
     *
     * @return идентификатор офиса
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер для поля id
     *
     * @param id идентификатор офиса
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
     * @return название офиса
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для поля name
     *
     * @param name название офиса
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер для поля address
     *
     * @return адрес офиса
     */
    public String getAddress() {
        return address;
    }

    /**
     * Сеттер для поля address
     *
     * @param address адрес офиса
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Геттер для поля phone
     *
     * @return телефон офиса
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Сеттер для поля phone
     *
     * @param phone телефон офиса
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Геттер для поля isActive
     *
     * @return активен ли офис (формат 1/0)
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * Сеттер для поля isActive
     *
     * @param isActive активвен ли офис (формат 1/0)
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * Геттер для поля organization
     *
     * @return организация
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Сеттер для поля organization
     *
     * @param organization организация
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    /**
     * Переопределение метода toString()
     *
     * @return строковое представление объекта Office
     */
    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", organization=" + organization +
                ", isActive=" + isActive +
                '}';
    }
}
