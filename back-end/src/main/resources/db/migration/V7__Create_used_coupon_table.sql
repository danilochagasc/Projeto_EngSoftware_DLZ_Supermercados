-- Criação da tabela UsedCoupon
CREATE TABLE IF NOT EXISTS used_coupon (
    id_coupon INT NOT NULL,
    id_user INT NOT NULL,
    PRIMARY KEY (id_coupon, id_user)
);
