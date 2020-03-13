-- -----------------------------------------------------
-- Schema OlskerCupcake
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `OlskerCupcake`;

-- -----------------------------------------------------
-- Schema OlskerCupcake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OlskerCupcake` DEFAULT CHARACTER SET utf8;
USE `OlskerCupcake`;

-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS users;

CREATE TABLE `users` (
  `usersID` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phone` int(8) NOT NULL,
  `kontobeloeb` decimal(10,2) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`usersID`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table `orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS orders;

CREATE TABLE `orders` (
	`ordersID` int NOT NULL AUTO_INCREMENT,
    `dato` datetime NOT NULL,
    `status` varchar(45) NOT NULL,
    PRIMARY KEY (`ordersID`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table `usersOrders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS usersOrders;

CREATE TABLE `usersOrders` (
	`usersOrdersID` int NOT NULL AUTO_INCREMENT,
	`usersID` int NOT NULL,
    `ordersID` int NOT NULL,
    PRIMARY KEY (`usersOrdersID`, `usersID`, `ordersID`),
    FOREIGN KEY (`usersID`) REFERENCES users(`usersID`),
    FOREIGN KEY (`ordersID`) REFERENCES orders(`ordersID`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table `orderline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS orderline;

CREATE TABLE `orderline` (
	`orderlineID` int NOT NULL AUTO_INCREMENT,
    `antal` int NOT NULL,
    `top` varchar(45) NOT NULL,
    `bund` varchar(45) NOT NULL,
    `totalprice` decimal(10,2) NOT NULL,
    PRIMARY KEY (`orderlineID`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table `OrdersOrderline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS OrdersOrderline;

CREATE TABLE `OrdersOrderline` (
	`OrdersOrderlineID` int NOT NULL AUTO_INCREMENT,
    `ordersID` int NOT NULL,
    `orderlineID` int NOT NULL,
    PRIMARY KEY (`OrdersOrderlineID`, `ordersID`, `orderlineID`),
    FOREIGN KEY (`ordersID`) REFERENCES orders(`ordersID`),
    FOREIGN KEY (`orderlineID`) REFERENCES orderline(`orderlineID`)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table `products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS products;

CREATE TABLE `products` (
	`productsID` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `price` decimal(10,2) NOT NULL,
    `category` varchar(45) NOT NULL,
    PRIMARY KEY (`productsID`)
) ENGINE=InnoDB;




