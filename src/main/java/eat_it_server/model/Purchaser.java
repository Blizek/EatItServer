package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "purchaser", schema = "eatit")
@Data
public class Purchaser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaserid", nullable = false, unique = true)
    private Long purchaserID;

    @Column(name = "userid", nullable = false, unique = true)
    private Long userID;

    public Purchaser() {

    }
}
