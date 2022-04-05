package eat_it_server.service;

import eat_it_server.model.Purchaser;
import eat_it_server.repository.PurchaserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PurchaserService {
    @Autowired
    PurchaserRepository purchaserRepository;

    public List<Purchaser> listOfAllPurchaser() {
        return purchaserRepository.findAll();
    }

    public void savePurchaser(Purchaser purchaser) {
        purchaserRepository.save(purchaser);
    }

    public Purchaser getPurchaser(Integer id) {
        return purchaserRepository.findById(id).get();
    }

    public void deletePurchaser(Integer id) {
        purchaserRepository.deleteById(id);
    }
}
