package eat_it_server.repository;

import eat_it_server.model.Additive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditiveRepository extends JpaRepository<Additive, Integer> {
}
