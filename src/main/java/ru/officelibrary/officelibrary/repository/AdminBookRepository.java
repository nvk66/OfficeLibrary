package ru.officelibrary.officelibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.entity.Book;

import java.util.List;

@Repository
public interface AdminBookRepository extends CrudRepository<Book, Long> {
    @Query(value = "SELECT b FROM Book b WHERE b.authors = :author")
    List<Book> search(@Param("author") Author author);
}
