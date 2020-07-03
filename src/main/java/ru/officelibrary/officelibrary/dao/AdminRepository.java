package ru.officelibrary.officelibrary.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.model.User;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Optional<User>, Long> {
    Optional<User> save(User user);

    void delete(User user);
}
