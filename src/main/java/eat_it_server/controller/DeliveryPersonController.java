package eat_it_server.controller;

import eat_it_server.model.DeliveryPerson;
import eat_it_server.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/delivery_persons")
public class DeliveryPersonController {
    @Autowired
    DeliveryPersonService deliveryPersonService;

    @GetMapping("")
    public ResponseEntity<List<DeliveryPerson>> fetchAllDeliveryPersons() {
        List<DeliveryPerson> listOfAllDeliveryPersons = deliveryPersonService.listOfAllDeliveryPersons();
        return new ResponseEntity<>(listOfAllDeliveryPersons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPerson> get(@PathVariable Long id) {
        try {
            DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(id);
            return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<DeliveryPerson> save(@RequestBody DeliveryPerson deliveryPerson) {
        deliveryPersonService.saveDeliveryPerson(deliveryPerson);
        return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryPerson> update(@RequestBody DeliveryPerson deliveryPerson, @PathVariable Long id) {
        try {
            DeliveryPerson existDeliveryPerson = deliveryPersonService.getDeliveryPerson(id);
            deliveryPerson.setDeliveryPersonID(id);
            deliveryPersonService.saveDeliveryPerson(deliveryPerson);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deliveryPersonService.deleteDeliveryPerson(id);
    }
}
