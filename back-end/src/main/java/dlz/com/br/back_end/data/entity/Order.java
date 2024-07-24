package dlz.com.br.back_end.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "id_order")
    @Setter(AccessLevel.NONE)
    private Long idOrder;

    @Column(name = "date_time")
    private LocalDate dateTime;

    @ManyToOne()
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> itemsInOrder;
}
