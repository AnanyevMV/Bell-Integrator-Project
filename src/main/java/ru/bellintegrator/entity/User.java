package ru.bellintegrator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "version")
    private long version = 0;

    @Column(name = "office_id", nullable = false)
    private long officeId;

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Column(name = "middle_name", nullable = true, length = 255)
    private String middleName;

    @Column(name = "position", nullable = false, length = 255)
    private String position;

    @Column(name = "phone", nullable = true, length = 255)
    private String phone;

    @Column(name = "doc_code", nullable = false, length = 255)
    private String docCode;

    @Column(name = "doc_number", nullable = false, length = 255)
    private String docNumber;

    @Column(name = "citizenship_code", nullable = false, length = 255)
    private String citizenshipCode;

    public User() {

    }

    public User(long officeId, String firstName, String lastName, String middleName,
        String position, String phone, String docCode, String docNumber, String citizenshipCode) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docCode = docCode;
        this.docNumber = docNumber;
        this.citizenshipCode = citizenshipCode;
    }

    @Column(name = "is_identified")
    private int isIdentified = 1;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", version=" + version +
                ", officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", docCode='" + docCode + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", isIdentified=" + isIdentified +
                '}';
    }
}
