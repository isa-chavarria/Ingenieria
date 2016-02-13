-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema kinder
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kinder
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kinder` DEFAULT CHARACTER SET utf8 ;
USE `kinder` ;

-- -----------------------------------------------------
-- Table `kinder`.`kinder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`kinder` ;

CREATE TABLE IF NOT EXISTS `kinder`.`kinder` (
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
-- Table `kinder`.`album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`album` ;

CREATE TABLE IF NOT EXISTS `kinder`.`album` (
  `nombre` VARCHAR(200) NOT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  INDEX `idx_albun` (`kinder` ASC),
  CONSTRAINT `fk_albun`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinder`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`planilla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`planilla` ;

CREATE TABLE IF NOT EXISTS `kinder`.`planilla` (
  `id` VARCHAR(50) NOT NULL,
  `fecha` DATE NOT NULL,
  `montopago` FLOAT NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `fecha`),
  UNIQUE INDEX `pk_planilla` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`profesor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`profesor` ;

CREATE TABLE IF NOT EXISTS `kinder`.`profesor` (
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
  `rutaimagen` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_profesor`
    FOREIGN KEY (`id`)
    REFERENCES `kinder`.`planilla` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`clase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`clase` ;

CREATE TABLE IF NOT EXISTS `kinder`.`clase` (
  `id` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `profesor` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_clase` (`profesor` ASC),
  CONSTRAINT `fk_clase`
    FOREIGN KEY (`profesor`)
    REFERENCES `kinder`.`profesor` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`contacto` ;

CREATE TABLE IF NOT EXISTS `kinder`.`contacto` (
  `titulo` VARCHAR(50) NULL DEFAULT NULL,
  `codigo` VARCHAR(50) NOT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_contacto` (`kinder` ASC),
  CONSTRAINT `fk_contacto`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinder`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`encargado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`encargado` ;

CREATE TABLE IF NOT EXISTS `kinder`.`encargado` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `id` VARCHAR(50) NOT NULL,
  `apellido1` VARCHAR(50) NULL DEFAULT NULL,
  `apellido2` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `direccion` VARCHAR(50) NULL DEFAULT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_nacimiento` VARCHAR(50) NULL DEFAULT NULL,
  `rol` VARCHAR(50) NULL DEFAULT NULL,
  `ruta_imagen` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`nino`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`nino` ;

CREATE TABLE IF NOT EXISTS `kinder`.`nino` (
  `id` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `apellido1` VARCHAR(50) NULL DEFAULT NULL,
  `apellido2` VARCHAR(50) NULL DEFAULT NULL,
  `fechanacimiento` DATE NULL DEFAULT NULL,
  `direccion` VARCHAR(50) NULL DEFAULT NULL,
  `clase` VARCHAR(50) NULL DEFAULT NULL,
  `ruta_imagen` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_nino` (`clase` ASC),
  CONSTRAINT `fk_nino`
    FOREIGN KEY (`clase`)
    REFERENCES `kinder`.`clase` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`encargado-nino`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`encargado-nino` ;

CREATE TABLE IF NOT EXISTS `kinder`.`encargado-nino` (
  `monto_pago` FLOAT NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL DEFAULT NULL,
  `morosida` TINYINT(1) NULL DEFAULT NULL,
  `fecha_pago` DATE NULL DEFAULT NULL,
  `id_nino` VARCHAR(50) NOT NULL,
  `id_encargado` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_nino`, `id_encargado`),
  INDEX `fk_encargado-nino` (`id_encargado` ASC),
  CONSTRAINT `fk_encargado-nino`
    FOREIGN KEY (`id_encargado`)
    REFERENCES `kinder`.`encargado` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_encargado-nino_0`
    FOREIGN KEY (`id_nino`)
    REFERENCES `kinder`.`nino` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`enfermedad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`enfermedad` ;

CREATE TABLE IF NOT EXISTS `kinder`.`enfermedad` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `codigo` VARCHAR(50) NOT NULL,
  `id_nino` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_enfermedad` (`id_nino` ASC),
  CONSTRAINT `fk_enfermedad`
    FOREIGN KEY (`id_nino`)
    REFERENCES `kinder`.`nino` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`factura` ;

CREATE TABLE IF NOT EXISTS `kinder`.`factura` (
  `fecha_actual` DATE NULL DEFAULT NULL,
  `monto_final` FLOAT NULL DEFAULT NULL,
  `codigo` VARCHAR(50) NOT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  `encargado` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_factura` (`kinder` ASC),
  INDEX `idx_factura_0` (`encargado` ASC),
  CONSTRAINT `fk_factura`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinder`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_0`
    FOREIGN KEY (`encargado`)
    REFERENCES `kinder`.`encargado` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`imagen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`imagen` ;

CREATE TABLE IF NOT EXISTS `kinder`.`imagen` (
  `ruta_imagen` VARCHAR(1000) NULL DEFAULT NULL,
  `codigo` VARCHAR(50) NOT NULL,
  `album` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_imagen` (`album` ASC),
  CONSTRAINT `fk_imagen`
    FOREIGN KEY (`album`)
    REFERENCES `kinder`.`album` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`linea_pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`linea_pago` ;

CREATE TABLE IF NOT EXISTS `kinder`.`linea_pago` (
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `monto` FLOAT NULL DEFAULT NULL,
  `id` VARCHAR(50) NOT NULL,
  `factura` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_linea_pago` (`factura` ASC),
  CONSTRAINT `fk_linea_pago`
    FOREIGN KEY (`factura`)
    REFERENCES `kinder`.`factura` (`codigo`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kinder`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinder`.`usuario` ;

CREATE TABLE IF NOT EXISTS `kinder`.`usuario` (
  `id` VARCHAR(50) NOT NULL,
  `contrasena` VARCHAR(50) NULL DEFAULT NULL,
  `role_seccion` VARCHAR(50) NULL DEFAULT NULL,
  `encargado` VARCHAR(50) NULL DEFAULT NULL,
  `profesor` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_usuario` (`profesor` ASC),
  INDEX `idx_usuario_0` (`encargado` ASC),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`profesor`)
    REFERENCES `kinder`.`profesor` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_0`
    FOREIGN KEY (`encargado`)
    REFERENCES `kinder`.`encargado` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
