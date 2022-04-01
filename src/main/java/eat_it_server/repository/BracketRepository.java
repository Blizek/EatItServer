package eat_it_server.repository;

import eat_it_server.model.Bracket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BracketRepository extends JpaRepository<Bracket, Long> {
}
