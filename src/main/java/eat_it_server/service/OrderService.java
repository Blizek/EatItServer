package eat_it_server.service;

import eat_it_server.model.Order;
import eat_it_server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> listOfAllOrders() {
        return orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrder(Integer id) {
        return orderRepository.findById(id).get();
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
