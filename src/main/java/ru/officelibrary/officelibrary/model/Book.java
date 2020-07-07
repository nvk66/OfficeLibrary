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
@Table(name = "books")
public class Book {
//    Книга
//    название
//    год издания
//    жанр

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookID;

    @Column
    @NotNull
    private String bookName;

    @Column
    @NotNull
    private int publishingYear;

    //наверное жанр тоже можно сделать через enum и загнать туда все жанры
    @Column
    @NotNull
    private long genres;

    @Column
    @NotNull
    private long authorID;
}
