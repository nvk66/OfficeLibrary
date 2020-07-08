package ru.officelibrary.officelibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.model.Genre;

@Repository
public interface AdminGenreRepository extends CrudRepository<Genre, Long> {
}
