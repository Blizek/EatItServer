package eat_it_server.repository;

import eat_it_server.model.RestaurantRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRoleRepository extends JpaRepository<RestaurantRole, Integer> {
}
