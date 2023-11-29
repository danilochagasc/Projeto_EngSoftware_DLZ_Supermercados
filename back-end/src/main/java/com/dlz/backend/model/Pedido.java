package com.dlz.backend.model;

import com.dlz.backend.model.Cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Pedido")
@Getter
@Setter
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID idPedido;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dataHora;

    @ManyToOne()
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> produtosNoPedido;

    @Builder
    public Pedido(Cliente cliente){
        this.cliente = cliente;
        this.produtosNoPedido = new ArrayList<>();
    }

    public void adicionarItemPedido(Produto produto, int quantidade, int precoVenda) {
        ItemPedido itemPedido = ItemPedido.builder()
                .pedido(this)
                .produto(produto)
                .quantidade(quantidade)
                .precoVenda(precoVenda)
                .build();

        itemPedido.setPedido(this);
        produtosNoPedido.add(itemPedido);
    }



}
