package eat_it_server.controller;

import eat_it_server.model.DishOptions;
import eat_it_server.service.DishOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/dish_options")
public class DishOptionsController {
    @Autowired
    DishOptionsService dishOptionsService;

    @GetMapping("")
    public ResponseEntity<List<DishOptions>> fetchAllDishOptions() {
        List<DishOptions> listOfAllDishOptions = dishOptionsService.listOfAllDishOptions();
        return new ResponseEntity<>(listOfAllDishOptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishOptions> get(@PathVariable Long id) {
        try {
            DishOptions dishOptions = dishOptionsService.getDishOption(id);
            return new ResponseEntity<>(dishOptions, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<DishOptions> save(@RequestBody DishOptions dishOptions) {
        dishOptionsService.saveDishOption(dishOptions);
        return new ResponseEntity<>(dishOptions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DishOptions dishOptions, @PathVariable Long id) {
        try {
            DishOptions existDishOption = dishOptionsService.getDishOption(id);
            dishOptions.setDishOptionID(id);
            dishOptionsService.saveDishOption(dishOptions);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dishOptionsService.deleteDishOption(id);
    }
}
