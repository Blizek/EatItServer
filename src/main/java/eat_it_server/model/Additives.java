package eat_it_server.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "additives", schema = "eatit")
@Data
public class Additives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additivesid", nullable = false, unique = true)
    private Long additivesID;

    @Column(name = "dishid", nullable = false)
    private Long dishID;

    @Column(name = "additives_name", nullable = false)
    private String additivesName;

    @Column(name = "additives_price")
    private float additivesPrice;

    public Additives() {

    }
}
