package ru.bellintegrator.entity;

import java.io.Serializable;

/**
 * Класс DocumentId представляет собой составной первичный ключ для entity Document.<br>
 * Составной ключ для документа состоит из кода документа и номера документа
 *
 * Согласно спецификации JPA, необходимо следующее для создания класса составного ключа:<br>
 * 1. Класс должен быть public<br>
 * 2. У класса должен быть конструктор без параметров.<br>
 * 3. Класс должен переопределять методы equals() и hashCode()
 * 4. Класс должен реализовывать интерфейс Serializable
 */
public class DocumentId implements Serializable {

    /**
     * Код документа
     */
    private String docCode;

    /**
     * Номер документа
     */
    private String docNumber;

    /**
     * Конструктор без параметров класса DocumentId
     */
    public DocumentId() {

    }

    /**
     * Конструктор с параметрами класса DocumentId
     *
     * @param docCode код документа
     * @param docNumber номер документа
     */
    public DocumentId(String docCode, String docNumber) {
        this.docCode = docCode;
        this.docNumber = docNumber;
    }

    /**
     * Переопределение метода hashCode()
     *
     * @return Хэш-код объекта DocumentId
     */
    @Override
    public int hashCode() {
        int result = docCode.hashCode();
        return result * 31 + docNumber.hashCode();
    }

    /**
     * Переопределение метода equals()
     *
     * @param obj объект для сравнения
     * @return true/false в зависимости от результата сравнения
     */
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
}
