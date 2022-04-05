package eat_it_server.model;

import javax.persistence.*;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}