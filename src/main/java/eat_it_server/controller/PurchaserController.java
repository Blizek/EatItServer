package eat_it_server.controller;

import eat_it_server.model.Purchaser;
import eat_it_server.service.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/purchasers")
public class PurchaserController {
    @Autowired
    PurchaserService purchaserService;

    @GetMapping("")
    public ResponseEntity<List<Purchaser>> fetchAllPurchasers() {
        List<Purchaser> listOfAllPurchasers = purchaserService.listOfAllPurchaser();
        return new ResponseEntity<>(listOfAllPurchasers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchaser> get(@PathVariable Integer id) {
        try {
            Purchaser purchaser = purchaserService.getPurchaser(id);
            return new ResponseEntity<>(purchaser, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Purchaser> add(@RequestBody Purchaser purchaser) {
        purchaserService.savePurchaser(purchaser);
        return new ResponseEntity<>(purchaser, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Purchaser purchaser, @PathVariable Integer id) {
        try {
            Purchaser existPurchaser = purchaserService.getPurchaser(id);
            purchaser.setId(id);
            purchaserService.savePurchaser(purchaser);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePurchaser(@PathVariable Integer id) {
        purchaserService.deletePurchaser(id);
    }
}
