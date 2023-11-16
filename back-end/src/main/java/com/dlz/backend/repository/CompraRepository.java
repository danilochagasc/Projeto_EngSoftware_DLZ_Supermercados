package com.dlz.backend.repository;

import com.dlz.backend.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompraRepository extends JpaRepository<Compra, UUID> {

    //Query que retorna a compra pelo id do cliente
    @Query("SELECT c FROM Compra c JOIN c.carrinho ca JOIN ca.cliente cl WHERE cl.idCliente = ?1")
    Compra encontrarPorCliente(UUID idCliente);

}
