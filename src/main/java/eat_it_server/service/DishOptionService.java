package eat_it_server.service;

import eat_it_server.model.DishOption;
import eat_it_server.repository.DishOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DishOptionService {
    @Autowired
    DishOptionRepository dishOptionRepository;

    public List<DishOption> listOfAllDishOptions() {
        return dishOptionRepository.findAll();
    }

    public List<DishOption> listOfAllDishOptions(Integer id) {
        return dishOptionRepository.fetchAllDishOptions(id);
    }

    public void saveDishOption(DishOption dishOption) {
        dishOptionRepository.save(dishOption);
    }

    public DishOption getDishOption(Integer id) {
        return dishOptionRepository.findById(id).get();
    }

    public void deleteDishOption(Integer id) {
        dishOptionRepository.deleteById(id);
    }
}
