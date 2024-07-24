-- Criação da tabela Department
CREATE TABLE IF NOT EXISTS department (
    id_department SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);
