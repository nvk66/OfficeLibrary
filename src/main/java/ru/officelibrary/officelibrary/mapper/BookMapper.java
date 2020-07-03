package ru.officelibrary.officelibrary.mapper;

import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;
import ru.officelibrary.officelibrary.model.Book;

public interface BookMapper {
    @SQLInsert(sql = "INSERT INTO books(bookName, publishingYear, genreID, authorID)" +
            "VALUES(#{bookName}, #{publishingYear}, #{genreID}, #{authorID})")
    void addBook(Book book);

    @SQLUpdate(sql = "UPDATE books SET bookName=#{bookName}, publishingYear=#{publishingYear}, genreID=#{genreID}, " +
            "authorID=#{authorID}" + " WHERE bookID=#{bookID}")
    void updateBook(Book book);
}
