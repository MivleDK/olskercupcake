-- Dummy records for OlskerCupkakeDB
USE olskercupcake;

-- --------------------------------------------------------------------------
-- Insert dummy records in tables `usersorders`, `orders`, `ordersorderline` and `orderline`
-- --------------------------------------------------------------------------


LOCK TABLES orders WRITE;
INSERT INTO orders (dato,status) VALUES ('2020-02-28 20:59:59','Bestilt'),
										('2020-03-02 16:54:27','Bestil'),
										('2020-03-03 13:14:51','Behandler');
UNLOCK TABLES;

LOCK TABLES usersorders WRITE;
INSERT INTO usersorders (usersID,ordersID) VALUES ('2','1'),
												  ('3','2'),
                                                  ('4','3');
UNLOCK TABLES;

LOCK TABLES orderline WRITE;
INSERT INTO orderline (antal,top,bund,totalprice) VALUES ('2','Chocolate','Blueberry','20'),
														 ('3','Vanilla','Crispy','33'),
														 ('1','Pistacio','Chocolate','11'),
														 ('5','Almond','Rasberry','60'),
														 ('4','Nutmeg','Strawberry','44'),
														 ('2','Vanilla','Chocolate','20'),
														 ('6','Nutmeg','Orange','78'),
														 ('4','Almond','Lemon','60');
UNLOCK TABLES;

LOCK TABLES ordersorderline WRITE;
INSERT INTO ordersorderline (ordersID,orderlineID) VALUES ('1','1'),
														  ('1','2'),
														  ('1','3'),
														  ('2','4'),
														  ('2','5'),
														  ('3','6'),
														  ('3','7'),
														  ('3','8');
UNLOCK TABLES;

