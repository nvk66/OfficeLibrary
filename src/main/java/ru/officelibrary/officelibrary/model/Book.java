package ru.officelibrary.officelibrary.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Builder
@NoArgsConstructor
@Table(name = "books")
public class Book {
//    Книга
//    название
//    год издания
//    жанр

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookID;

    @Column
    private String bookName;

    @Column
    private int publishingYear;

    //наверное жанр тоже можно сделать через enum и загнать туда все жанры
    @Column
    private long genres;

    @Column
    private long authorID;

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public long getGenres() {
        return genres;
    }

    public void setGenres(long genres) {
        this.genres = genres;
    }

    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }
}
