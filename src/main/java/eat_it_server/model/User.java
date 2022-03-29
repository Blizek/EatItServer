package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user", schema = "eatit")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false, unique = true)
    private Long userID;

    @Column(name = "restaurantid")
    private Long restaurantID;

    @Column(name = "restaurantroleid")
    private Long restaurantRoleID;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_surname", nullable = false)
    private String userSurname;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    @Column(name = "user_birth_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date userBirthDate;

    public User() {

    }
}
