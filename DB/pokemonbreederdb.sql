-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pokemonbreederdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pokemonbreederdb` ;

-- -----------------------------------------------------
-- Schema pokemonbreederdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokemonbreederdb` DEFAULT CHARACTER SET utf8 ;
USE `pokemonbreederdb` ;

-- -----------------------------------------------------
-- Table `pokemon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon` ;

CREATE TABLE IF NOT EXISTS `pokemon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `nature` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS pokemonbreeder@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'pokemonbreeder'@'localhost' IDENTIFIED BY 'ppokemonbreeder';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'pokemonbreeder'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `pokemon`
-- -----------------------------------------------------
START TRANSACTION;
USE `pokemonbreederdb`;
INSERT INTO `pokemon` (`id`, `name`, `nature`) VALUES (1, 'Charmander', 'Modest');
INSERT INTO `pokemon` (`id`, `name`, `nature`) VALUES (2, 'Gyarados', 'Adamant');

COMMIT;

