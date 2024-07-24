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
@Table(name = "coupon")
public class Coupon {

    @Id
    @Column(name = "id_coupon")
    @Setter(AccessLevel.NONE)
    private Long idCoupon;

    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "discount_percentage")
    private double discountPercentage;
}
