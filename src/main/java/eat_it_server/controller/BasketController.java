package eat_it_server.controller;

import eat_it_server.model.Basket;
import eat_it_server.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/baskets")
public class BasketController {
    @Autowired
    BasketService basketService;

    @GetMapping("")
    public List<Basket> fetchAllBaskets() {
        return basketService.listAllBaskets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> get(@PathVariable Integer id) {
        try {
            Basket basket = basketService.getBasket(id);
            return new ResponseEntity<>(basket, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Basket basket) {
        basketService.saveBasket(basket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Basket basket, @PathVariable Integer id) {
        try {
            Basket existBasket = basketService.getBasket(id);
            basket.setBasketID(id);
            basketService.saveBasket(basket);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        basketService.deleteBasket(id);
    }
}
