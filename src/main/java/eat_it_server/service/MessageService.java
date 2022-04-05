package eat_it_server.service;

import eat_it_server.model.Message;
import eat_it_server.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> listOfAllMessages() {
        return messageRepository.findAll();
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public Message getMessages(Integer id) {
        return messageRepository.findById(id).get();
    }

    public void deleteMessage(Integer id) {
        messageRepository.deleteById(id);
    }
}
