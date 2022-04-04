package eat_it_server.model;

import javax.persistence.*;

@Table(name = "list_of_restaurant_types")
public class ListOfRestaurantType {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurantid", nullable = false)
    private Restaurant restaurantid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restauranttypeid", nullable = false)
    private RestaurantType restauranttypeid;

    public RestaurantType getRestauranttypeid() {
        return restauranttypeid;
    }

    public void setRestauranttypeid(RestaurantType restauranttypeid) {
        this.restauranttypeid = restauranttypeid;
    }

    public Restaurant getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Restaurant restaurantid) {
        this.restaurantid = restaurantid;
    }
}