package ru.bellintegrator.dto;

/**
 * Класс OfficeDTO отвечает за DTO объекты офисов
 */
public class OfficeDTO {
    /**
     * Идентификатор офиса
     */
    private Long id;

    /**
     * Название офиса
     */
    private String name;

    /**
     * Адрес офиса
     */
    private String address;

    /**
     * Телефон офиса
     */
    private String phone;

    /**
     * Идентификатор организации
     */
    private Long orgId;

    /**
     * Активен ли офис (формат "true"/"false")
     */
    private String isActive;

    /**
     * Конструктор без параметров класса OfficeDTO
     */
    public OfficeDTO() {

    }

    /**
     * Геттер для поля id
     * @return идентификатор офиса
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер для поля id
     * @param id идентификатор офиса
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер для поля name
     * @return название офиса
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для поля name
     * @param name название офиса
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер для поля address
     * @return адрес офиса
     */
    public String getAddress() {
        return address;
    }

    /**
     * Сеттер для поля address
     * @param address адрес офиса
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Геттер для поля phone
     * @return телефон офиса
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Сеттер для поля phone
     * @param phone телефон офиса
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Геттер для поля orgId
     * @return идентификатор организации
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * Сеттер для поля orgID
     * @param orgId идентификатор организации
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * Геттер для поля isActive
     * @return активен ли офис (формат "true"/"false")
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * Сеттер для поля isActive
     * @param isActive активен ли офис (формат "true"/"false")
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * Переопределение метода toString()
     * @return строковое представление объекта OfficeDTO
     */
    @Override
    public String toString() {
        return "OfficeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", orgId=" + orgId +
                ", isActive=" + isActive +
                '}';
    }
}
