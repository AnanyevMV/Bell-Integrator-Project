package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity-класс типов документов
 */
@Entity
@Table(name = "document_type")
public class DocumentType {
    /**
     * Код документа
     */
    @Id
    @Column(name = "doc_code", nullable = false, unique = true)
    private String docCode;

    /**
     * Название документа
     */
    @Column(name = "doc_name", nullable = false, unique = true)
    private String docName;

    /**
     * Конструктор класса DocumentType
     */
    private DocumentType() {

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
     * Геттер для поля docName
     *
     * @return название документа
     */
    public String getDocName() {
        return docName;
    }

    /**
     * Переопределение метода toString()
     *
     * @return строковое представление объекта DocumentType
     */
    @Override
    public String toString() {
        return "DocumentType{" +
                "docCode='" + docCode + '\'' +
                ", docName='" + docName + '\'' +
                '}';
    }
}
