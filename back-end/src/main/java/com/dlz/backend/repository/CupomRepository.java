package com.dlz.backend.repository;

import com.dlz.backend.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CupomRepository extends JpaRepository<Cupom, UUID> {

    @Query("SELECT c FROM Cupom c WHERE c.codigo = ?1")
    Cupom encontrarPorCodigo(String codigo);
}
