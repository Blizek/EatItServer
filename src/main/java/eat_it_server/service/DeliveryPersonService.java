package eat_it_server.service;

import eat_it_server.model.DeliveryPerson;
import eat_it_server.repository.DeliveryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeliveryPersonService {
    @Autowired
    DeliveryPersonRepository deliveryPersonRepository;

    public List<DeliveryPerson> listOfAllDeliveryPersons() {
        return deliveryPersonRepository.findAll();
    }

    public void saveDeliveryPerson(DeliveryPerson deliveryPerson) {
        deliveryPersonRepository.save(deliveryPerson);
    }

    public DeliveryPerson getDeliveryPerson(Long id) {
        return deliveryPersonRepository.findById(id).get();
    }

    public void deleteDeliveryPerson(Long id) {
        deliveryPersonRepository.deleteById(id);
    }
}
