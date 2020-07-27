package ru.officelibrary.officelibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
}
