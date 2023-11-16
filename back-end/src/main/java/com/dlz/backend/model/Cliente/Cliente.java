package com.dlz.backend.model.Cliente;

import com.dlz.backend.model.Carrinho;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID idCliente;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String nome;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String senha;

    @Column(nullable = false, columnDefinition = "CHAR(11)")
    private String telefone;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String endereco;

    @Column(nullable = false)
    private ClientePermissao permissao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCarrinho", referencedColumnName = "idCarrinho")
    private Carrinho carrinho;

    @Builder
    public Cliente(String nome, String email, String senha, String telefone, String endereco, ClientePermissao permissao, Carrinho carrinho) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.permissao = permissao;
        this.carrinho = carrinho;
    }
}
