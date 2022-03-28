package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "restaurant", schema = "eatit")
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantid", nullable = false, unique = true)
    private Long restaurantID;

    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "restaurant_place", nullable = false)
    private String restaurantPlace;

    @Column(name = "restaurant_logo_url")
    private String restaurantLogoURL;

    @Column(name = "restaurant_main_photo_url")
    private String restaurantMainPhotoURL;

    public Restaurant() {

    }
}
