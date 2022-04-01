package eat_it_server.controller;

import eat_it_server.model.Additives;
import eat_it_server.service.AdditivesService;
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
    AdditivesService additivesService;

    @GetMapping("")
    public ResponseEntity<List<Additives>> fetchAllAdditives() {
        List<Additives> listOfAllAdditives = additivesService.listAllAdditives();
        return new ResponseEntity<>(listOfAllAdditives, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Additives> get(@PathVariable Long id) {
        try {
            Additives additives = additivesService.getAddition(id);
            return new ResponseEntity<>(additives, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Additives> add(@RequestBody Additives additives) {
        additivesService.saveAdditives(additives);
        return new ResponseEntity<>(additives, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Additives additives, @PathVariable Long id) {
        try {
            Additives existAddition = additivesService.getAddition(id);
            additives.setAdditivesID(id);
            additivesService.saveAdditives(additives);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        additivesService.deleteAddition(id);
    }
}
