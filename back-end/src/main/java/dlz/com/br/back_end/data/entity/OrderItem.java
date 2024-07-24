package dlz.com.br.back_end.data.entity;

import jakarta.persistence.*;
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

    @ManyToOne()
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private Product product;
}
