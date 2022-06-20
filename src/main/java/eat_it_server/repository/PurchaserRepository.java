package eat_it_server.repository;

import eat_it_server.model.Purchaser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaserRepository extends JpaRepository<Purchaser, Integer> {
    @Query(value = "SELECT eatit.purchaser.* FROM eatit.purchaser INNER JOIN eatit.user ON " +
            "eatit.purchaser.userid = eatit.user.userid WHERE eatit.user.userid = ?1", nativeQuery = true)
    Purchaser getUsersPurchaser(Integer id);
}
