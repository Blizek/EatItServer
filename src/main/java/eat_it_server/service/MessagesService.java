package eat_it_server.service;

import eat_it_server.model.Messages;
import eat_it_server.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    public List<Messages> listOfAllMessages() {
        return messagesRepository.findAll();
    }

    public void saveMessage(Messages message) {
        messagesRepository.save(message);
    }

    public Messages getMessages(Long id) {
        return messagesRepository.findById(id).get();
    }

    public void deleteMessage(Long id) {
        messagesRepository.deleteById(id);
    }
}
