package ru.bellintegrator.dto;

/**
 * Класс OrganizationDTO отвечает за DTO объекты организаций
 */
public class OrganizationDTO {

    /**
     * Идентификатор организации
     */
    private Long id;

    /**
     * Короткое название организации
     */
    private String name;

    /**
     * Полное название организации
     */
    private String fullName;

    /**
     * ИНН
     */
    private String inn;

    /**
     * КПП
     */
    private String kpp;

    /**
     * Адрес организации
     */
    private String address;

    /**
     * Телефон организации
     */
    private String phone;

    /**
     * Активна ли организация (формат "true"/"false")
     */
    private String isActive;

    /**
     * Конструктор без параметров класса OrganizationDTO
     */
    public OrganizationDTO() {

    }

    /**
     * Геттер для поля id
     * @return идентификатор организации
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер для поля id
     * @param id идентификатор организации
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер для поля name
     * @return короткое имя организации
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для поля name
     * @param name короткое имя организации
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер для поля fullName
     * @return полное имя организации
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Сеттер для поля fullName
     * @param fullName полное имя организации
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Геттер для поля inn
     * @return ИНН организации
     */
    public String getInn() {
        return inn;
    }

    /**
     * Сеттер для поля inn
     * @param inn ИНН организации
     */
    public void setInn(String inn) {
        this.inn = inn;
    }

    /**
     * Геттер для поля kpp
     * @return КПП организации
     */
    public String getKpp() {
        return kpp;
    }

    /**
     * Сеттер для поля kpp
     * @param kpp КПП организации
     */
    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    /**
     * Геттер для поля address
     * @return адрес организации
     */
    public String getAddress() {
        return address;
    }

    /**
     * Сеттер для поля address
     * @param address адрес организации
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Геттер для поля phone
     * @return телефон организации
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Сеттер для поля phone
     * @param phone телефон организации
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Геттер для поля isActive
     * @return активна ли организация (формат "true"/"false")
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * Сеттер для поля isActive
     * @param isActive активна ли организация (формат "true"/"false")
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * Переопределение метода toString()
     * @return строковое представление объекта OrganizationDTO
     */
    @Override
    public String toString() {
        return "OrganizationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
