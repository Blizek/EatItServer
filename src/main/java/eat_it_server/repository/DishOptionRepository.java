package eat_it_server.repository;

import eat_it_server.model.DishOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishOptionRepository extends JpaRepository<DishOption, Integer> {
    @Query(value = "SELECT dish_options.* FROM dish_options INNER JOIN dish ON dish_options.dishid = dish.dishid WHERE " +
            "dish.dishid = ?1", nativeQuery = true)
    List<DishOption> fetchAllDishOptions(Integer id);
}
