package com.dlz.backend.model.Cliente;

import com.dlz.backend.model.Carrinho;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente implements UserDetails{

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

    //metodos do UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(getPermissao() == ClientePermissao.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return getSenha();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
