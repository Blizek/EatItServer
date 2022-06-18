package eat_it_server.controller;

import com.google.gson.Gson;
import eat_it_server.features.EmailSenderService;
import eat_it_server.model.Response;
import eat_it_server.model.User;
import eat_it_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    EmailSenderService senderService;

    @GetMapping("")
    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> listOfAllUsers = userService.listOfAllUsers();
        return new ResponseEntity<>(listOfAllUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping("/check")
    public ResponseEntity<User> checkIfCorrectLoginAndPassword(@RequestBody User userRequest) {
        User user = userService.checkIfCorrectLoginAndPassword(userRequest.getUserEmail(), userRequest.getUserPassword());
        if (user != null) return new ResponseEntity<>(user, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<User> add(@RequestBody User user) {
        try {
//        senderService.sendEmail("blazej.naziemiec@gmail.com",
//                "Test",
//                "Test email");
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = userService.getUser(id);
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
