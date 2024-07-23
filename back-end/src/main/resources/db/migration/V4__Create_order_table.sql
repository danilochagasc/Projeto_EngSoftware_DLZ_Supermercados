-- Criação da tabela Order
CREATE TABLE IF NOT EXISTS "Order" (
    idOrder SERIAL PRIMARY KEY,
    idUser INT NOT NULL,
    dateTime TIMESTAMP NOT NULL,
    UNIQUE (idUser, dateTime)
);
