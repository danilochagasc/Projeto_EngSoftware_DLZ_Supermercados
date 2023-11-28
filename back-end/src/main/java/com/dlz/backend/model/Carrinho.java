package com.dlz.backend.model;

import com.dlz.backend.model.Cliente.Cliente;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Carrinho")
@Getter
@Setter
@NoArgsConstructor
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID idCarrinho;

    @ManyToOne()
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto", nullable = false)
    private Produto produto;

    @ManyToOne()
    @JoinColumn(name = "idCupom", referencedColumnName = "idCupom", nullable = true)
    private Cupom cupom;

    @Column(nullable = false)
    private int quantidade;
}
