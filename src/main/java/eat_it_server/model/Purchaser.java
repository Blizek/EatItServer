package eat_it_server.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "purchaser")
public class Purchaser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaserid", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @OneToMany(mappedBy = "purchaserid")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "purchaserid")
    private Set<Bracket> brackets = new LinkedHashSet<>();

    public Set<Bracket> getBrackets() {
        return brackets;
    }

    public void setBrackets(Set<Bracket> brackets) {
        this.brackets = brackets;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}