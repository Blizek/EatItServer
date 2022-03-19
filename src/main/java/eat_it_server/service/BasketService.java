package eat_it_server.service;

import eat_it_server.model.Additives;
import eat_it_server.model.Basket;
import eat_it_server.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BasketService {
    @Autowired
    BasketRepository basketRepository;

    public List<Basket> listAllBaskets() {
        return basketRepository.findAll();
    }

    public void saveBasket(Basket basket) {
        basketRepository.save(basket);
    }

    public Basket getBasket(Integer id) {
        return basketRepository.findById(id).get();
    }

    public void deleteBasket(Integer id) {
        basketRepository.deleteById(id);
    }
}
