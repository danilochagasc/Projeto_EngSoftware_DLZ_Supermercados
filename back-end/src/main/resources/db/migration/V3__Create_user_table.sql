-- Criação da tabela User
CREATE TABLE IF NOT EXISTS "user" (
    id_user SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    phone CHAR(11) NOT NULL,
    email VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    password VARCHAR(255) NOT NULL
);
