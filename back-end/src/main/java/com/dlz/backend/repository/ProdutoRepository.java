package com.dlz.backend.repository;

import com.dlz.backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
    @Query("SELECT p FROM Produto p WHERE p.departamento.nome = ?1")
    List<Produto> procurarPorDepartamento(String nomeDepartamento);
}
