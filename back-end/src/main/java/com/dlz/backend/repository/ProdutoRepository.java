package com.dlz.backend.repository;

import com.dlz.backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
}
