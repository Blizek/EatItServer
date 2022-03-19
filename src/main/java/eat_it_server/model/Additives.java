package eat_it_server.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "additives", schema = "eatit")
@Builder
@Data
public class Additives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additivesID", nullable = false, unique = true)
    private Integer additivesID;

    @Column(name = "dishID", nullable = false)
    private Integer dishID;

    @Column(name = "additivesName", nullable = false)
    private String additivesName;

    @Column(name = "additivesPrice")
    private float additivesPrice;
}
