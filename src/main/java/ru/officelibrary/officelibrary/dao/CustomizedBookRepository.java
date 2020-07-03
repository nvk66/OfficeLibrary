package ru.officelibrary.officelibrary.dao;

import org.springframework.data.repository.CrudRepository;
import ru.officelibrary.officelibrary.model.Book;

public interface CustomizedBookRepository extends CrudRepository<Book, Long> {
    Book save(Book book);
}
