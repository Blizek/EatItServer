package eat_it_server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order", schema = "eatit")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", nullable = false, unique = true)
    private Long orderID;

    @Column(name = "purchaserid", nullable = false)
    private Long purchaserID;

    @Column(name = "bracketid", nullable = false, unique = true)
    private Long bracketID;

    @Column(name = "deliverypersonid", nullable = false)
    private Long deliveryPersonID;

    @Column(name = "order_place_of_delivery", nullable = false)
    private String orderPlaceOfDelivery;

    @Column(name = "order_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    public Order() {

    }
}
