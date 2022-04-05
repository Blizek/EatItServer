package eat_it_server.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantid", nullable = false)
    private Integer id;

    @Column(name = "restaurant_name", nullable = false, length = 100)
    private String restaurantName;

    @Column(name = "restaurant_place", nullable = false, length = 200)
    private String restaurantPlace;

    @Column(name = "restaurant_logo_url", length = 200)
    private String restaurantLogoUrl;

    @Column(name = "restaurant_main_photo_url", length = 200)
    private String restaurantMainPhotoUrl;

    public String getRestaurantMainPhotoUrl() {
        return restaurantMainPhotoUrl;
    }

    public void setRestaurantMainPhotoUrl(String restaurantMainPhotoUrl) {
        this.restaurantMainPhotoUrl = restaurantMainPhotoUrl;
    }

    public String getRestaurantLogoUrl() {
        return restaurantLogoUrl;
    }

    public void setRestaurantLogoUrl(String restaurantLogoUrl) {
        this.restaurantLogoUrl = restaurantLogoUrl;
    }

    public String getRestaurantPlace() {
        return restaurantPlace;
    }

    public void setRestaurantPlace(String restaurantPlace) {
        this.restaurantPlace = restaurantPlace;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}