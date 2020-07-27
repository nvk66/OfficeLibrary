package ru.officelibrary.officelibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.entity.Genre;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "SELECT b FROM Book b WHERE b.authors IN :author", nativeQuery = true)
    List<Book> search(@Param("author") Set<Author> author);

    @Query(value = "SELECT a FROM Author a WHERE a.id IN :ids")
    Book findBookById(@Param("ids") String ids);

    List<Book> findBookByAuthorsIn(Set<Author> authors);

    List<Book> findBookByGenresIn(Set<Genre> genres);
}
