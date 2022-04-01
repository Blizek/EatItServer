package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bracket", schema = "eatit")
@Data
public class Bracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bracketid", nullable = false, unique = true)
    private Long basketID;

    @Column(name = "purchaserid", nullable = false)
    private Long purchaserID;

    public Bracket() {

    }
}
