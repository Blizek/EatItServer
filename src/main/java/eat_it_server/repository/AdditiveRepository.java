package eat_it_server.repository;

import eat_it_server.model.Additive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdditiveRepository extends JpaRepository<Additive, Integer> {
    @Query(value = "SELECT additives.* FROM additives INNER JOIN dish ON additives.dishid = dish.dishid WHERE " +
            "dish.dishid = ?1", nativeQuery = true)
    List<Additive> dishAdditives(Integer id);
}
