package ru.officelibrary.officelibrary.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "authors")
public class Author implements Serializable, Comparable<Author> {
//    Автор
//    ФИО
//    год рождение
//    биография

    @Id
    @NotNull
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorId;

    @Column
    @NotNull
    @NotBlank
    @Size(min=2, max= 40)
    private String name;

    @Column
    @NotNull
    @NotBlank
    @Size(min=2, max= 40)
    private String lastName;

    @Column
    @Size(max= 40)
    private String patronymicName;

    @Column
    @NotNull
    private int birthYear;

    @Column
    @NotNull
    @ToString.Exclude
    @NotBlank
    @Size(min=40, max= 1000)
    private String biography;

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorID) {
        this.authorId = authorID;
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

//    @Override
//    public String toString() {
//        return "Author [id=" + authorId + ", lastName=" + lastName + ", name=" + name +
//                ", patronymicName=" + patronymicName + ", birthYear=" + birthYear + ", biography=" + biography + "]";
//    }

    public String concat(){
        return this.lastName + " " + this.name + " " + this.patronymicName;
    }

    @Override
    public int compareTo(Author author) {
        return this.concat().toLowerCase().compareTo(author.concat().toLowerCase());
    }
}
