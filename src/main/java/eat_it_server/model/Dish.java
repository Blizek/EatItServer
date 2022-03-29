package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dish", schema = "eatit")
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dishid", nullable = false, unique = true)
    private Long dishID;

    @Column(name = "restaurantid", nullable = false)
    private Long restaurantID;

    @Column(name = "dish_name", nullable = false)
    private String dishName;

    @Column(name = "dish_description", nullable = false)
    private String dishDescription;

    @Column(name = "dish_photo_url")
    private String dishPhotoURL;

    public Dish() {

    }
}
