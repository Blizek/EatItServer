package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant_type", schema = "eatit")
@Data
public class RestaurantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restauranttypeid", nullable = false, unique = true)
    private Long restaurantTypeID;

    @Column(name = "restaurant_type_name", nullable = false, unique = true)
    private String restaurantTypeName;

    @ManyToMany
    @JoinTable(
            name = "list_of_restaurant_types",
            joinColumns = @JoinColumn(name = "restauranttypeid"),
            inverseJoinColumns = @JoinColumn(name = "restaurantid"))
    private List<Restaurant> restaurants;

    public RestaurantType() {

    }
}
