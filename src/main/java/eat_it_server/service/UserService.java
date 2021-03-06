package eat_it_server.service;

import eat_it_server.model.User;
import eat_it_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> listOfAllUsers() {
        return userRepository.findAll();
    }

    public User checkIfCorrectLoginAndPassword(String email, String password) {
        return userRepository.checkIfCorrectLoginAndPassword(email, password);
    }

    public User checkIfUserWithThisEmailExists(String email) {
        return userRepository.checkIfUserWithThisEmailExists(email);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }

    public void changePassword(String newPassword, String email) {
        userRepository.changePassword(newPassword, email);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
