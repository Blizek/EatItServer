package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantid")
    private Restaurant restaurantid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantroleid")
    private RestaurantRole restaurantroleid;

    @Column(name = "user_email", nullable = false, length = 100)
    private String userEmail;

    @Column(name = "user_password", nullable = false, length = 100)
    private String userPassword;

    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;

    @Column(name = "user_surname", nullable = false, length = 100)
    private String userSurname;

    @Column(name = "user_role", nullable = false, length = 50)
    private String userRole;

    @Column(name = "user_birth_date", nullable = false)
    private LocalDate userBirthDate;

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public RestaurantRole getRestaurantroleid() {
        return restaurantroleid;
    }

    public void setRestaurantroleid(RestaurantRole restaurantroleid) {
        this.restaurantroleid = restaurantroleid;
    }

    public Restaurant getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Restaurant restaurantid) {
        this.restaurantid = restaurantid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}