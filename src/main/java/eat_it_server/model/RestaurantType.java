package eat_it_server.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_type")
public class RestaurantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaruanttypeid", nullable = false)
    private Integer id;

    @Column(name = "restaurant_type_name", nullable = false, length = 130)
    private String restaurantTypeName;

    public String getRestaurantTypeName() {
        return restaurantTypeName;
    }

    public void setRestaurantTypeName(String restaurantTypeName) {
        this.restaurantTypeName = restaurantTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}