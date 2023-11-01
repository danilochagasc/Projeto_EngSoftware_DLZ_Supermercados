package com.dlz.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Departamento")
@Getter
@Setter
@NoArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID idDepartamento;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String nome;



    @Builder
    public Departamento(String nome) {
        this.nome = nome;
    }


}
