package eat_it_server.controller;

import eat_it_server.model.Bracket;
import eat_it_server.service.BracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/brackets")
public class BracketController {
    @Autowired
    BracketService bracketService;

    @GetMapping("")
    public ResponseEntity<List<Bracket>> fetchAllBaskets() {
        List<Bracket> listOfAllBrackets = bracketService.listAllBrackets();
        return new ResponseEntity<>(listOfAllBrackets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bracket> get(@PathVariable Integer id) {
        try {
            Bracket bracket = bracketService.getBracket(id);
            return new ResponseEntity<>(bracket, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<Bracket> add(@RequestBody Bracket bracket) {
        bracketService.saveBracket(bracket);
        return new ResponseEntity<>(bracket, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Bracket bracket, @PathVariable Integer id) {
        try {
            Bracket existBracket = bracketService.getBracket(id);
            bracket.setId(id);
            bracketService.saveBracket(bracket);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        bracketService.deleteBracket(id);
    }
}
