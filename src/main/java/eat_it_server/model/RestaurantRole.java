package eat_it_server.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_role")
public class RestaurantRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantroleid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurantid", nullable = false)
    private Restaurant restaurantid;

    @Column(name = "restaurant_role_name", nullable = false, length = 150)
    private String restaurantRoleName;

    @Column(name = "person_can_edit_or_add_dish", nullable = false)
    private Integer personCanEditOrAddDish;

    @Column(name = "person_can_edit_employees_in_restaurant", nullable = false)
    private Integer personCanEditEmployeesInRestaurant;

    @Column(name = "person_can_change_information_about_restaurant", nullable = false)
    private Integer personCanChangeInformationAboutRestaurant;

    public Integer getPersonCanChangeInformationAboutRestaurant() {
        return personCanChangeInformationAboutRestaurant;
    }

    public void setPersonCanChangeInformationAboutRestaurant(Integer personCanChangeInformationAboutRestaurant) {
        this.personCanChangeInformationAboutRestaurant = personCanChangeInformationAboutRestaurant;
    }

    public Integer getPersonCanEditEmployeesInRestaurant() {
        return personCanEditEmployeesInRestaurant;
    }

    public void setPersonCanEditEmployeesInRestaurant(Integer personCanEditEmployeesInRestaurant) {
        this.personCanEditEmployeesInRestaurant = personCanEditEmployeesInRestaurant;
    }

    public Integer getPersonCanEditOrAddDish() {
        return personCanEditOrAddDish;
    }

    public void setPersonCanEditOrAddDish(Integer personCanEditOrAddDish) {
        this.personCanEditOrAddDish = personCanEditOrAddDish;
    }

    public String getRestaurantRoleName() {
        return restaurantRoleName;
    }

    public void setRestaurantRoleName(String restaurantRoleName) {
        this.restaurantRoleName = restaurantRoleName;
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