package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Date;

@Entity
@IdClass(value = DocumentId.class)
public class Document {

    @Id
    @Column(name = "doc_code", nullable = false, length = 255)
    private String docCode;

    @Id
    @Column(name = "doc_number", nullable = false, length = 255)
    private String docNumber;

    @Column(name = "doc_date")
    private Date docDate;

    public Document() {

    }

    public String getDocCode() {
        return docCode;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docCode='" + docCode + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate=" + docDate +
                '}';
    }
}
