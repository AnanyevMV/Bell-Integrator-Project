package ru.bellintegrator.entity;

import java.io.Serializable;

public class DocumentId implements Serializable {

    private String docCode;

    private String docNumber;

    private DocumentId() {

    }

    @Override
    public int hashCode() {
        int result = docCode.hashCode();
        return result * 31 + docNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        DocumentId documentId = (DocumentId) obj;
        if (!this.docCode.equals(documentId.docCode)) {
            return false;
        }
        return this.docNumber.equals(documentId.docNumber);
    }

    public String getDocCode() {
        return docCode;
    }

    public String getDocNumber() {
        return docNumber;
    }
}
