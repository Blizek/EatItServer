package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "dish_options")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class DishOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dishoptionid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dishid", nullable = false)
    private Dish dishid;

    @Column(name = "dish_option_description", nullable = false, length = 300)
    private String dishOptionDescription;

    @Column(name = "dish_option_price", nullable = false)
    private Double dishOptionPrice;

    public Double getDishOptionPrice() {
        return dishOptionPrice;
    }

    public void setDishOptionPrice(Double dishOptionPrice) {
        this.dishOptionPrice = dishOptionPrice;
    }

    public String getDishOptionDescription() {
        return dishOptionDescription;
    }

    public void setDishOptionDescription(String dishOptionDescription) {
        this.dishOptionDescription = dishOptionDescription;
    }

    public Dish getDishid() {
        return dishid;
    }

    public void setDishid(Dish dishid) {
        this.dishid = dishid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}