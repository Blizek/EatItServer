package eat_it_server.service;

import eat_it_server.model.RestaurantRole;
import eat_it_server.repository.RestaurantRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantRoleService {
    @Autowired
    RestaurantRoleRepository restaurantRoleRepository;

    public List<RestaurantRole> listOfAllRestaurantRoles() {
        return restaurantRoleRepository.findAll();
    }

    public void saveRestaurantRole(RestaurantRole restaurantRole) {
        restaurantRoleRepository.save(restaurantRole);
    }

    public RestaurantRole getRestaurantRole(Long id) {
        return restaurantRoleRepository.findById(id).get();
    }

    public void deleteRestaurantRole(Long id) {
        restaurantRoleRepository.deleteById(id);
    }
}
