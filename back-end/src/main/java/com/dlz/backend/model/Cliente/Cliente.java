package com.dlz.backend.model.Cliente;

import com.dlz.backend.dto.request.ClienteRequestDTO;
import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Cupom;
import com.dlz.backend.model.Pedido;
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

    //Relacionamentos
    @ManyToMany()
    @JoinTable(name = "CupomUsado",
            joinColumns = @JoinColumn(name = "idCliente"),
            inverseJoinColumns = @JoinColumn(name = "idCupom"))
    private List<Cupom> cuponsUsados;

    @Builder
    public Cliente(ClienteRequestDTO clienteRequestDTO, String senhaEncriptada) {
        this.nome = clienteRequestDTO.nome();
        this.email = clienteRequestDTO.email();
        this.senha = senhaEncriptada;
        this.telefone = clienteRequestDTO.telefone();
        this.endereco = clienteRequestDTO.endereco();
        this.permissao = clienteRequestDTO.permissao();
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
