package com.dlz.backend.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;

import java.util.UUID;
@Getter
public class DepartamentoRequestDTO {

    private UUID idDepartamento;

    private String nome;
}
