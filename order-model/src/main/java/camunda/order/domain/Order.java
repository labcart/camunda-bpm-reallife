package camunda.order.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Data
@NoArgsConstructor
public class Order implements Serializable {

    private Long id;
    private String itemName;
    private Integer quantity;
    private Long orderAt;
    private String processInstanceId;
    private EntityStatus entityStatus;
    private BigDecimal amount;

    public Order(String itemName, Integer quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.orderAt = new Date().getTime();
        this.entityStatus = EntityStatus.DRAFT;
    }
}
