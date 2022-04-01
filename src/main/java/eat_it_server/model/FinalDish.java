package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "final_dish", schema = "eatit")
@Data
public class FinalDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finaldishid", nullable = false, unique = true)
    private Long finalDishID;

    @Column(name = "dishid", nullable = false)
    private Long dishID;

    @Column(name = "dishoptionid", nullable = false)
    private Long dishOptionID;

    public FinalDish() {

    }
}
