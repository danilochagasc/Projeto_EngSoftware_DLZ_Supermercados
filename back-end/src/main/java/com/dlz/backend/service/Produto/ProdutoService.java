package com.dlz.backend.service.Produto;

import com.dlz.backend.dto.request.ProdutoRequestDTO;
import com.dlz.backend.dto.response.ProdutoResponseDTO;
import com.dlz.backend.model.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    ProdutoResponseDTO encontrarPorId(UUID idProduto);

    List<ProdutoResponseDTO> listarTodos();

    List<ProdutoResponseDTO> listarPorDepartamento(String nomeDep);

    List<ProdutoResponseDTO> listarEmOrdemAlfabetica(String ordem);

    ProdutoResponseDTO registrar(ProdutoRequestDTO produtoRequestDTO);

    ProdutoResponseDTO atualizar(UUID idProduto, ProdutoRequestDTO produtoRequestDTO);

    void reduzirQuantidade(UUID idProduto, int quantidade);

    void aumentarQuantidade(UUID idProduto, int quantidade);

    String deletar(UUID idProduto);

    Produto retornarProduto(UUID idProduto);
}
