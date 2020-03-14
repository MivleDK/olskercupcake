-- MySQL for OlskerCupcakeDB

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema olskercupcakedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `olskercupcakedb`;
-- -----------------------------------------------------
-- Schema olskercupcakedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `olskercupcakedb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `olskercupcakedb` ;

-- -----------------------------------------------------
-- Table `olskercupcakedb`.`bottom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `olskercupcakedb`.`bottom` (
  `bottom_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`bottom_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `olskercupcakedb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `olskercupcakedb`.`users` (
  `users_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` INT(11) NOT NULL,
  `credit` DECIMAL(10,2) NOT NULL DEFAULT '500.00',
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`users_id`),
  UNIQUE KEY `email_UNIQUE` (`email`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `olskercupcakedb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `olskercupcakedb`.`orders` (
  `orders_id` INT(11) NOT NULL AUTO_INCREMENT,
  `users_id` INT(11) NOT NULL,
  `order_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` VARCHAR(45) NOT NULL DEFAULT 'Bestilt',
  PRIMARY KEY (`orders_id`),
  INDEX `fk_users_orders_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_order`
    FOREIGN KEY (`users_id`)
    REFERENCES `olskercupcakedb`.`users` (`users_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `olskercupcakedb`.`topping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `olskercupcakedb`.`topping` (
  `topping_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`topping_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `olskercupcakedb`.`orderline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `olskercupcakedb`.`orderline` (
  `orderline_id` INT(11) NOT NULL AUTO_INCREMENT,
  `orders_id` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL DEFAULT '0',
  `sum` DECIMAL(10,2) NOT NULL DEFAULT '0.00',
  `topping_id` INT(11) NOT NULL,
  `bottom_id` INT(11) NOT NULL,
  PRIMARY KEY (`orderline_id`),
  INDEX `fk_orderline_orders_idx` (`orders_id` ASC) VISIBLE,
  INDEX `fk_orderline_topping_idx` (`topping_id` ASC) VISIBLE,
  INDEX `fk_orderline_bottom_idx` (`bottom_id` ASC) VISIBLE,
  CONSTRAINT `fk_orderline_bottom`
    FOREIGN KEY (`bottom_id`)
    REFERENCES `olskercupcakedb`.`bottom` (`bottom_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_orderline_orders`
    FOREIGN KEY (`orders_id`)
    REFERENCES `olskercupcakedb`.`orders` (`orders_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_orderline_topping`
    FOREIGN KEY (`topping_id`)
    REFERENCES `olskercupcakedb`.`topping` (`topping_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
