package ru.officelibrary.officelibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
//    @Query(value = "SELECT h FROM History h WHERE h.book = :bookId AND LOWER(h.status) = LOWER('busy') ")
//    List<History> search(@Param("bookID") long bookID);
}
