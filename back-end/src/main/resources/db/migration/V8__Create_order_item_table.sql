-- Criação da tabela OrderItem
CREATE TABLE IF NOT EXISTS OrderItem (
    idOrder INT NOT NULL,
    idProduct INT NOT NULL,
    amount INT,
    salePrice REAL,
    idOrderItem SERIAL,
    PRIMARY KEY (idOrder, idProduct, idOrderItem)
);
