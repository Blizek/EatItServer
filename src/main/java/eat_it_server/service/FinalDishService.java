package eat_it_server.service;

import eat_it_server.model.FinalDish;
import eat_it_server.repository.FinalDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FinalDishService {
    @Autowired
    FinalDishRepository finalDishRepository;

    public List<FinalDish> listOfAllFinalDishes() {
        return finalDishRepository.findAll();
    }

    public void saveFinalDish(FinalDish finalDish) {
        finalDishRepository.save(finalDish);
    }

    public FinalDish getFinalDish(Long id) {
        return finalDishRepository.findById(id).get();
    }

    public void deleteFinalDish(Long id) {
        finalDishRepository.deleteById(id);
    }
}
