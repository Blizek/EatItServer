-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema eatit
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eatit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eatit` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `eatit` ;

-- -----------------------------------------------------
-- Table `eatit`.`restaurant_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`restaurant_type` (
  `restaurantTypeID` INT NOT NULL,
  `restaurantTypeName` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`restaurantTypeID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`user` (
  `userid` INT NOT NULL,
  `user_email` VARCHAR(100) NOT NULL,
  `user_password` VARCHAR(100) NOT NULL,
  `user_name` VARCHAR(100) NOT NULL,
  `user_surname` VARCHAR(100) NOT NULL,
  `user_role` VARCHAR(100) NOT NULL,
  `user_birth_day` DATE NOT NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`restaurant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`restaurant` (
  `restaurantID` INT NOT NULL,
  `restaurantTypeID` INT NOT NULL,
  `ownerUserID` INT NOT NULL,
  `restaurantName` VARCHAR(100) NOT NULL,
  `restaurantPlace` VARCHAR(100) NOT NULL,
  `restaurantLogoURL` VARCHAR(200) NULL DEFAULT NULL,
  `RestaurntMainPhotoURL` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`restaurantID`),
  INDEX `restaurant_retaurant_type_id_fk_idx` (`restaurantTypeID` ASC) VISIBLE,
  INDEX `restaurant_user_id_fk_idx` (`ownerUserID` ASC) VISIBLE,
  CONSTRAINT `restaurant_retaurant_type_id_fk`
    FOREIGN KEY (`restaurantTypeID`)
    REFERENCES `eatit`.`restaurant_type` (`restaurantTypeID`)
    ON DELETE CASCADE,
  CONSTRAINT `restaurant_user_id_fk`
    FOREIGN KEY (`ownerUserID`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`dish` (
  `dishID` INT NOT NULL,
  `restaurantID` INT NOT NULL,
  `dishName` VARCHAR(200) NOT NULL,
  `dishDescription` VARCHAR(1000) NOT NULL,
  `dishPhotoURL` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`dishID`),
  INDEX `dish_retaurant_id_fk_idx` (`restaurantID` ASC) VISIBLE,
  CONSTRAINT `dish_retaurant_id_fk`
    FOREIGN KEY (`restaurantID`)
    REFERENCES `eatit`.`restaurant` (`restaurantID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`additives`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`additives` (
  `additivesid` INT NOT NULL,
  `dishid` INT NOT NULL,
  `additives_name` VARCHAR(200) NOT NULL,
  `additives_price` FLOAT NOT NULL,
  PRIMARY KEY (`additivesid`),
  INDEX `additives_dish_id_fk_idx` (`dishid` ASC) VISIBLE,
  CONSTRAINT `additives_dish_id_fk`
    FOREIGN KEY (`dishid`)
    REFERENCES `eatit`.`dish` (`dishID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`purchaser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`purchaser` (
  `purchaserID` INT NOT NULL,
  `userID` INT NOT NULL,
  PRIMARY KEY (`purchaserID`),
  INDEX `purchaser_user_id_fk_idx` (`userID` ASC) VISIBLE,
  CONSTRAINT `purchaser_user_id_fk`
    FOREIGN KEY (`userID`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`basket` (
  `basketid` INT NOT NULL,
  `purchaserid` INT NOT NULL,
  PRIMARY KEY (`basketid`),
  INDEX `bracket_purchaser_id_fk_idx` (`purchaserid` ASC) VISIBLE,
  CONSTRAINT `basket_purchaser_id_fk`
    FOREIGN KEY (`purchaserid`)
    REFERENCES `eatit`.`purchaser` (`purchaserID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`delivery_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`delivery_person` (
  `deliveryPersonID` INT NOT NULL,
  `userID` INT NOT NULL,
  PRIMARY KEY (`deliveryPersonID`),
  INDEX `deliveryPerson_user_id_fk_idx` (`userID` ASC) VISIBLE,
  CONSTRAINT `deliveryPerson_user_id_fk`
    FOREIGN KEY (`userID`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`dish_options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`dish_options` (
  `dishOptionID` INT NOT NULL,
  `dishID` INT NOT NULL,
  `dishOptionDescription` VARCHAR(300) NOT NULL,
  `dishOptionPrice` FLOAT NOT NULL,
  PRIMARY KEY (`dishOptionID`),
  INDEX `dish_option_dish_id_fk_idx` (`dishID` ASC) VISIBLE,
  CONSTRAINT `dish_option_dish_id_fk`
    FOREIGN KEY (`dishID`)
    REFERENCES `eatit`.`dish` (`dishID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`final_dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`final_dish` (
  `finalDishID` INT NOT NULL,
  `dishID` INT NOT NULL,
  `dishOptionID` INT NOT NULL,
  PRIMARY KEY (`finalDishID`),
  INDEX `final_dish_dish_id_fk_idx` (`dishID` ASC) VISIBLE,
  INDEX `final_dish_dish_option_id_fk_idx` (`dishOptionID` ASC) VISIBLE,
  CONSTRAINT `final_dish_dish_id_fk`
    FOREIGN KEY (`dishID`)
    REFERENCES `eatit`.`dish` (`dishID`)
    ON DELETE CASCADE,
  CONSTRAINT `final_dish_dish_option_id_fk`
    FOREIGN KEY (`dishOptionID`)
    REFERENCES `eatit`.`dish_options` (`dishOptionID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`list_of_additives`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`list_of_additives` (
  `additivesID` INT NOT NULL,
  `finalDishID` INT NOT NULL,
  INDEX `list_of_additives_additives_id_fk_idx` (`additivesID` ASC) VISIBLE,
  INDEX `list_of_additives_final_dish_id_idx` (`finalDishID` ASC) VISIBLE,
  CONSTRAINT `list_of_additives_additives_id_fk`
    FOREIGN KEY (`additivesID`)
    REFERENCES `eatit`.`additives` (`additivesid`)
    ON DELETE CASCADE,
  CONSTRAINT `list_of_additives_final_dish_id`
    FOREIGN KEY (`finalDishID`)
    REFERENCES `eatit`.`final_dish` (`finalDishID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`list_of_final_dishes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`list_of_final_dishes` (
  `finalDishID` INT NOT NULL,
  `basketID` INT NOT NULL,
  INDEX `list_of_final_dishes_final_dish_id_fk_idx` (`finalDishID` ASC) VISIBLE,
  INDEX `list_of_final_dishes_basket_id_fk_idx` (`basketID` ASC) VISIBLE,
  CONSTRAINT `list_of_final_dishes_basket_id_fk`
    FOREIGN KEY (`basketID`)
    REFERENCES `eatit`.`basket` (`basketid`)
    ON DELETE CASCADE,
  CONSTRAINT `list_of_final_dishes_final_dish_id_fk`
    FOREIGN KEY (`finalDishID`)
    REFERENCES `eatit`.`final_dish` (`finalDishID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`messages` (
  `messageID` INT NOT NULL,
  `senderUserID` INT NOT NULL,
  `recipientUserID` INT NOT NULL,
  `messageTextValue` VARCHAR(2000) NOT NULL,
  `messageTimeOfSending` DATETIME NOT NULL,
  `messagesHasBeenRead` TINYINT NOT NULL,
  PRIMARY KEY (`messageID`),
  INDEX `message_sender_user_id_fk_idx` (`senderUserID` ASC) VISIBLE,
  INDEX `messages_recipient_user_id_fk_idx` (`recipientUserID` ASC) VISIBLE,
  CONSTRAINT `messages_recipient_user_id_fk`
    FOREIGN KEY (`recipientUserID`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE,
  CONSTRAINT `messages_sender_user_id_fk`
    FOREIGN KEY (`senderUserID`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`order` (
  `orderID` INT NOT NULL,
  `purchaserID` INT NOT NULL,
  `basketID` INT NOT NULL,
  `deliveryPersonID` INT NOT NULL,
  `orderPaceOfDelivery` VARCHAR(200) NOT NULL,
  `orderDate` DATETIME NOT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `order_purchaser_id_fk_idx` (`purchaserID` ASC) VISIBLE,
  INDEX `order_basket_id_fk_idx` (`basketID` ASC) VISIBLE,
  INDEX `order_delivery_person_id_fk_idx` (`deliveryPersonID` ASC) VISIBLE,
  CONSTRAINT `order_basket_id_fk`
    FOREIGN KEY (`basketID`)
    REFERENCES `eatit`.`basket` (`basketid`)
    ON DELETE CASCADE,
  CONSTRAINT `order_delivery_person_id_fk`
    FOREIGN KEY (`deliveryPersonID`)
    REFERENCES `eatit`.`delivery_person` (`deliveryPersonID`)
    ON DELETE CASCADE,
  CONSTRAINT `order_purchaser_id_fk`
    FOREIGN KEY (`purchaserID`)
    REFERENCES `eatit`.`purchaser` (`purchaserID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`restaurant_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`restaurant_user` (
  `employeeUserID` INT NOT NULL,
  `restaurantID` INT NOT NULL,
  INDEX `restaurant_user_user_id_fk_idx` (`employeeUserID` ASC) VISIBLE,
  INDEX `restaurant_user_restaurant_id_fk_idx` (`restaurantID` ASC) VISIBLE,
  CONSTRAINT `restaurant_user_restaurant_id_fk`
    FOREIGN KEY (`restaurantID`)
    REFERENCES `eatit`.`restaurant` (`restaurantID`)
    ON DELETE CASCADE,
  CONSTRAINT `restaurant_user_user_id_fk`
    FOREIGN KEY (`employeeUserID`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
