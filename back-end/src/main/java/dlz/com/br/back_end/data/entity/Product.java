package dlz.com.br.back_end.data.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id_product")
    @Setter(AccessLevel.NONE)
    private Long idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    private double price;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToOne()
    @JoinColumn(name = "id_department", referencedColumnName = "id_department")
    private Department department;
}
