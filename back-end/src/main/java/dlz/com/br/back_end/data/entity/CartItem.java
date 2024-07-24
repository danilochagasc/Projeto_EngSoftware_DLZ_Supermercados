package dlz.com.br.back_end.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @Column(name = "id_cart_item")
    @Setter(AccessLevel.NONE)
    private Long idCartItem;

    @Column(name = "amount")
    private int amout;

    @ManyToOne()
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;
}
