package com.dlz.backend.dto.request;

import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Departamento;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class ProdutoRequestDTO {

    private UUID idProduto;

    private  String nome;

    private int quantidade;

    private int preco_em_centavos;

    private String imagem;

    private Departamento departamento;

    private List<Carrinho> carrinhos;
}
