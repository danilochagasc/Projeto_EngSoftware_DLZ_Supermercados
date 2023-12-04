package com.dlz.backend.model;

import com.dlz.backend.dto.request.CarrinhoRequestDTO;
import com.dlz.backend.model.Cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;

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

    @Builder
    public Carrinho(CarrinhoRequestDTO carrinhoRequestDTO, Cliente cliente) {
        this.cliente = cliente;
        this.produto = carrinhoRequestDTO.produto();
        this.cupom = null;
        this.quantidade = carrinhoRequestDTO.quantidade();
    }
}
