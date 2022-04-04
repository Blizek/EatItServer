package eat_it_server.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "senderuserid", nullable = false)
    private User senderuserid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipientuserid", nullable = false)
    private User recipientuserid;

    @Column(name = "message_text_value", nullable = false, length = 2000)
    private String messageTextValue;

    @Column(name = "message_date_time", nullable = false)
    private Instant messageDateTime;

    @Column(name = "message_has_been_read", nullable = false)
    private Integer messageHasBeenRead;

    public Integer getMessageHasBeenRead() {
        return messageHasBeenRead;
    }

    public void setMessageHasBeenRead(Integer messageHasBeenRead) {
        this.messageHasBeenRead = messageHasBeenRead;
    }

    public Instant getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(Instant messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public String getMessageTextValue() {
        return messageTextValue;
    }

    public void setMessageTextValue(String messageTextValue) {
        this.messageTextValue = messageTextValue;
    }

    public User getRecipientuserid() {
        return recipientuserid;
    }

    public void setRecipientuserid(User recipientuserid) {
        this.recipientuserid = recipientuserid;
    }

    public User getSenderuserid() {
        return senderuserid;
    }

    public void setSenderuserid(User senderuserid) {
        this.senderuserid = senderuserid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}