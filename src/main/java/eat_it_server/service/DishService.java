package eat_it_server.service;

import eat_it_server.model.Dish;
import eat_it_server.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DishService {
    @Autowired
    DishRepository dishRepository;

    public List<Dish> listOfAllDishes() {
        return dishRepository.findAll();
    }

    public void saveDish(Dish dish) {
        dishRepository.save(dish);
    }

    public Dish getDish(Long id) {
        return dishRepository.findById(id).get();
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}
