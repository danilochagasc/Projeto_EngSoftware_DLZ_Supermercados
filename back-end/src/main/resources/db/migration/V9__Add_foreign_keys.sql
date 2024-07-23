-- Adicionar constraints de chave estrangeira

-- Tabela Product
ALTER TABLE Product
    ADD CONSTRAINT fk_product_department
        FOREIGN KEY (idDepartment) REFERENCES Department (idDepartment);

-- Tabela Order
ALTER TABLE "Order"
    ADD CONSTRAINT fk_order_user
        FOREIGN KEY (idUser) REFERENCES "User" (idUser);

-- Tabela CartItem
ALTER TABLE CartItem
    ADD CONSTRAINT fk_cart_item_coupon
        FOREIGN KEY (idCoupon) REFERENCES Coupon (idCupom),
    ADD CONSTRAINT fk_cart_item_user
        FOREIGN KEY (idUser) REFERENCES "User" (idUser),
    ADD CONSTRAINT fk_cart_item_product
        FOREIGN KEY (idProduct) REFERENCES Product (idProduct);

-- Tabela UsedCoupon
ALTER TABLE UsedCoupon
    ADD CONSTRAINT fk_used_coupon_coupon
        FOREIGN KEY (idCoupon) REFERENCES Coupon (idCupom),
    ADD CONSTRAINT fk_used_coupon_user
        FOREIGN KEY (idUser) REFERENCES "User" (idUser);

-- Tabela OrderItem
ALTER TABLE OrderItem
    ADD CONSTRAINT fk_order_item_order
        FOREIGN KEY (idOrder) REFERENCES "Order" (idOrder),
    ADD CONSTRAINT fk_order_item_product
        FOREIGN KEY (idProduct) REFERENCES Product (idProduct);
