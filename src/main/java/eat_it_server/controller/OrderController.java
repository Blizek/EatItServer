package eat_it_server.controller;

import eat_it_server.model.Order;
import eat_it_server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("")
    public ResponseEntity<List<Order>> fetchAllOrders() {
        List<Order> listOfAllOrders = orderService.listOfAllOrders();
        return new ResponseEntity<>(listOfAllOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id) {
        try {
            Order order = orderService.getOrder(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        orderService.saveOrder(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Long id) {
        try {
            Order existOrder = orderService.getOrder(id);
            order.setOrderID(id);
            orderService.saveOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
