-- Criação da tabela CartItem
CREATE TABLE IF NOT EXISTS CartItem (
    idCartItem SERIAL PRIMARY KEY,
    amount INT,
    idCoupon INT,
    idUser INT NOT NULL,
    idProduct INT NOT NULL
);
