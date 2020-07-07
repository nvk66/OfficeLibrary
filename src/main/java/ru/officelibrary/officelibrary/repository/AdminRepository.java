package ru.officelibrary.officelibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.officelibrary.officelibrary.model.User;

@Repository
public interface AdminRepository extends CrudRepository<User, Long> {
//public interface AdminRepository extends JpaRepository<User, Long> {
//    @Query(value = "SELECT User FROM History history WHERE history.book = :bookID AND history.status = 'busy'")
//    User findUserByBookIDAndBusyStatusParams(
////            @Param("status") Status status,
//            @Param("bookID") long bookID);
}
