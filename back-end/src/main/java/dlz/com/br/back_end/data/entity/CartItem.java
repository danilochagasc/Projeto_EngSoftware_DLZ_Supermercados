package dlz.com.br.back_end.data.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @Column(name = "id_cart_item")
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCartItem;

    @Column(name = "amount")
    private int amount;

    @ManyToOne()
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;
}
