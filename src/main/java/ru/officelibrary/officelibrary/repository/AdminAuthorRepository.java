package ru.officelibrary.officelibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.model.Author;

@Repository
public interface AdminAuthorRepository extends CrudRepository<Author, Long> {
}
