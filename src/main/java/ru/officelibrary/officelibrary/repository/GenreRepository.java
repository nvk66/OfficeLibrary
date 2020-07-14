package ru.officelibrary.officelibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.Genre;

import java.util.Collection;
import java.util.Set;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    @Query(value = "SELECT g FROM Genre g WHERE g.genreId IN :ids")
    Set<Genre> findGenreByIdList(@Param("ids") Collection<Long> ids);
}
