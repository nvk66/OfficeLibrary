package ru.officelibrary.officelibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.model.Book;

@Repository
public interface AdminBookRepository extends CrudRepository<Book, Long> {
    }
