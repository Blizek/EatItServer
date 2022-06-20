package eat_it_server.repository;

import eat_it_server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user WHERE user_email = ?1 AND user_password = ?2", nativeQuery = true)
    User checkIfCorrectLoginAndPassword(String email, String password);

    @Query(value = "SELECT * FROM eatit.user WHERE eatit.user.user_email = ?1", nativeQuery = true)
    User checkIfUserWithThisEmailExists(String email);

    @Modifying
    @Query(value = "UPDATE eatit.user SET eatit.user.user_password = ?1 WHERE eatit.user.user_email = ?2", nativeQuery = true)
    void changePassword(String newPassword, String email);
}
