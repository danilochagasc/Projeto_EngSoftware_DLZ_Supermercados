package com.dlz.backend.dto.response;

import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Cliente.Cliente;
import com.dlz.backend.util.ProdutoMapper;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CarrinhoResponseDTO {

    private UUID idCarrinho;

    private UUID idCliente;

    private UUID idCompra;

    private List<ProdutoResponseDTO> produtos;

    public CarrinhoResponseDTO(Carrinho carrinho){
        this.idCarrinho = carrinho.getIdCarrinho();
        this.idCliente = carrinho.getCliente().getIdCliente();
        this.idCompra = carrinho.getCompra().getIdCompra();
        this.produtos = ProdutoMapper.toProdutoListDTO(carrinho.getProdutos());
    }
}
