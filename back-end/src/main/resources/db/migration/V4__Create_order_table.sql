-- Criação da tabela Order
CREATE TABLE IF NOT EXISTS "order" (
    id_order SERIAL PRIMARY KEY,
    id_user INT NOT NULL,
    date_time TIMESTAMP NOT NULL,
    UNIQUE (id_user, date_time)
);
