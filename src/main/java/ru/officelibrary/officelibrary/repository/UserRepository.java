package ru.officelibrary.officelibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
