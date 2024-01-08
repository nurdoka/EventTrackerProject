-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema appointmentdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `appointmentdb` ;

-- -----------------------------------------------------
-- Schema appointmentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `appointmentdb` DEFAULT CHARACTER SET utf8 ;
USE `appointmentdb` ;

-- -----------------------------------------------------
-- Table `appointment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `appointment` ;

CREATE TABLE IF NOT EXISTS `appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_name` VARCHAR(45) NOT NULL,
  `doctor_name` VARCHAR(45) NOT NULL,
  `arrival_time` DATETIME NULL,
  `departure_time` DATETIME NULL,
  `diagnose` VARCHAR(45) NULL,
  `prescription` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS appointment@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'appointment'@'localhost' IDENTIFIED BY '123';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'appointment'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
