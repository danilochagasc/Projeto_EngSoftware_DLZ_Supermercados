-- Criação da tabela User
CREATE TABLE IF NOT EXISTS "User" (
    idUser SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    phone CHAR(11),
    email VARCHAR(45),
    address VARCHAR(45),
    password VARCHAR(255)
);
