package com.dlz.backend.repository;

import com.dlz.backend.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {

    @Query("SELECT c FROM Carrinho c WHERE c.cliente.idCliente = ?1")
    List<Carrinho> encontrarPorIdCliente(UUID idCliente);

    @Query("SELECT c FROM Carrinho c WHERE c.cliente.idCliente = ?1 AND c.produto.idProduto = ?2")
    Carrinho encontrarPorIdClienteEIdProduto(UUID idCliente, UUID idProduto);
}
