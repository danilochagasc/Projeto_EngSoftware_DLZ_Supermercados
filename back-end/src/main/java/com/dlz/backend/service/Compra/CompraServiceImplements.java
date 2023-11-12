package com.dlz.backend.service.Compra;

import com.dlz.backend.dto.request.CompraRequestDTO;
import com.dlz.backend.dto.response.CompraResponseDTO;
import com.dlz.backend.model.Carrinho;
import com.dlz.backend.model.Compra;
import com.dlz.backend.repository.CarrinhoRepository;
import com.dlz.backend.repository.CompraRepository;
import com.dlz.backend.service.Carrinho.CarrinhoService;
import com.dlz.backend.util.CompraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CompraServiceImplements implements CompraService {

    final CompraRepository compraRepository;
    final CompraMapper compraMapper;
    final CarrinhoRepository carrinhoRepository;
    @Override
    public CompraResponseDTO encontrarPorId(UUID idCliente) {

        //obtendo a compra(entidade) pelo id
        Compra compra = retornarCompra(idCliente);

        //retornando a compra(entidade) em formato de compraResponseDTO
        return compraMapper.toCompraDTO(compra);
    }

    @Override
    public Compra registrar(Carrinho carrinho){

        //Criando nova Compra(entidade)
        Compra compra = Compra.builder()
                        .valorTotal(0)
                        .dataCompra(LocalDate.now())
                        .build();

        //Setando o carrinho(entidade) da compra(entidade)
        compra.setCarrinho(carrinho);

        //salvando a compra(entidade) no banco de dados
        compraRepository.save(compra);

        //retornando a compra(entidade) salva
        return compra;
    }

    @Override
    public CompraResponseDTO atualizar(UUID idCliente, CompraRequestDTO compraRequestDTO) {

        //recuperando a compra pelo id
        Compra compra = retornarCompra(idCliente);

        //esvaziando o carrinho(entidade) da compra(entidade)
        compra.getCarrinho().getProdutos().clear();

        //atualizando compra com base na compraRequestDTO
        compraMapper.atualizarCompra(compra, compraRequestDTO);

        //salvando o carrinho(entidade) no banco de dados
        carrinhoRepository.save(compra.getCarrinho());

        return compraMapper.toCompraDTO(compraRepository.save(compra));
    }

    @Override
    public String deletar(UUID idCliente) {

        //deletando a compra(entidade) do banco de dados
        compraRepository.delete(retornarCompra(idCliente));
        return "Compra deletada com sucesso";
    }

    @Override
    public Compra retornarCompra(UUID idCliente){
        return compraRepository.encontrarPorCliente(idCliente);
    }


}
