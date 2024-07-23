-- Criação da tabela Coupon
CREATE TABLE IF NOT EXISTS Coupon (
    idCupom SERIAL PRIMARY KEY,
    couponCode VARCHAR(45) NOT NULL,
    discountPercentage INT
);
