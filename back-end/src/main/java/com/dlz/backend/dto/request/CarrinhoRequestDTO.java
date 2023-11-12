package com.dlz.backend.dto.request;

import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.model.Compra;
import com.dlz.backend.model.Produto;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CarrinhoRequestDTO {

    private UUID idCarrinho;

    private Cliente cliente;

    private Compra compra;

    private List<Produto> produtos;

}
