package dlz.com.br.back_end.data.dto.response;

import dlz.com.br.back_end.data.entity.Product;

public record ProductResponseDTO(
    Long idProduct,
    String name,
    int amount,
    double price,
    String imageLink,
    DepartmentResponseDTO department
) {
    public ProductResponseDTO(Product product) {
        this(product.getIdProduct(),
                product.getName(),
                product.getAmount(),
                product.getPrice(),
                product.getImageLink(),
                new DepartmentResponseDTO(product.getDepartment()));
    }
}
