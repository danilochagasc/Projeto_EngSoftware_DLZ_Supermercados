package com.dlz.backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @OneToOne(cascade=CascadeType.ALL, mappedBy="carrinho")
    private Cliente cliente;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="carrinho")
    private Compra compra;

    @ManyToMany
    @JoinTable(
        name = "Carrinho_Produto",
        joinColumns = @JoinColumn(name = "idCarrinho"),
        inverseJoinColumns = @JoinColumn(name = "idProduto"))
    private List<Produto> produtos;

    @Builder
    public Carrinho(Cliente cliente, Compra compra, List<Produto> produtos) {
        this.cliente = cliente;
        this.compra = compra;
        this.produtos = produtos;
    }
}
