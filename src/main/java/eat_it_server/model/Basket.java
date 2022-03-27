package eat_it_server.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "basket", schema = "eatit")
@Builder
@Data
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basketID", nullable = false, unique = true)
    private Integer basketID;

    @Column(name = "purchaserID", nullable = false)
    private Integer purchaserID;

    public Basket() {

    }
}
