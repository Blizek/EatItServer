package eat_it_server.controller;

import eat_it_server.model.Dish;
import eat_it_server.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/dishes")
public class DishController {
    @Autowired
    DishService dishService;

    @GetMapping("")
    public ResponseEntity<List<Dish>> fetchAllDishes() {
        List<Dish> listOfAllDishes = dishService.listOfAllDishes();
        return new ResponseEntity<>(listOfAllDishes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> get(@PathVariable Integer id) {
        try {
            Dish dish = dishService.getDish(id);
            return new ResponseEntity<>(dish, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<Dish>> fetchAllRestaurantDishes(@PathVariable Integer id) {
        try {
            List<Dish> listOfAllRestaurantDishes = dishService.listOfAllRestaurantDishes(id);
            return new ResponseEntity<>(listOfAllRestaurantDishes, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Dish> save(@RequestBody Dish dish) {
        dishService.saveDish(dish);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Dish dish, @PathVariable Integer id) {
        try {
            Dish existDish = dishService.getDish(id);
            dish.setId(id);
            dishService.saveDish(dish);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        dishService.deleteDish(id);
    }
}
