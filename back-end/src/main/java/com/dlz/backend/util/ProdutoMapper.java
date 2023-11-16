package com.dlz.backend.util;

import com.dlz.backend.dto.request.ProdutoRequestDTO;
import com.dlz.backend.dto.response.ProdutoResponseDTO;
import com.dlz.backend.model.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoMapper {

    //transforma um ProdutoRequestDTO em um Produto(entidade)
    public Produto toProduto(ProdutoRequestDTO produtoDTO){
        return Produto.builder()
                .nome(produtoDTO.getNome())
                .quantidade(produtoDTO.getQuantidade())
                .preco_em_centavos(produtoDTO.getPreco_em_centavos())
                .imagem(produtoDTO.getImagem())
                .departamento(produtoDTO.getDepartamento())
                .carrinhos(produtoDTO.getCarrinhos())
                .build();
    }

    //transforma um Produto(entidade) em um ProdutoResponseDTO
    public ProdutoResponseDTO toProdutoDTO(Produto produto){
        return new ProdutoResponseDTO(produto);
    }

    //transforma uma lista de Produto(entidade) em uma lista de ProdutoResponseDTO
    public static List<ProdutoResponseDTO> toProdutoListDTO(List<Produto> produtos){
        return produtos.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    //atualiza os dados de um Produto(entidade) com base em um ProdutoRequestDTO
    public void atualizarProduto(Produto produto, ProdutoRequestDTO produtoDTO){
        produto.setNome(produtoDTO.getNome());
        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setPreco_em_centavos(produtoDTO.getPreco_em_centavos());
        produto.setImagem(produtoDTO.getImagem());
        produto.setDepartamento(produtoDTO.getDepartamento());
        produto.setCarrinhos(produtoDTO.getCarrinhos());
    }
}
