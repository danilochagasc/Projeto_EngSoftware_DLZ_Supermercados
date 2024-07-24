-- Criação da tabela CartItem
CREATE TABLE IF NOT EXISTS cart_item (
    id_cart_item SERIAL PRIMARY KEY,
    amount INT,
    id_coupon INT,
    id_user INT NOT NULL,
    id_product INT NOT NULL
);
