package dlz.com.br.back_end.data.dto.response;

import dlz.com.br.back_end.data.entity.CartItem;

public record CartItemResponseDTO(
        Long idCartItem,
        int amount,
        ProductResponseDTO product
) {
    public CartItemResponseDTO(CartItem cartItem){
        this(cartItem.getIdCartItem(), cartItem.getAmount(), new ProductResponseDTO(cartItem.getProduct()));
    }
}
