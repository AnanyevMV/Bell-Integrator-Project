package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Date;

/**
 * Entity-класс документов
 */
@Entity
@IdClass(value = DocumentId.class)
public class Document {

    /**
     * Код документа
     */
    @Id
    @Column(name = "doc_code", nullable = false, length = 255)
    private String docCode;

    /**
     * Номер документа
     */
    @Id
    @Column(name = "doc_number", nullable = false, length = 255)
    private String docNumber;

    /**
     * Дата документа
     */
    @Column(name = "doc_date")
    private Date docDate;

    /**
     * Конструктор без параметров класса Document
     */
    public Document() {

    }

    /**
     * Конструктор с параметрами класса Document
     *
     * @param docCode код документа
     * @param docNumber номер документа
     * @param docDate дата документа
     */
    public Document(String docCode, String docNumber, Date docDate) {
        this.docCode = docCode;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    /**
     * Сеттер для поля docCode
     *
     * @param docCode код документа
     */
    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    /**
     * Сеттер для поля docNumber
     *
     * @param docNumber номер документа
     */
    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    /**
     * Сеттер для поля docDate
     *
     * @param docDate дата документа
     */
    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    /**
     * Геттер для поля docCode
     *
     * @return код документа
     */
    public String getDocCode() {
        return docCode;
    }

    /**
     * Геттер для поля docNumber
     *
     * @return номер документа
     */
    public String getDocNumber() {
        return docNumber;
    }

    /**
     * Геттер для поля docDate
     *
     * @return дата документа
     */
    public Date getDocDate() {
        return docDate;
    }

    /**
     * Переопределение метода toString()
     *
     * @return строковое представление объекта Document
     */
    @Override
    public String toString() {
        return "Document{" +
                "docCode='" + docCode + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate=" + docDate +
                '}';
    }
}
