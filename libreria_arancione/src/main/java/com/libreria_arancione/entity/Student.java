package com.libreria_arancione.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = Student.FIND_STUDENT_BY_NAME, query = "SELECT s FROM Student s WHERE s.name like :name AND s.activate=true"),
        @NamedQuery(name = Student.FIND_STUDENT_BY_SURNAME, query = "SELECT s FROM Student s WHERE s.surname like :surname AND s.activate=true"),
})
@Table(name = "student")
public class Student extends BaseEntity {

    public final static String FIND_STUDENT_BY_NAME = "Student.findByName";
    public final static String FIND_STUDENT_BY_SURNAME = "Student.findBySurname";

    @NotBlank(message = "The name is required")
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @NotBlank(message = "The surname is required")
    private String surname;
    @Email(message = "It must be a valid email")
    @Column(nullable = false)
    @NotBlank(message = "The email is required")
    private String email;
    @Column(nullable = false)
    @NotBlank(message = "The phone is required")
    private String phone;
    @Column(nullable = false)
    @NotBlank(message = "The school year field is required")
    private String schoolYear;
    @Column(nullable = false)
    private boolean activate;

    public Student(String name, String surname, String email, String phone, String schoolYear) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.schoolYear = schoolYear;
        this.activate = true;
    }

    public Student(long id, Student student) {
        this.id = id;
        this.name = student.name;
        this.surname = student.surname;
        this.email = student.email;
        this.phone = student.phone;
        this.schoolYear = student.schoolYear;
        this.activate = student.activate;
    }
}
