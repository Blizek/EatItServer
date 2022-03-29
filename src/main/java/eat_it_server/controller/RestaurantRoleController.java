package eat_it_server.controller;

import eat_it_server.model.RestaurantRole;
import eat_it_server.service.RestaurantRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/restaurant_roles")
public class RestaurantRoleController {
    @Autowired
    RestaurantRoleService restaurantRoleService;

    @GetMapping("")
    public ResponseEntity<List<RestaurantRole>> fetchAllRestaurantRoles() {
        List<RestaurantRole> listOfAllRestaurantRoles = restaurantRoleService.listOfAllRestaurantRoles();
        return new ResponseEntity<>(listOfAllRestaurantRoles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantRole> get(@PathVariable Long id) {
        try {
            RestaurantRole restaurantRole = restaurantRoleService.getRestaurantRole(id);
            return new ResponseEntity<>(restaurantRole, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<RestaurantRole> save(@RequestBody RestaurantRole restaurantRole) {
        restaurantRoleService.saveRestaurantRole(restaurantRole);
        return new ResponseEntity<>(restaurantRole, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody RestaurantRole restaurantRole, @PathVariable Long id) {
        try {
            RestaurantRole existRestaurantRole = restaurantRoleService.getRestaurantRole(id);
            restaurantRole.setRestaurantID(id);
            restaurantRoleService.saveRestaurantRole(restaurantRole);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restaurantRoleService.deleteRestaurantRole(id);
    }
}
