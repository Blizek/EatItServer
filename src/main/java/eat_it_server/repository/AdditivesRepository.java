package eat_it_server.repository;

import eat_it_server.model.Additives;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditivesRepository extends JpaRepository<Additives, Integer> {
}
