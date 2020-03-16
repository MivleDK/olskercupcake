-- Dummy records for OlskerCupkakeDB
USE olskercupcakedb;

-- --------------------------------------------------------------------------
-- Insert dummy records in tables `orders` and `orderline`
-- --------------------------------------------------------------------------


LOCK TABLES orders WRITE;
INSERT INTO orders (users_id,order_date,status) VALUES ('2','2020-02-28 20:59:59','Afsluttet'),
												('3','2020-03-02 16:54:27','Bestilt'),
												('4','2020-03-03 13:14:51','Afsluttet');
UNLOCK TABLES;

LOCK TABLES orderline WRITE;
INSERT INTO orderline (orders_id,quantity,sum,topping_id,bottom_id) VALUES ('1','2','20','1','2'),
																		   ('1','3','33','2','4'),
                                                                           ('2','4','44','4','3'),
                                                                           ('2','2','22','5','1'),
                                                                           ('2','1','16','9','5'),
                                                                           ('3','6','66','4','3'),
                                                                           ('3','12','144','6','1'),
                                                                           ('3','3','39','7','2');
UNLOCK TABLES;
                                                                           