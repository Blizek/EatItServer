package eat_it_server.controller;

import eat_it_server.model.Restaurant;
import eat_it_server.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("")
    public ResponseEntity<List<Restaurant>> fetchAllRestaurants() {
        List<Restaurant> listOfAllRestaurants = restaurantService.listOfAllRestaurants();
        return new ResponseEntity<>(listOfAllRestaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable Integer id) {
        try {
            Restaurant restaurant = restaurantService.getRestaurant(id);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Restaurant> save(@RequestBody Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Restaurant restaurant, @PathVariable Integer id) {
        try {
            Restaurant existRestaurant = restaurantService.getRestaurant(id);
            restaurant.setId(id);
            restaurantService.saveRestaurant(restaurant);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
    }
}
