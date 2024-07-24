package dlz.com.br.back_end.service;

import dlz.com.br.back_end.data.dto.response.ProductResponseDTO;
import dlz.com.br.back_end.repository.ProductRepository;
import dlz.com.br.back_end.util.CommonMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO getProductById(Long id) {
        return new ProductResponseDTO(CommonMethods.getEntityById(id,productRepository));
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
    }
}
