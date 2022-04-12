package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bracket")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Bracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bracketid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaserid", nullable = false)
    private Purchaser purchaserid;

    @ManyToMany
    @JoinTable(name = "list_of_final_dishes",
            joinColumns = @JoinColumn(name = "bracketid"),
            inverseJoinColumns = @JoinColumn(name = "finaldishid"))
    private Set<FinalDish> finalDishes = new LinkedHashSet<>();

    public Set<FinalDish> getFinalDishes() {
        return finalDishes;
    }

    public void setFinalDishes(Set<FinalDish> finalDishes) {
        this.finalDishes = finalDishes;
    }

    public Purchaser getPurchaserid() {
        return purchaserid;
    }

    public void setPurchaserid(Purchaser purchaserid) {
        this.purchaserid = purchaserid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}