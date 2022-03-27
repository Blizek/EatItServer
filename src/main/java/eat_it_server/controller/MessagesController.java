package eat_it_server.controller;

import eat_it_server.model.Messages;
import eat_it_server.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/messages")
public class MessagesController {
    @Autowired
    MessagesService messagesService;

    @GetMapping("")
    public ResponseEntity<List<Messages>> fetchAllMessages() {
        List<Messages> listOfAllMessages = messagesService.listOfAllMessages();
        return new ResponseEntity<>(listOfAllMessages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Messages> get(@PathVariable Long id) {
        try {
            Messages message = messagesService.getMessages(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Messages> add(@RequestBody Messages message) {
        messagesService.saveMessage(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Messages message, @PathVariable Long id) {
        try {
            Messages existMessage = messagesService.getMessages(id);
            message.setMessageID(id);
            messagesService.saveMessage(message);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        messagesService.deleteMessage(id);
    }
}
