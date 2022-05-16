package eat_it_server.repository;

import eat_it_server.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    @Query(value = "SELECT dish.* FROM dish INNER JOIN restaurant ON dish.restaurantid = restaurant.restaurantid WHERE " +
            "restaurant.restaurantid = ?1", nativeQuery = true)
    List<Dish> fetchAllRestaurantDishes(Integer id);
}
