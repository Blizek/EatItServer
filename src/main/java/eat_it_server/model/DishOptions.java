package eat_it_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dish_options", schema = "eatit")
@Data
public class DishOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dishoptionid", nullable = false, unique = true)
    private Long dishOptionID;

    @Column(name = "dishid", nullable = false)
    private Long dishID;

    @Column(name = "dish_option_description", nullable = false)
    private String dishOptionDescription;

    @Column(name = "dish_option_price", nullable = false)
    private float dishOptionPrice;

    public DishOptions() {

    }
}
