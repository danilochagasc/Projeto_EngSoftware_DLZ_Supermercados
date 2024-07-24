-- Criação da tabela Product
CREATE TABLE IF NOT EXISTS product (
    id_product SERIAL PRIMARY KEY,
    name VARCHAR(70) NOT NULL,
    amount INT NOT NULL,
    price REAL NOT NULL,
    image_link VARCHAR(45) NOT NULL,
    id_department INT NOT NULL
);
