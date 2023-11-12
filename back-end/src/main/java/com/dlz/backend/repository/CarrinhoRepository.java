package com.dlz.backend.repository;

import com.dlz.backend.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {

    //Query que retorna o carrinho pelo id do cliente
    @Query("SELECT c FROM Carrinho c WHERE c.cliente.idCliente = ?1")
    Carrinho findByIdCliente(UUID idCliente);
}
