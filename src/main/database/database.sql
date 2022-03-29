-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

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
-- Table `eatit`.`restaurant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`restaurant` (
    `restaurantid` INT(11) NOT NULL AUTO_INCREMENT,
    `restaurant_name` VARCHAR(100) NOT NULL,
    `restaurant_place` VARCHAR(200) NOT NULL,
    `restaurant_logo_url` VARCHAR(200) NULL DEFAULT NULL,
    `restaurant_main_photo_url` VARCHAR(200) NULL DEFAULT NULL,
    PRIMARY KEY (`restaurantid`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`dish` (
    `dishid` INT(11) NOT NULL AUTO_INCREMENT,
    `restaurantid` INT(11) NOT NULL,
    `dish_name` VARCHAR(200) NOT NULL,
    `dish_description` VARCHAR(1000) NOT NULL,
    `dish_photo_url` VARCHAR(200) NULL DEFAULT NULL,
    PRIMARY KEY (`dishid`),
    INDEX `dish_restaurant_id_fk_idx` (`restaurantid` ASC),
    CONSTRAINT `dish_restaurant_id_fk`
    FOREIGN KEY (`restaurantid`)
    REFERENCES `eatit`.`restaurant` (`restaurantid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`additives`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`additives` (
    `additivesid` INT(11) NOT NULL AUTO_INCREMENT,
    `dishid` INT(11) NOT NULL,
    `additives_name` VARCHAR(200) NOT NULL,
    `additives_price` FLOAT NOT NULL,
    PRIMARY KEY (`additivesid`),
    INDEX `additives_dish_id_fk_idx` (`dishid` ASC),
    CONSTRAINT `additives_dish_id_fk`
    FOREIGN KEY (`dishid`)
    REFERENCES `eatit`.`dish` (`dishid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`restaurant_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`restaurant_role` (
    `restaurantroleid` INT(11) NOT NULL AUTO_INCREMENT,
    `restaurantid` INT(11) NOT NULL,
    `restaurant_role_name` VARCHAR(150) NOT NULL,
    `person_can_edit_or_add_dish` TINYINT(4) NOT NULL,
    `person_can_edit_employees_in_restaurant` TINYINT(4) NOT NULL,
    `person_can_change_information_about_restaurant` TINYINT(4) NOT NULL,
    PRIMARY KEY (`restaurantroleid`),
    INDEX `restaurant_role_restaurant_id_fk_idx` (`restaurantid` ASC),
    CONSTRAINT `restaurant_role_restaurant_id_fk`
    FOREIGN KEY (`restaurantid`)
    REFERENCES `eatit`.`restaurant` (`restaurantid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`user` (
    `userid` INT(11) NOT NULL AUTO_INCREMENT,
    `restaurantid` INT(11) NULL DEFAULT NULL,
    `restaurantroleid` INT(11) NULL DEFAULT NULL,
    `user_email` VARCHAR(100) NOT NULL,
    `user_password` VARCHAR(100) NOT NULL,
    `user_name` VARCHAR(100) NOT NULL,
    `user_surname` VARCHAR(100) NOT NULL,
    `user_role` VARCHAR(50) NOT NULL,
    `user_birth_date` DATE NOT NULL DEFAULT '1990-01-01',
    PRIMARY KEY (`userid`),
    UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC),
    INDEX `user_restaurant_id_fk_idx` (`restaurantid` ASC),
    INDEX `user_restaurant_role_id_fk_idx` (`restaurantroleid` ASC),
    CONSTRAINT `user_restaurant_id_fk`
    FOREIGN KEY (`restaurantid`)
    REFERENCES `eatit`.`restaurant` (`restaurantid`)
    ON DELETE CASCADE,
    CONSTRAINT `user_restaurant_role_id_fk`
    FOREIGN KEY (`restaurantroleid`)
    REFERENCES `eatit`.`restaurant_role` (`restaurantroleid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 8
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`admin` (
    `adminid` INT(11) NOT NULL AUTO_INCREMENT,
    `userid` INT(11) NOT NULL,
    PRIMARY KEY (`adminid`),
    UNIQUE INDEX `userid_UNIQUE` (`userid` ASC),
    CONSTRAINT `admin_user_id_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`purchaser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`purchaser` (
    `purchaserid` INT(11) NOT NULL AUTO_INCREMENT,
    `userid` INT(11) NOT NULL,
    PRIMARY KEY (`purchaserid`),
    UNIQUE INDEX `userid_UNIQUE` (`userid` ASC),
    CONSTRAINT `purchaser_user_id_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`bracket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`bracket` (
    `bracketid` INT(11) NOT NULL AUTO_INCREMENT,
    `purchaserid` INT(11) NOT NULL,
    PRIMARY KEY (`bracketid`),
    INDEX `bracket_purchaser_id_fk_idx` (`purchaserid` ASC),
    CONSTRAINT `bracket_purchaser_id_fk`
    FOREIGN KEY (`purchaserid`)
    REFERENCES `eatit`.`purchaser` (`purchaserid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`delivery_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`delivery_person` (
    `deliverypersonid` INT(11) NOT NULL AUTO_INCREMENT,
    `userid` INT(11) NOT NULL,
    PRIMARY KEY (`deliverypersonid`),
    UNIQUE INDEX `userid_UNIQUE` (`userid` ASC),
    CONSTRAINT `delivery_person_user_id_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`dish_options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`dish_options` (
    `dishoptionid` INT(11) NOT NULL AUTO_INCREMENT,
    `dishid` INT(11) NOT NULL,
    `dish_option_description` VARCHAR(300) NOT NULL,
    `dish_option_price` FLOAT NOT NULL,
    PRIMARY KEY (`dishoptionid`),
    INDEX `dish_option_dish_id_fk_idx` (`dishid` ASC),
    CONSTRAINT `dish_option_dish_id_fk`
    FOREIGN KEY (`dishid`)
    REFERENCES `eatit`.`dish` (`dishid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`employees_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`employees_role` (
    `employeesuserid` INT(11) NOT NULL,
    `restaurantid` INT(11) NOT NULL,
    `employeesrestaurantroleid` INT(11) NOT NULL,
    INDEX `employees_user_id_fk_idx` (`employeesuserid` ASC),
    INDEX `restaurant_id_fk_idx` (`restaurantid` ASC),
    INDEX `restaurant_role_id_fk_idx` (`employeesrestaurantroleid` ASC),
    CONSTRAINT `employees_user_id_fk`
    FOREIGN KEY (`employeesuserid`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE,
    CONSTRAINT `restaurant_id_fk`
    FOREIGN KEY (`restaurantid`)
    REFERENCES `eatit`.`restaurant` (`restaurantid`)
    ON DELETE CASCADE,
    CONSTRAINT `restaurant_role_id_fk`
    FOREIGN KEY (`employeesrestaurantroleid`)
    REFERENCES `eatit`.`restaurant_role` (`restaurantroleid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`final_dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`final_dish` (
    `finaldishid` INT(11) NOT NULL AUTO_INCREMENT,
    `dishid` INT(11) NOT NULL,
    `dishoptionid` INT(11) NOT NULL,
    PRIMARY KEY (`finaldishid`),
    INDEX `final_dish_dish_id_fk_idx` (`dishid` ASC),
    INDEX `final_dish_dish_option_id_fk_idx` (`dishoptionid` ASC),
    CONSTRAINT `final_dish_dish_id_fk`
    FOREIGN KEY (`dishid`)
    REFERENCES `eatit`.`dish` (`dishid`)
    ON DELETE CASCADE,
    CONSTRAINT `final_dish_dish_option_id_fk`
    FOREIGN KEY (`dishoptionid`)
    REFERENCES `eatit`.`dish_options` (`dishoptionid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`list_of_additives`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`list_of_additives` (
    `additivesid` INT(11) NOT NULL,
    `finaldishid` INT(11) NOT NULL,
    INDEX `list_of_additives_additives_id_fk_idx` (`additivesid` ASC),
    INDEX `list_of_additives_final_dish_id_fk_idx` (`finaldishid` ASC),
    CONSTRAINT `list_of_additives_additives_id_fk`
    FOREIGN KEY (`additivesid`)
    REFERENCES `eatit`.`additives` (`additivesid`)
    ON DELETE CASCADE,
    CONSTRAINT `list_of_additives_final_dish_id_fk`
    FOREIGN KEY (`finaldishid`)
    REFERENCES `eatit`.`final_dish` (`finaldishid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`list_of_final_dishes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`list_of_final_dishes` (
    `finaldishid` INT(11) NOT NULL,
    `bracketid` INT(11) NOT NULL,
    INDEX `list_of_final_dishes_final_dish_id_fk_idx` (`finaldishid` ASC),
    INDEX `list_of_final_dishes_bracket_id_fk_idx` (`bracketid` ASC),
    CONSTRAINT `list_of_final_dishes_bracket_id_fk`
    FOREIGN KEY (`bracketid`)
    REFERENCES `eatit`.`bracket` (`bracketid`)
    ON DELETE CASCADE,
    CONSTRAINT `list_of_final_dishes_final_dish_id_fk`
    FOREIGN KEY (`finaldishid`)
    REFERENCES `eatit`.`final_dish` (`finaldishid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`restaurant_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`restaurant_type` (
    `restaruanttypeid` INT(11) NOT NULL AUTO_INCREMENT,
    `restaurant_type_name` VARCHAR(130) NOT NULL,
    PRIMARY KEY (`restaruanttypeid`),
    UNIQUE INDEX `restaurant_type_name_UNIQUE` (`restaurant_type_name` ASC))
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`list_of_restaurant_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`list_of_restaurant_types` (
    `restaurantid` INT(11) NOT NULL,
    `restauranttypeid` INT(11) NOT NULL,
    INDEX `list_of_restaurant_types_restaurant_id_fk_idx` (`restaurantid` ASC),
    INDEX `list_of_restaurant_types_restaurant_type_id_fk_idx` (`restauranttypeid` ASC),
    CONSTRAINT `list_of_restaurant_types_restaurant_id_fk`
    FOREIGN KEY (`restaurantid`)
    REFERENCES `eatit`.`restaurant` (`restaurantid`)
    ON DELETE CASCADE,
    CONSTRAINT `list_of_restaurant_types_restaurant_type_id_fk`
    FOREIGN KEY (`restauranttypeid`)
    REFERENCES `eatit`.`restaurant_type` (`restaruanttypeid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`messages` (
    `messageid` INT(11) NOT NULL AUTO_INCREMENT,
    `senderuserid` INT(11) NOT NULL,
    `recipientuserid` INT(11) NOT NULL,
    `message_text_value` VARCHAR(2000) NOT NULL,
    `message_date_time` DATETIME NOT NULL,
    `message_has_been_read` TINYINT(4) NOT NULL,
    PRIMARY KEY (`messageid`),
    INDEX `messages_sender_user_id_fk_idx` (`senderuserid` ASC),
    INDEX `messages_recipient_user_id_fk_idx` (`recipientuserid` ASC),
    CONSTRAINT `messages_recipient_user_id_fk`
    FOREIGN KEY (`recipientuserid`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE,
    CONSTRAINT `messages_sender_user_id_fk`
    FOREIGN KEY (`senderuserid`)
    REFERENCES `eatit`.`user` (`userid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eatit`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eatit`.`order` (
    `orderid` INT(11) NOT NULL AUTO_INCREMENT,
    `purchaserid` INT(11) NOT NULL,
    `bracketid` INT(11) NOT NULL,
    `deliverypersonid` INT(11) NOT NULL,
    `order_place_of_delivery` VARCHAR(200) NOT NULL,
    `order_date` DATE NOT NULL,
    PRIMARY KEY (`orderid`),
    UNIQUE INDEX `bracketid_UNIQUE` (`bracketid` ASC),
    INDEX `order_purchaser_id_fk_idx` (`purchaserid` ASC),
    INDEX `order_delivery_person_id_fk_idx` (`deliverypersonid` ASC),
    CONSTRAINT `order_bracket_id_fk`
    FOREIGN KEY (`bracketid`)
    REFERENCES `eatit`.`bracket` (`bracketid`)
    ON DELETE CASCADE,
    CONSTRAINT `order_delivery_person_id_fk`
    FOREIGN KEY (`deliverypersonid`)
    REFERENCES `eatit`.`delivery_person` (`deliverypersonid`)
    ON DELETE CASCADE,
    CONSTRAINT `order_purchaser_id_fk`
    FOREIGN KEY (`purchaserid`)
    REFERENCES `eatit`.`purchaser` (`purchaserid`)
    ON DELETE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
