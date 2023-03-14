package com.example.SpringBootCrud_perso.Domain;

import jakarta.persistence.*;


@Entity // 1) Pourquoi ??
@Table(name = "students_perso") // pour la db phpMyAdmin, car la table dans la db a un nom différent donc il faut indiquer à
                                // IntelliJ ce changement
public class Students {
    @Id // indique la clé primaire
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // génère automatiquement la clé pimaire
        // 2)0          2)1

    // findAll().get(findAll().size-1).getId() + 1

    // Dernier élément d'une liste --> list.size() – 1
    // donc pour List<String> lang --> lang.get(lang.size()-1) donne le dernier élément
    private Long id;
    private String studentName;
    private String course;
    private int fee;

    public Students () {}

    // public String toString()
    @Override
    public String toString() { // appelée implicitement à chaque System.print.ln()
        return "Students{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", course='" + course + '\'' +
                ", fee=" + fee +
                '}';
    }

    public Students(Long id, String studentName, String course, int fee) {
        this.id = id;
        this.studentName = studentName;
        this.course = course;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
