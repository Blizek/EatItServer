package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user", schema = "eatit")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false, unique = true)
    private Long userID;

    @Column(name = "userEmail", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "userPassword", nullable = false)
    private String userPassword;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "userSurname", nullable = false)
    private String userSurname;

    @Column(name = "userRole", nullable = false)
    private String userRole;

    @Column(name = "userBirthDay", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate userBirthDay;

    public User() {

    }
}
