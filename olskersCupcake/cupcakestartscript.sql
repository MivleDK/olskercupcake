CREATE DATABASE  IF NOT EXISTS `cupcakes`;
USE `cupcakes`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phone` int(8) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `users` VALUES 
(1,'jens@somewhere.com','1234','12345678','customer'),
(2,'ken@somewhere.com','1234','12345678','customer'),
(3,'robin@somewhere.com','1234','12345678','customer'),
(4,'admin','1234','12345678','admin'),
(5,'totte@bader.dk','1234','12345678','customer'),
(6,'lotte@bader.dk','1234','12345678','customer'),
(7,'birgers@brunehul.dk','1234','12345678','customer'),
(8,'albert@downtown.dk','1234','12345678','customer');

DROP TABLE IF EXISTS `cupcakes`;
CREATE TABLE `cupcakes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(90) NOT NULL,
  `bottom` boolean NOT NULL,
  `topping` boolean NOT NULL,
  `price` int(10),
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

insert into `cupcakes` (name, bottom, topping, price) VALUES 
-- bottoms
('Chocolate', 1, 0, 5),
('Vanilla', 1, 0, 5),
('Nutmeg', 1, 0, 5),
('Pistacio', 1, 0, 6),
('Almond', 1, 0, 7),
-- toppings
('Chocolate', 0, 1, 5),
('Blueberry', 0, 1, 5),
('Rasberry', 0, 1, 5),
('Crispy', 0, 1, 6),
('Strawberry', 0, 1, 6),
('Rum/Raisin', 0, 1, 7),
('Orange', 0, 1, 8),
('Lemon', 0, 1, 8),
('Blue cheese', 0, 1, 9);



	
	
