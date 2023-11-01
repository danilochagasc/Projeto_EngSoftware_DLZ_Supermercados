package com.dlz.backend.repository;

import com.dlz.backend.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompraRepository extends JpaRepository<Compra, UUID> {
}
