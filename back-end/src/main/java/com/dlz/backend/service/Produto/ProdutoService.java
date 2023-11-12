package com.dlz.backend.service.Produto;

import com.dlz.backend.dto.request.ProdutoRequestDTO;
import com.dlz.backend.dto.response.ProdutoResponseDTO;
import com.dlz.backend.model.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    ProdutoResponseDTO encontrarPorId(UUID id);

    List<ProdutoResponseDTO> listarTodos();

    List<ProdutoResponseDTO> listarPorDepartamento(String nomeDep);

    ProdutoResponseDTO registrar(ProdutoRequestDTO produtoRequestDTO);

    ProdutoResponseDTO atualizar(UUID id, ProdutoRequestDTO produtoRequestDTO);

    String deletar(UUID id);

    Produto retornarProduto(UUID id);
}
