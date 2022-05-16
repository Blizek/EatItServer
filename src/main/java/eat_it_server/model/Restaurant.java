package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
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

    @Column(name = "restaurant_background_photo_url", length = 200)
    private String restaurantBackgroundPhotoUrl;

    @ManyToMany
    @JoinTable(name = "list_of_restaurant_types",
            joinColumns = @JoinColumn(name = "restaurantid"),
            inverseJoinColumns = @JoinColumn(name = "restauranttypeid"))
    private Set<RestaurantType> restaurantTypes = new LinkedHashSet<>();

    public String getRestaurantBackgroundPhotoUrl() {
        return restaurantBackgroundPhotoUrl;
    }

    public void setRestaurantBackgroundPhotoUrl(String restaurantBackgroundPhotoUrl) {
        this.restaurantBackgroundPhotoUrl = restaurantBackgroundPhotoUrl;
    }

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

    public Set<RestaurantType> getRestaurantTypes() {
        return restaurantTypes;
    }

    public void setRestaurantTypes(Set<RestaurantType> restaurantTypes) {
        this.restaurantTypes = restaurantTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}