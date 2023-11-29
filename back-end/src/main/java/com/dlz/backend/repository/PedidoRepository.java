package com.dlz.backend.repository;

import com.dlz.backend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    @Query("SELECT p FROM Pedido p WHERE p.cliente.idCliente = ?1")
    List<Pedido> encontrarPorIdCliente(UUID idCliente);
}
