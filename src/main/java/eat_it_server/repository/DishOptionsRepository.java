package eat_it_server.repository;

import eat_it_server.model.DishOptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishOptionsRepository extends JpaRepository<DishOptions, Long> {
}
