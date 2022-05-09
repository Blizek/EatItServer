package eat_it_server.repository;

import eat_it_server.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query(value = "SELECT * FROM restaurant WHERE restaurant.restaurant_place LIKE %?1", nativeQuery = true)
    List<Restaurant> getRestaurantByCity(String city);

    @Query(value = "SELECT restaurant.* FROM restaurant INNER JOIN list_of_restaurant_types ON " +
            "restaurant.restaurantid = list_of_restaurant_types.restaurantid INNER JOIN restaurant_type ON" +
            " list_of_restaurant_types.restauranttypeid = restaurant_type.restaruanttypeid WHERE" +
            " restaurant.restaurant_place LIKE %?1 AND restaurant_type.restaruanttypeid = ?2", nativeQuery = true)
    List<Restaurant> getRestaurantByCityAndRestaurantType(String city, Integer restaurantType);
}
