package ru.officelibrary.officelibrary.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Builder
@Entity
@NoArgsConstructor
@Table(name = "authors")
public class Author {
//    Автор
//    ФИО
//    год рождение
//    биография

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorID;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String patronymicName;

    @Column
    private int birthYear;

    @Column
    private String biography;

    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
