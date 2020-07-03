package ru.officelibrary.officelibrary.dao;

import org.springframework.data.repository.CrudRepository;
import ru.officelibrary.officelibrary.model.Author;

public interface CustomizedAuthorRepository extends CrudRepository<Author, Long> {
    Author save(Author author);
}
