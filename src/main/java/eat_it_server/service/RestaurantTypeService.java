package eat_it_server.service;

import eat_it_server.model.RestaurantType;
import eat_it_server.repository.RestaurantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantTypeService {
    @Autowired
    RestaurantTypeRepository restaurantTypeRepository;

    public List<RestaurantType> listOfAllRestaurantTypes() {
        return restaurantTypeRepository.findAll();
    }

    public void saveRestaurantType(RestaurantType restaurantType) {
        restaurantTypeRepository.save(restaurantType);
    }

    public RestaurantType getRestaurantType(Long id) {
        return restaurantTypeRepository.findById(id).get();
    }

    public void deleteRestaurantType(Long id) {
        restaurantTypeRepository.deleteById(id);
    }
}
