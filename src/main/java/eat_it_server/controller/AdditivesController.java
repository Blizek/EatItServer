package eat_it_server.controller;

import eat_it_server.model.Additive;
import eat_it_server.service.AdditiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/additives")
public class AdditivesController {
    @Autowired
    AdditiveService additivesService;

    @GetMapping("")
    public ResponseEntity<List<Additive>> fetchAllAdditives() {
        List<Additive> listOfAllAdditives = additivesService.listAllAdditives();
        return new ResponseEntity<>(listOfAllAdditives, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Additive> get(@PathVariable Integer id) {
        try {
            Additive additives = additivesService.getAddition(id);
            return new ResponseEntity<>(additives, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/dish/{id}")
    public ResponseEntity<List<Additive>> fetchAllDishAdditives(@PathVariable Integer id) {
        List<Additive> listOfAllDishAdditives = additivesService.listOfAllDishAdditives(id);
        return new ResponseEntity<>(listOfAllDishAdditives, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Additive> add(@RequestBody Additive additives) {
        additivesService.saveAdditives(additives);
        return new ResponseEntity<>(additives, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Additive additive, @PathVariable Integer id) {
        try {
            Additive existAddition = additivesService.getAddition(id);
            additive.setId(id);
            additivesService.saveAdditives(additive);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        additivesService.deleteAddition(id);
    }
}
