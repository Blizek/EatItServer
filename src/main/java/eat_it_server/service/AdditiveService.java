package eat_it_server.service;

import eat_it_server.model.Additive;
import eat_it_server.repository.AdditiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdditiveService {
    @Autowired
    private AdditiveRepository additivesRepository;

    public List<Additive> listAllAdditives() {
        return additivesRepository.findAll();
    }

    public List<Additive> listOfAllDishAdditives(Integer id) {
        return additivesRepository.dishAdditives(id);
    }

    public void saveAdditives(Additive additive) {
        additivesRepository.save(additive);
    }

    public Additive getAddition(Integer id) {
        return additivesRepository.findById(id).get();
    }

    public void deleteAddition(Integer id) {
        additivesRepository.deleteById(id);
    }
}
