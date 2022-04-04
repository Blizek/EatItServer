package eat_it_server.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "final_dish")
public class FinalDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finaldishid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dishid", nullable = false)
    private Dish dishid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dishoptionid", nullable = false)
    private DishOption dishoptionid;

    @ManyToMany
    @JoinTable(name = "list_of_additives",
            joinColumns = @JoinColumn(name = "finaldishid"),
            inverseJoinColumns = @JoinColumn(name = "additivesid"))
    private Set<Additive> additives = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "list_of_final_dishes",
            joinColumns = @JoinColumn(name = "finaldishid"),
            inverseJoinColumns = @JoinColumn(name = "bracketid"))
    private Set<Bracket> brackets = new LinkedHashSet<>();

    public Set<Bracket> getBrackets() {
        return brackets;
    }

    public void setBrackets(Set<Bracket> brackets) {
        this.brackets = brackets;
    }

    public Set<Additive> getAdditives() {
        return additives;
    }

    public void setAdditives(Set<Additive> additives) {
        this.additives = additives;
    }

    public DishOption getDishoptionid() {
        return dishoptionid;
    }

    public void setDishoptionid(DishOption dishoptionid) {
        this.dishoptionid = dishoptionid;
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