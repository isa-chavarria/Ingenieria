
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `KinderBD` DEFAULT CHARACTER SET utf8 ;
USE `KinderBD` ;


-- -----------------------------------------------------
-- KINDER
-- -----------------------------------------------------
DROP TABLE IF EXISTS `KinderBD`.`kinder` ;

CREATE TABLE IF NOT EXISTS `KinderBD`.`kinder` (
  `nombre` VARCHAR(50) NOT NULL,
  `direccion` VARCHAR(1000) NULL DEFAULT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `historia` VARCHAR(5000) NULL DEFAULT NULL,
  `mision` VARCHAR(5000) NULL DEFAULT NULL,
  `vision` VARCHAR(5000) NULL DEFAULT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- ALBUM
-- -----------------------------------------------------
DROP TABLE IF EXISTS `KinderBD`.`album` ;

CREATE TABLE IF NOT EXISTS `KinderBD`.`album` (
  `nombre` VARCHAR(200) NOT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  INDEX `idx_albun` (`kinder` ASC),
  CONSTRAINT `fk_album`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinderBD`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- IMAGEN
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`imagen` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`imagen` (
  `ruta_imagen` VARCHAR(1000) NULL DEFAULT NULL,
  `codigo` VARCHAR(50) NOT NULL,
  `album` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_imagen` (`album` ASC),
  CONSTRAINT `fk_imagen`
    FOREIGN KEY (`album`)
    REFERENCES `kinderBD`.`album` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- CONTACTO
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`contacto` ;
CREATE TABLE IF NOT EXISTS `kinderBD`.`contacto` (
  `titulo` VARCHAR(1000) NULL DEFAULT NULL,
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(5000) NULL DEFAULT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_contacto` (`kinder` ASC),
  CONSTRAINT `fk_contacto`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinderBD`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- FECHA PAGO
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`InformacionKinder` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`InformacionKinder` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `fecha` VARCHAR(50)NULL DEFAULT NULL,
  `monto` VARCHAR(50)NULL DEFAULT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_fecha`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinderBD`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- USUARIO
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`usuario` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`usuario` (
`id` VARCHAR(50) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`contrasena` VARCHAR(50) NOT NULL,
`rol` VARCHAR(50) NULL DEFAULT NULL,
PRIMARY KEY (`id`, `email`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- ENCARGADO
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`encargado` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`encargado` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `id` VARCHAR(50) NOT NULL,
  `apellido1` VARCHAR(50) NULL DEFAULT NULL,
  `apellido2` VARCHAR(50) NULL DEFAULT NULL,
  `sexo` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(1000) NULL DEFAULT NULL,
  `direccion` VARCHAR(1000) NULL DEFAULT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_nacimiento` VARCHAR(50) NULL DEFAULT NULL,
  `ruta_imagen` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- USUARIO-ENCARGADO
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`usu_enc` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`usu_enc` (
  `user_id` VARCHAR(50) NOT NULL,
  `enc_id` VARCHAR(50)NOT NULL,
   PRIMARY KEY (`user_id`,`enc_id`),
   CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) REFERENCES `kinderBD`.`usuario` (`id`)ON DELETE CASCADE
    ON UPDATE NO ACTION,
   CONSTRAINT `FK_ENC` FOREIGN KEY (`enc_id`) REFERENCES `kinderBD`.`encargado` (`id`)ON DELETE CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- PROFESOR
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`profesor` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`profesor` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `apellido1` VARCHAR(50) NULL DEFAULT NULL,
  `apellido2` VARCHAR(50) NULL DEFAULT NULL,
  `salario` FLOAT NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `fechanacimiento` DATE NULL DEFAULT NULL,
  `id` VARCHAR(50) NOT NULL,
  `direccion` VARCHAR(1000) NULL DEFAULT NULL,
  `telefono` VARCHAR(50) NULL DEFAULT NULL,
  `rol` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------

-- GRUPO
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`clase` ;
CREATE TABLE IF NOT EXISTS `kinderBD`.`clase` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profesor` VARCHAR(50) NULL DEFAULT NULL,
  `nivel` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_clase` (`profesor` ASC),
  CONSTRAINT `fk_clase`
    FOREIGN KEY (`profesor`)
    REFERENCES `kinderBD`.`profesor` (`id`)
 )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- NINO
-- -------------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`nino` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`nino` (
   `id` VARCHAR(50) NOT NULL,
   `estado` TINYINT(1) NULL DEFAULT NULL,
   `grupo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_nino`
    FOREIGN KEY (`grupo`)
    REFERENCES `kinderBD`.`clase` (`id`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- ENCARGADO-NINO
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`enc_nino` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`enc_nino` (
  `enc_id` VARCHAR(50) NOT NULL,
  `nino_id` VARCHAR(50) NOT NULL,
   PRIMARY KEY (`enc_id`,`nino_id`),
   CONSTRAINT `FK_ENCA` FOREIGN KEY (`enc_id`) REFERENCES `kinderBD`.`encargado` (`id`)ON DELETE CASCADE
    ON UPDATE NO ACTION,
   CONSTRAINT `FK_NIN` FOREIGN KEY (`nino_id`) REFERENCES `kinderBD`.`nino` (`id`) ON DELETE CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- INFORMACION
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`informacion` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`informacion` (
   `codigo` INT NOT NULL AUTO_INCREMENT,
   `idnino` VARCHAR(50) NULL DEFAULT NULL,
   `titulo` varchar(1000) NULL DEFAULT NULL,
   `descripcion` varchar(2000) NULL DEFAULT NULL,
    PRIMARY KEY (`codigo`),
    CONSTRAINT `fk_informacion`
    FOREIGN KEY (`idnino`)
    REFERENCES `kinderBD`.`encargado` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `kinderbd`.`imagen` (
  `ruta_imagen` VARCHAR(1000) NULL DEFAULT NULL,
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `album` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_imagen` (`album` ASC),
  CONSTRAINT `fk_imagen`
    FOREIGN KEY (`album`)
    REFERENCES `kinderbd`.`album` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- FAMILIAR
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`familiar` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`familiar` (
`codigo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `id` VARCHAR(50)  NULL DEFAULT NULL,
  `edad` VARCHAR(50) NULL DEFAULT NULL,
  `lugarTrabajo` VARCHAR(1000) NULL DEFAULT NULL,
  `ocupacion` VARCHAR(100) NULL DEFAULT NULL,
  `idnino` VARCHAR(50) NULL DEFAULT NULL,
  `parentesco` VARCHAR(100) NULL DEFAULT NULL,
  `numeroTrabajo` VARCHAR(50) NULL DEFAULT NULL,
  `numeroPersonal` VARCHAR(50)NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_familiar`
    FOREIGN KEY (`idnino`)
    REFERENCES `kinderBD`.`nino` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;





-- -----------------------------------------------------
-- ENFERMEDAD
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`enfermedad` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`enfermedad` (
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(1000) NULL DEFAULT NULL,
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `id_nino` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_enfermedad` (`id_nino` ASC),
  CONSTRAINT `fk_enfermedad`
    FOREIGN KEY (`id_nino`)
    REFERENCES `kinderBD`.`nino` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- NOTICIA
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`noticia` ;
CREATE TABLE IF NOT EXISTS `kinderbd`.`noticia` (
  `titulo` VARCHAR(1000) NULL DEFAULT NULL,
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(5000) NULL DEFAULT NULL,
  `kinder` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `idx_noticia` (`kinder` ASC),
  CONSTRAINT `fk_noticia`
    FOREIGN KEY (`kinder`)
    REFERENCES `kinderBD`.`kinder` (`nombre`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
  
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- MATRICULA
-- -----------------------------------------------------
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kinderBD`.`matricula` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`matricula` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `completa` TINYINT(1) NULL DEFAULT NULL,
  `constanciaNac` TINYINT(1) NULL DEFAULT NULL,
  `carnetvac` TINYINT(1) NULL DEFAULT NULL,
  `fotos` TINYINT(1) NULL DEFAULT NULL,
  `matricula` VARCHAR(1000) NULL DEFAULT NULL,
  `cursolectivo` varchar(50) NULL DEFAULT NULL,
  `realizadoPor` varchar(1000) NULL DEFAULT NULL,
  `id_nino` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`codigo`),
    CONSTRAINT `fk_matricula`
    FOREIGN KEY (`id_nino`)
    REFERENCES `kinderBD`.`nino` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

---------- FALTA PAGOS (NO SE COMO)---------
DROP TABLE IF EXISTS `kinderBD`.`meses` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`meses` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `mes` VARCHAR(50),
  PRIMARY KEY (`codigo`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



DROP TABLE IF EXISTS `kinderBD`.`factura` ;

CREATE TABLE IF NOT EXISTS `kinderBD`.`factura` (
  `fecha_actual` VARCHAR(50) NULL DEFAULT NULL,
  `monto_final` VARCHAR(50) NULL DEFAULT NULL,
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `id_nino` VARCHAR(50),
  `id_mes` INT,
  `tipo_pago` VARCHAR(50),
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_factura`
    FOREIGN KEY (`id_nino`)
    REFERENCES `kinderBD`.`nino` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
	
  CONSTRAINT `fk_factura_01`
    FOREIGN KEY (`id_mes`)
    REFERENCES `kinderBD`.`meses` (`codigo`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

---------- FALTA PAGOS (NO SE COMO)---------


/*
DROP TABLE IF EXISTS `kinderBD`.`noticia` ;
DROP TABLE IF EXISTS `kinderBD`.`contacto` ;
DROP TABLE IF EXISTS `kinderBD`.`fechaPago` ;
DROP TABLE IF EXISTS `kinderBD`.`imagen` ;
DROP TABLE IF EXISTS `KinderBD`.`album` ;
DROP TABLE IF EXISTS `kinderBD`.`InformacionKinder` ;
DROP TABLE IF EXISTS `KinderBD`.`kinder` ;
DROP TABLE IF EXISTS `kinderBD`.`matricula` ;
DROP TABLE IF EXISTS `kinderBD`.`enfermedad` ;
DROP TABLE IF EXISTS `kinderBD`.`telefono` ;
DROP TABLE IF EXISTS `kinderBD`.`asignacion` ;
DROP TABLE IF EXISTS `kinderBD`.`enc_nino` ;
DROP TABLE IF EXISTS `kinderBD`.`usu_enc` ;
DROP TABLE IF EXISTS `kinderBD`.`informacion` ;
DROP TABLE IF EXISTS `kinderBD`.`familiar` ;
DROP TABLE IF EXISTS `kinderBD`.`factura` ;
DROP TABLE IF EXISTS `kinderBD`.`nino` ;
DROP TABLE IF EXISTS `kinderBD`.`encargado` ;
DROP TABLE IF EXISTS `kinderBD`.`clase` ;
DROP TABLE IF EXISTS `kinderBD`.`profesor` ;
DROP TABLE IF EXISTS `kinderBD`.`usuario` ;
DROP TABLE IF EXISTS `kinderBD`.`meses` ;
*/

