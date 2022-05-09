package eat_it_server.service;

import eat_it_server.model.Restaurant;
import eat_it_server.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> listOfAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> listOfAllCityRestaurants(String city) {
        return restaurantRepository.getRestaurantByCity(city);
    }

    public List<Restaurant> listOfAllRestaurantTypeRestaurantsInCity(String city, Integer restaurantType) {
        return restaurantRepository.getRestaurantByCityAndRestaurantType(city, restaurantType);
    }

    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurant(Integer id) {
        return restaurantRepository.findById(id).get();
    }

    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }
}
