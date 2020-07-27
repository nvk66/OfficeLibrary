package ru.officelibrary.officelibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.id IN :ids")
    User findUserById(@Param("ids") String ids);

    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(@Param("email") String email);
}
