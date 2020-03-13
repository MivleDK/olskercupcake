-- Required SQL for OlskerCupcakeDB
USE olskercupcake;

-- -------------------------------------------------------------
-- Insert static records to tables in `users`, `products`
-- -------------------------------------------------------------
LOCK TABLES users WRITE;
INSERT INTO users (email,password,phone,kontobeloeb,role) VALUES ('admin@admin.com','1234','11111111','0','admin'),
																('jens@somewhere.com','1111','22222222','1000','customer'),
																('ken@somewhere.com','2222','87654321','1000','customer'),
																('robin@somewhere.com','3333','12121212','1000','customer');
UNLOCK TABLES;

LOCK TABLES products WRITE;
INSERT INTO products (name,price,category) VALUES ('Chocolate','5','Bottom'),
												  ('Vanilla','5','Bottom'),
												  ('Nutmeg','5','Bottom'),
												  ('Pistacio','6','Bottom'),
                                                  ('Almond','7','Bottom'),
                                                  ('Chocolate','5','Topping'),
                                                  ('Blueberry','5','Topping'),
                                                  ('Rasberry','5','Topping'),
                                                  ('Crispy','6','Topping'),
                                                  ('Strawberry','6','Topping'),
                                                  ('Rum/Raisin','7','Topping'),
                                                  ('Orange','8','Topping'),
                                                  ('Lemon','8','Topping'),
                                                  ('Blue cheese','9','Topping');
                                                  
UNLOCK TABLES;
