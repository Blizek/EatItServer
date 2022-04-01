package eat_it_server.repository;

import eat_it_server.model.FinalDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinalDishRepository extends JpaRepository<FinalDish, Long> {
}
