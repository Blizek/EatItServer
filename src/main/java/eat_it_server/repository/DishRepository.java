package eat_it_server.repository;

import eat_it_server.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
