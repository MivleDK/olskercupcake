-- Required SQL for OlskerCupcakeDB
USE olskercupcakedb;

-- -------------------------------------------------------------
-- Insert static records to tables in `users`, `products`
-- -------------------------------------------------------------
LOCK TABLES users WRITE;
INSERT INTO users (email,password,phone,role) VALUES ('admin@admin.com','1234','11111111','admin'),
													 ('jens@somewhere.com','1111','22222222','customer'),
													 ('ken@somewhere.com','2222','87654321','customer'),
													 ('robin@somewhere.com','3333','12121212','customer');
UNLOCK TABLES;

LOCK TABLES topping WRITE;
INSERT INTO topping (name,price) VALUES ('Chocolate','5'),
										('Blueberry','5'),
										('Rasberry','5'),
										('Crispy','6'),
										('Strawberry','6'),
										('Rum/Raisin','7'),
										('Orange','8'),
										('Lemon','8'),
										('Blue cheese','9');
                                                  
UNLOCK TABLES;

LOCK TABLES bottom WRITE;
INSERT INTO bottom (name,price) VALUES ('Chocolate','5'),
									   ('Vanilla','5'),
									   ('Nutmeg','5'),
									   ('Pistacio','6'),
									   ('Almond','7');
UNLOCK TABLES;
