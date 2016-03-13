-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema kinderbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kinderbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kinderbd` DEFAULT CHARACTER SET utf8 ;
USE `kinderbd` ;

-- -----------------------------------------------------
-- Table `kinderbd`.`kinder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`kinder` (
  `nombre` VARCHAR(50) NOT NULL,
  `direccion` VARCHAR(50) NULL DEFAULT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `historia` VARCHAR(5000) NULL DEFAULT NULL,
  `mision` VARCHAR(5000) NULL DEFAULT NULL,
  `vision` VARCHAR(5000) NULL DEFAULT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`album` (
  `nombre` VARCHAR(200) NOT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  INDEX `idx_albun` (`kinder` ASC),
  CONSTRAINT `fk_album`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinderbd`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`profesor` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `apellido1` VARCHAR(50) NULL DEFAULT NULL,
  `apellido2` VARCHAR(50) NULL DEFAULT NULL,
  `salario` FLOAT NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `fechanacimiento` DATE NULL DEFAULT NULL,
  `id` VARCHAR(50) NOT NULL,
  `direccion` VARCHAR(50) NULL DEFAULT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `rol` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`clase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`clase` (
  `id` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `profesor` VARCHAR(50) NULL DEFAULT NULL,
  `nivel` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_clase` (`profesor` ASC),
  CONSTRAINT `fk_clase`
    FOREIGN KEY (`profesor`)
    REFERENCES `kinderbd`.`profesor` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`contacto` (
  `titulo` VARCHAR(1000) NULL DEFAULT NULL,
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(5000) NULL DEFAULT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_contacto` (`kinder` ASC),
  CONSTRAINT `fk_contacto`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinderbd`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`encargado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`encargado` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `id` VARCHAR(50) NOT NULL,
  `apellido1` VARCHAR(50) NULL DEFAULT NULL,
  `apellido2` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `direccion` VARCHAR(50) NULL DEFAULT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_nacimiento` VARCHAR(50) NULL DEFAULT NULL,
  `ruta_imagen` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`nino`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`nino` (
  `id` VARCHAR(50) NOT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  `grupo` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_nino` (`grupo` ASC),
  CONSTRAINT `fk_nino`
    FOREIGN KEY (`grupo`)
    REFERENCES `kinderbd`.`clase` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`enc_nino`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`enc_nino` (
  `enc_id` VARCHAR(50) NOT NULL,
  `nino_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`enc_id`, `nino_id`),
  INDEX `FK_NIN` (`nino_id` ASC),
  CONSTRAINT `FK_ENCA`
    FOREIGN KEY (`enc_id`)
    REFERENCES `kinderbd`.`encargado` (`id`),
  CONSTRAINT `FK_NIN`
    FOREIGN KEY (`nino_id`)
    REFERENCES `kinderbd`.`nino` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`enfermedad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`enfermedad` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `codigo` VARCHAR(50) NOT NULL,
  `id_nino` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_enfermedad` (`id_nino` ASC),
  CONSTRAINT `fk_enfermedad`
    FOREIGN KEY (`id_nino`)
    REFERENCES `kinderbd`.`nino` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`familiar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`familiar` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `id` VARCHAR(50) NOT NULL,
  `apellido1` VARCHAR(50) NULL DEFAULT NULL,
  `apellido2` VARCHAR(50) NULL DEFAULT NULL,
  `edad` VARCHAR(50) NULL DEFAULT NULL,
  `lugarTrabajo` VARCHAR(50) NULL DEFAULT NULL,
  `ocupacion` VARCHAR(50) NULL DEFAULT NULL,
  `idnino` VARCHAR(50) NULL DEFAULT NULL,
  `parentesco` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_familiar` (`idnino` ASC),
  CONSTRAINT `fk_familiar`
    FOREIGN KEY (`idnino`)
    REFERENCES `kinderbd`.`nino` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`fechapago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`fechapago` (
  `codigo` VARCHAR(50) NOT NULL,
  `fecha` INT(11) NULL DEFAULT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_fecha` (`kinder` ASC),
  CONSTRAINT `fk_fecha`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinderbd`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`imagen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`imagen` (
  `ruta_imagen` VARCHAR(1000) NULL DEFAULT NULL,
  `codigo` VARCHAR(50) NOT NULL,
  `album` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_imagen` (`album` ASC),
  CONSTRAINT `fk_imagen`
    FOREIGN KEY (`album`)
    REFERENCES `kinderbd`.`album` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`informacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`informacion` (
  `codigo` VARCHAR(50) NOT NULL,
  `idnino` VARCHAR(50) NULL DEFAULT NULL,
  `titulo` VARCHAR(1000) NULL DEFAULT NULL,
  `descripcion` VARCHAR(2000) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `FK_60d0smgecls09yaw706x48vcv` (`idnino` ASC),
  CONSTRAINT `FK_60d0smgecls09yaw706x48vcv`
    FOREIGN KEY (`idnino`)
    REFERENCES `kinderbd`.`nino` (`id`),
  CONSTRAINT `fk_informacion`
    FOREIGN KEY (`idnino`)
    REFERENCES `kinderbd`.`encargado` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`matricula` (
  `id` VARCHAR(50) NOT NULL,
  `carnetvac` BIT(1) NULL DEFAULT NULL,
  `completa` BIT(1) NULL DEFAULT NULL,
  `constanciaNac` BIT(1) NULL DEFAULT NULL,
  `cursolectivo` VARCHAR(50) NULL DEFAULT NULL,
  `fotos` BIT(1) NULL DEFAULT NULL,
  `matricula` LONGTEXT NULL DEFAULT NULL,
  `realizadoPor` VARCHAR(50) NULL DEFAULT NULL,
  `id_nino` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_9q477bu43te8kl28tvyu631jm` (`id_nino` ASC),
  CONSTRAINT `FK_9q477bu43te8kl28tvyu631jm`
    FOREIGN KEY (`id_nino`)
    REFERENCES `kinderbd`.`nino` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`noticia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`noticia` (
  `codigo` VARCHAR(50) NOT NULL,
  `descripcion` VARCHAR(1000) NULL DEFAULT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_noticia` (`kinder` ASC),
  CONSTRAINT `fk_noticia`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinderbd`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinderbd`.`telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`telefono` (
  `numero` VARCHAR(50) NOT NULL,
  `idFamiliar` VARCHAR(50) NOT NULL,
  `idnino` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_telefono` (`idFamiliar` ASC),
  INDEX `FK_mb5tovts24r42ee982s1tavbw` (`idnino` ASC),
  CONSTRAINT `FK_mb5tovts24r42ee982s1tavbw`
    FOREIGN KEY (`idnino`)
    REFERENCES `kinderbd`.`familiar` (`id`),
  CONSTRAINT `fk_telefono`
    FOREIGN KEY (`idFamiliar`)
    REFERENCES `kinderbd`.`familiar` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

----------------------------------------------------------------------------------------------------------------------------
-----------------------TABLA CHIQUILLOS----------------------------------------------

-- -----------------------------------------------------
-- Table `kinderbd`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`usuario` (
  `id` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `contrasena` VARCHAR(50) NOT NULL,
  `rol` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-------------------------------------DROPS DE LAS TABLAS-----------------------------------------------------------------------


/*
DROP TABLE IF EXISTS `kinderBD`.`noticia` ;
DROP TABLE IF EXISTS `kinderBD`.`contacto` ;
DROP TABLE IF EXISTS `kinderBD`.`fechaPago` ;
DROP TABLE IF EXISTS `kinderBD`.`imagen` ;
DROP TABLE IF EXISTS `KinderBD`.`album` ;
DROP TABLE IF EXISTS `KinderBD`.`kinder` ;
DROP TABLE IF EXISTS `kinderBD`.`matricula` ;
DROP TABLE IF EXISTS `kinderBD`.`enfermedad` ;
DROP TABLE IF EXISTS `kinderBD`.`telefono` ;
DROP TABLE IF EXISTS `kinderBD`.`asignacion` ;
DROP TABLE IF EXISTS `kinderBD`.`enc_nino` ;
DROP TABLE IF EXISTS `kinderBD`.`usu_enc` ;
DROP TABLE IF EXISTS `kinderBD`.`informacion` ;
DROP TABLE IF EXISTS `kinderBD`.`familiar` ;
DROP TABLE IF EXISTS `kinderBD`.`nino` ;
DROP TABLE IF EXISTS `kinderBD`.`encargado` ;
DROP TABLE IF EXISTS `kinderBD`.`clase` ;
DROP TABLE IF EXISTS `kinderBD`.`profesor` ;
DROP TABLE IF EXISTS `kinderBD`.`usuario` ;


----------------------------------------------------------------------------------------------------------------------------
-----------------------TABLA CHIQUILLOS----------------------------------------------

*/

-- -----------------------------------------------------
-- Table `kinderbd`.`usu_enc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinderbd`.`usu_enc` (
  `user_id` VARCHAR(50) NOT NULL,
  `enc_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`user_id`, `enc_id`),
  INDEX `FK_ENC` (`enc_id` ASC),
  CONSTRAINT `FK_ENC`
    FOREIGN KEY (`enc_id`)
    REFERENCES `kinderbd`.`encargado` (`id`),
  CONSTRAINT `FK_USER`
    FOREIGN KEY (`user_id`)
    REFERENCES `kinderbd`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
