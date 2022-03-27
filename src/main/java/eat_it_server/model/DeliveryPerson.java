package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "delivery_person", schema = "eatit")
@Data
public class DeliveryPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliverypersonid", nullable = false, unique = true)
    private Long deliveryPersonID;

    @Column(name = "userid", nullable = false, unique = true)
    private Long userID;

    public DeliveryPerson() {

    }
}
