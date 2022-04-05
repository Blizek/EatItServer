package eat_it_server.repository;

import eat_it_server.model.DishOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishOptionRepository extends JpaRepository<DishOption, Integer> {
}
