package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages", schema = "eatit")
@Data
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageid", nullable = false, unique = true)
    private Long messageID;

    @Column(name = "senderuserid", nullable = false)
    private Long senderUserID;

    @Column(name = "recipientuserid", nullable = false)
    private Long recipientUserID;

    @Column(name = "message_text_value", nullable = false)
    private String messageTextValue;

    @Column(name = "message_date_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp messageDateTime;

    @Column(name = "message_has_been_read", nullable = false)
    private boolean messageHasBeenRead;

    public Messages() {

    }
}
