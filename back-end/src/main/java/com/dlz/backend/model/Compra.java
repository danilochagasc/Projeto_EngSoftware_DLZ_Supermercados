package com.dlz.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Compra")
@Getter
@Setter
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID idCompra;

    @Column(nullable = false, columnDefinition = "INT")
    private int valorTotal;

    @Column(nullable = false)
    private LocalDate dataCompra;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCarrinho", referencedColumnName = "idCarrinho")
    private Carrinho carrinho;

    @Builder
    public Compra(int valorTotal, LocalDate dataCompra, Carrinho carrinho) {
        this.valorTotal = valorTotal;
        this.dataCompra = dataCompra != null ? dataCompra : LocalDate.now();
        this.carrinho = carrinho;
    }
}
