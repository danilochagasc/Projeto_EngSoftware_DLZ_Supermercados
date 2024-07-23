-- Criação da tabela UsedCoupon
CREATE TABLE IF NOT EXISTS UsedCoupon (
    idCoupon INT NOT NULL,
    idUser INT NOT NULL,
    PRIMARY KEY (idCoupon, idUser)
);
