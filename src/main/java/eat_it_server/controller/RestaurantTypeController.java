package eat_it_server.controller;

import eat_it_server.model.RestaurantType;
import eat_it_server.service.RestaurantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/restaurant_types")
public class RestaurantTypeController {
    @Autowired
    RestaurantTypeService restaurantTypeService;

    @GetMapping("")
    public ResponseEntity<List<RestaurantType>> fetchAllRestaurantTypes() {
        List<RestaurantType> listOfAllRestaurantTypes = restaurantTypeService.listOfAllRestaurantTypes();
        return new ResponseEntity<>(listOfAllRestaurantTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantType> get(@PathVariable Long id) {
        try {
            RestaurantType restaurantType = restaurantTypeService.getRestaurantType(id);
            return new ResponseEntity<>(restaurantType, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<RestaurantType> save(@RequestBody RestaurantType restaurantType) {
        restaurantTypeService.saveRestaurantType(restaurantType);
        return new ResponseEntity<>(restaurantType, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody RestaurantType restaurantType, @PathVariable Long id) {
        try {
            RestaurantType existRestaurantType = restaurantTypeService.getRestaurantType(id);
            restaurantType.setRestaurantTypeID(id);
            restaurantTypeService.saveRestaurantType(restaurantType);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restaurantTypeService.deleteRestaurantType(id);
    }
}
