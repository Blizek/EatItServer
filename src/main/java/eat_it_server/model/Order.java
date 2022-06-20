package eat_it_server.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaserid", nullable = false)
    private Purchaser purchaserid;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bracketid", nullable = false)
    private Bracket bracketid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deliverypersonid", nullable = false)
    private DeliveryPerson deliverypersonid;

    @Column(name = "order_place_of_delivery", nullable = false, length = 200)
    private String orderPlaceOfDelivery;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "order_status", nullable = false, length = 20)
    private String orderStatus;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderPlaceOfDelivery() {
        return orderPlaceOfDelivery;
    }

    public void setOrderPlaceOfDelivery(String orderPlaceOfDelivery) {
        this.orderPlaceOfDelivery = orderPlaceOfDelivery;
    }

    public DeliveryPerson getDeliverypersonid() {
        return deliverypersonid;
    }

    public void setDeliverypersonid(DeliveryPerson deliverypersonid) {
        this.deliverypersonid = deliverypersonid;
    }

    public Bracket getBracketid() {
        return bracketid;
    }

    public void setBracketid(Bracket bracketid) {
        this.bracketid = bracketid;
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