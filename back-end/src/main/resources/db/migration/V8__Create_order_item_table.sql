-- Criação da tabela OrderItem
CREATE TABLE IF NOT EXISTS order_item (
    id_order INT NOT NULL,
    id_product INT NOT NULL,
    amount INT,
    sale_price REAL,
    id_order_item SERIAL,
    PRIMARY KEY (id_order, id_product, id_order_item)
);
