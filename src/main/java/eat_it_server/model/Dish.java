package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "dish")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dishid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurantid", nullable = false)
    private Restaurant restaurantid;

    @Column(name = "dish_name", nullable = false, length = 200)
    private String dishName;

    @Column(name = "dish_description", nullable = false, length = 1000)
    private String dishDescription;

    @Column(name = "dish_photo_url", length = 200)
    private String dishPhotoUrl;

    public String getDishPhotoUrl() {
        return dishPhotoUrl;
    }

    public void setDishPhotoUrl(String dishPhotoUrl) {
        this.dishPhotoUrl = dishPhotoUrl;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
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