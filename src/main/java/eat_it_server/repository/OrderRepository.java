package eat_it_server.repository;

import eat_it_server.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT eatit.order.* FROM eatit.order INNER JOIN eatit.purchaser ON " +
            "eatit.order.purchaserid = eatit.purchaser.purchaserid INNER JOIN eatit.user ON " +
            "eatit.purchaser.userid = eatit.user.userid WHERE eatit.user.userid = ?1", nativeQuery = true)
    List<Order> allPurchaserOrders(Integer id);

    @Query(value = "SELECT eatit.order.* FROM eatit.order INNER JOIN eatit.delivery_person ON " +
            "eatit.order.deliverypersonid = eatit.delivery_person.deliverypersonid INNER JOIN eatit.user ON " +
            "eatit.delivery_person.userid = eatit.user.userid WHERE eatit.user.userid = ?1", nativeQuery = true)
    List<Order> allDeliveredOrders(Integer id);
}
