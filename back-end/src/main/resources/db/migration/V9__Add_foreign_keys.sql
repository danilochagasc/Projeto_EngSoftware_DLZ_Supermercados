-- Adicionar constraints de chave estrangeira

-- Tabela Product
ALTER TABLE product
    ADD CONSTRAINT fk_product_department
        FOREIGN KEY (id_department) REFERENCES department (id_department);

-- Tabela Order
ALTER TABLE "order"
    ADD CONSTRAINT fk_order_user
        FOREIGN KEY (id_user) REFERENCES "user" (id_user);

-- Tabela CartItem
ALTER TABLE cart_item
    ADD CONSTRAINT fk_cart_item_coupon
        FOREIGN KEY (id_coupon) REFERENCES coupon (id_coupon),
    ADD CONSTRAINT fk_cart_item_user
        FOREIGN KEY (id_user) REFERENCES "user" (id_user),
    ADD CONSTRAINT fk_cart_item_product
        FOREIGN KEY (id_product) REFERENCES product (id_product);

-- Tabela UsedCoupon
ALTER TABLE used_coupon
    ADD CONSTRAINT fk_used_coupon_coupon
        FOREIGN KEY (id_coupon) REFERENCES coupon (id_coupon),
    ADD CONSTRAINT fk_used_coupon_user
        FOREIGN KEY (id_user) REFERENCES "user" (id_user);

-- Tabela OrderItem
ALTER TABLE order_item
    ADD CONSTRAINT fk_order_item_order
        FOREIGN KEY (id_order) REFERENCES "order" (id_order),
    ADD CONSTRAINT fk_order_item_product
        FOREIGN KEY (id_product) REFERENCES product (id_product);
