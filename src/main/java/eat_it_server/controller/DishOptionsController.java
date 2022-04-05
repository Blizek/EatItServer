package eat_it_server.controller;

import eat_it_server.model.DishOption;
import eat_it_server.service.DishOptionService;
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
    DishOptionService dishOptionsService;

    @GetMapping("")
    public ResponseEntity<List<DishOption>> fetchAllDishOptions() {
        List<DishOption> listOfAllDishOptions = dishOptionsService.listOfAllDishOptions();
        return new ResponseEntity<>(listOfAllDishOptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishOption> get(@PathVariable Integer id) {
        try {
            DishOption dishOptions = dishOptionsService.getDishOption(id);
            return new ResponseEntity<>(dishOptions, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<DishOption> save(@RequestBody DishOption dishOption) {
        dishOptionsService.saveDishOption(dishOption);
        return new ResponseEntity<>(dishOption, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DishOption dishOptions, @PathVariable Integer id) {
        try {
            DishOption existDishOption = dishOptionsService.getDishOption(id);
            dishOptions.setId(id);
            dishOptionsService.saveDishOption(dishOptions);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        dishOptionsService.deleteDishOption(id);
    }
}
