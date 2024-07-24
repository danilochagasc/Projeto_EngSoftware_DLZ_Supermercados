package dlz.com.br.back_end.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @Column(name = "id_order_item")
    @Setter(AccessLevel.NONE)
    private Long idOrderItem;

    @Column(name = "amount")
    private int amount;

    @Column(name = "sale_price")
    private double salePrice;
}
