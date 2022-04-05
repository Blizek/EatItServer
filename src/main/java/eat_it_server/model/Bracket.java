package eat_it_server.model;

import javax.persistence.*;

@Entity
@Table(name = "bracket")
public class Bracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bracketid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaserid", nullable = false)
    private Purchaser purchaserid;

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