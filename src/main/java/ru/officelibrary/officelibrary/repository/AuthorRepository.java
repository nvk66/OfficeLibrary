package ru.officelibrary.officelibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.Author;

import java.util.Collection;
import java.util.Set;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query(value = "SELECT a FROM Author a WHERE a.authorId IN :ids")
    Set<Author> findAuthorsByIdList(@Param("ids") Collection<Long> ids);

}
