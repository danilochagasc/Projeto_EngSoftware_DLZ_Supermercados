package com.dlz.backend.dto.response;

import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Compra;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class CompraResponseDTO {

    private UUID idCompra;

    private int valorTotal;

    private LocalDate dataCompra;

    private UUID idCarrinho;

    public CompraResponseDTO(Compra compra) {
        this.idCompra = compra.getIdCompra();
        this.valorTotal =  compra.getValorTotal();
        this.dataCompra = compra.getDataCompra();
        this.idCarrinho = compra.getCarrinho().getIdCarrinho();
    }
}
