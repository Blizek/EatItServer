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

    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id).get();
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
