package ru.officelibrary.officelibrary.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "authors")
public class Author {
//    Автор
//    ФИО
//    год рождение
//    биография

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorID;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private String patronymicName;

    @Column
    @NotNull
    private int birthYear;

    @Column
    @NotNull
    private String biography;
}
