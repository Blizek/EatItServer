package eat_it_server.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "additives")
public class Additive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additivesid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dishid", nullable = false)
    private Dish dishid;

    @Column(name = "additives_name", nullable = false, length = 200)
    private String additivesName;

    @Column(name = "additives_price", nullable = false)
    private Double additivesPrice;

    @ManyToMany(mappedBy = "additives")
    private Set<FinalDish> finalDishes = new LinkedHashSet<>();

    public Double getAdditivesPrice() {
        return additivesPrice;
    }

    public void setAdditivesPrice(Double additivesPrice) {
        this.additivesPrice = additivesPrice;
    }

    public String getAdditivesName() {
        return additivesName;
    }

    public void setAdditivesName(String additivesName) {
        this.additivesName = additivesName;
    }

    public Dish getDishid() {
        return dishid;
    }

    public void setDishid(Dish dishid) {
        this.dishid = dishid;
    }

    public Set<FinalDish> getFinalDishes() {
        return finalDishes;
    }

    public void setFinalDishes(Set<FinalDish> finalDishes) {
        this.finalDishes = finalDishes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}