package eat_it_server.repository;

import eat_it_server.model.Purchaser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaserRepository extends JpaRepository<Purchaser, Integer> {
}
