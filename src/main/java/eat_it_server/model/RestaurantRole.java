package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_role", schema = "eatit")
@Data
public class RestaurantRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantroleid", nullable = false, unique = true)
    private Long restaurantRoleID;

    @Column(name = "restaurantid", nullable = false)
    private Long restaurantID;

    @Column(name = "restaurant_role_name", nullable = false)
    private String restaurantRoleName;

    @Column(name = "person_can_edit_or_add_dish", nullable = false)
    private boolean personCanEditOrAddDish;

    @Column(name = "person_can_edit_employees_in_restaurant", nullable = false)
    private boolean personCanEditEmployeesInRestaurant;

    @Column(name ="person_can_change_information_about_restaurant", nullable = false)
    private boolean personCanChangeInformationAboutRestaurant;

    public RestaurantRole() {

    }
}
