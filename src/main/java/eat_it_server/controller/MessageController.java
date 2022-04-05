package eat_it_server.controller;

import eat_it_server.model.Message;
import eat_it_server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/messages")
public class MessageController {
    @Autowired
    MessageService messagesService;

    @GetMapping("")
    public ResponseEntity<List<Message>> fetchAllMessages() {
        List<Message> listOfAllMessages = messagesService.listOfAllMessages();
        return new ResponseEntity<>(listOfAllMessages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> get(@PathVariable Integer id) {
        try {
            Message message = messagesService.getMessages(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Message> add(@RequestBody Message message) {
        messagesService.saveMessage(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Message message, @PathVariable Integer id) {
        try {
            Message existMessage = messagesService.getMessages(id);
            message.setId(id);
            messagesService.saveMessage(message);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        messagesService.deleteMessage(id);
    }
}
