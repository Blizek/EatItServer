package eat_it_server.service;

import eat_it_server.model.Bracket;
import eat_it_server.repository.BracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BracketService {
    @Autowired
    BracketRepository bracketRepository;

    public List<Bracket> listAllBrackets() {
        return bracketRepository.findAll();
    }

    public void saveBracket(Bracket basket) {
        bracketRepository.save(basket);
    }

    public Bracket getBracket(Integer id) {
        return bracketRepository.findById(id).get();
    }

    public void deleteBracket(Integer id) {
        bracketRepository.deleteById(id);
    }
}
