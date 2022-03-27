package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

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

    public RestaurantType() {

    }
}
