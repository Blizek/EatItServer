package eat_it_server.controller;

import eat_it_server.model.FinalDish;
import eat_it_server.service.FinalDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/final_dishes")
public class FinalDishController {
    @Autowired
    FinalDishService finalDishService;

    @GetMapping("")
    public ResponseEntity<List<FinalDish>> fetchAllFinalDishes() {
        List<FinalDish> listOfAllFinalDishes = finalDishService.listOfAllFinalDishes();
        return new ResponseEntity<>(listOfAllFinalDishes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinalDish> get(@PathVariable Integer id) {
        try {
            FinalDish finalDish = finalDishService.getFinalDish(id);
            return new ResponseEntity<>(finalDish, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<FinalDish> save(@RequestBody FinalDish finalDish) {
        finalDishService.saveFinalDish(finalDish);
        return new ResponseEntity<>(finalDish, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FinalDish finalDish, @PathVariable Integer id) {
        try {
            FinalDish existFinalDish = finalDishService.getFinalDish(id);
            finalDish.setId(id);
            finalDishService.saveFinalDish(finalDish);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        finalDishService.deleteFinalDish(id);
    }
}
