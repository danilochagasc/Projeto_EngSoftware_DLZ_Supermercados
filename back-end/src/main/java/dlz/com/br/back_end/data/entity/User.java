package dlz.com.br.back_end.data.entity;

import dlz.com.br.back_end.data.dto.request.user.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @Column(name = "id_user")
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "user")
    private List<CartItem> cart;

    @ManyToMany()
    @JoinTable(name = "used_coupon",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_coupon"))
    private List<Coupon> usedCoupons;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Builder
    public User(UserRequestDTO userRequestDTO){
        this.name = userRequestDTO.name();
        this.email = userRequestDTO.email();
        this.password = userRequestDTO.password();
        this.phone = userRequestDTO.phone();
        this.address = userRequestDTO.address();
        this.usedCoupons = new ArrayList<>();
        this.cart = new ArrayList<>();
    }
}
