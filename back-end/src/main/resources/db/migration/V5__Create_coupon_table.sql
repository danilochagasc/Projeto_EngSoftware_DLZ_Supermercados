-- Criação da tabela Coupon
CREATE TABLE IF NOT EXISTS coupon (
    id_coupon SERIAL PRIMARY KEY,
    coupon_code VARCHAR(45) NOT NULL,
    discount_percentage REAL NOT NULL
);
