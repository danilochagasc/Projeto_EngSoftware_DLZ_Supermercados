-- Criação da tabela Product
CREATE TABLE IF NOT EXISTS Product (
    idProduct SERIAL PRIMARY KEY,
    name VARCHAR(70) NOT NULL,
    amount INT NOT NULL,
    price REAL NOT NULL,
    imageLink VARCHAR(45) NOT NULL,
    idDepartment INT NOT NULL
);
