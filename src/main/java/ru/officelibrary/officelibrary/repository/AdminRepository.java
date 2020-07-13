package ru.officelibrary.officelibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.User;

@Repository
public interface AdminRepository extends CrudRepository<User, Long> {
}
