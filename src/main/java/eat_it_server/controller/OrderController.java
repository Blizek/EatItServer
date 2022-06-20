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
    public ResponseEntity<Order> get(@PathVariable Integer id) {
        try {
            Order order = orderService.getOrder(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/purchaser_orders/{id}")
    public ResponseEntity<List<Order>> fetchAllPurchaserOrders(@PathVariable Integer id) {
        List<Order> listOfAllPurchaserOrders = orderService.listOfAllPurchaserOrders(id);
        return new ResponseEntity<>(listOfAllPurchaserOrders, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/delivered_orders/{id}")
    public ResponseEntity<List<Order>> fetchAllDeliveredOrders(@PathVariable Integer id) {
        List<Order> listOfAllDeliveredOrders = orderService.listOfAllDeliveredOrders(id);
        return new ResponseEntity<>(listOfAllDeliveredOrders, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        orderService.saveOrder(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Integer id) {
        try {
            Order existOrder = orderService.getOrder(id);
            order.setId(id);
            orderService.saveOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }
}
