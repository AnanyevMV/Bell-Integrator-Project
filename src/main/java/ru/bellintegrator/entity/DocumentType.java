package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document_type")
public class DocumentType {
    @Id
    @Column(name = "doc_code", nullable = false, unique = true)
    private String docCode;

    @Column(name = "doc_name", nullable = false, unique = true)
    private String docName;

    private DocumentType() {

    }

    public String getDocCode() {
        return docCode;
    }

    public String getDocName() {
        return docName;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "docCode='" + docCode + '\'' +
                ", docName='" + docName + '\'' +
                '}';
    }
}
