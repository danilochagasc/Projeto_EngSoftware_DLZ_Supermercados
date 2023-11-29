package com.dlz.backend.model;

import com.dlz.backend.dto.request.CupomRequestDTO;
import com.dlz.backend.model.Cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Cupom")
@Getter
@Setter
@NoArgsConstructor
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID idCupom;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String codigo;

    @Column(nullable = false, columnDefinition = "INT")
    private int valorDesconto;

    @ManyToMany(mappedBy = "cuponsUsados")
    private List<Cliente> clientesComCupom;

    @Builder
    public Cupom(CupomRequestDTO cupomRequestDTO) {
        this.codigo = cupomRequestDTO.codigo();
        this.valorDesconto = cupomRequestDTO.valorDesconto();
        this.clientesComCupom = new ArrayList<>();
    }

}
