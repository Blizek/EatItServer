package eat_it_server.service;

import eat_it_server.model.Additives;
import eat_it_server.repository.AdditivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdditivesService {
    @Autowired
    private AdditivesRepository additivesRepository;

    public List<Additives> listAllAdditives() {
        return additivesRepository.findAll();
    }

    public void saveAdditives(Additives additives) {
        additivesRepository.save(additives);
    }

    public Additives getAddition(Long id) {
        return additivesRepository.findById(id).get();
    }

    public void deleteAddition(Long id) {
        additivesRepository.deleteById(id);
    }
}
