package eat_it_server.service;

import eat_it_server.model.DishOptions;
import eat_it_server.repository.DishOptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DishOptionsService {
    @Autowired
    DishOptionsRepository dishOptionsRepository;

    public List<DishOptions> listOfAllDishOptions() {
        return dishOptionsRepository.findAll();
    }

    public void saveDishOption(DishOptions dishOptions) {
        dishOptionsRepository.save(dishOptions);
    }

    public DishOptions getDishOption(Long id) {
        return dishOptionsRepository.findById(id).get();
    }

    public void deleteDishOption(Long id) {
        dishOptionsRepository.deleteById(id);
    }
}
