CREATE SCHEMA kinder;

CREATE TABLE kinder.encargado ( 
	nombre               varchar(50)    ,
	id                   varchar(50)  NOT NULL  ,
	apellido1            varchar(50)    ,
	apellido2            varchar(50)    ,
	email                varchar(50)    ,
	direccion            varchar(50)    ,
	telefono             varchar(50)    ,
	fecha_nacimiento     varchar(50)    ,
	rol                  varchar(50)    ,
	ruta_imagen          varchar(1000)    ,
	CONSTRAINT pk_encargado PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE TABLE kinder.kinder ( 
	nombre               varchar(50)  NOT NULL  ,
	direccion            varchar(50)    ,
	telefono             varchar(50)    ,
	historia             varchar(5000)    ,
	mision               varchar(5000)    ,
	vision               varchar(5000)    ,
	CONSTRAINT pk_kinder PRIMARY KEY ( nombre )
 ) engine=InnoDB;

CREATE TABLE kinder.planilla ( 
	id                   varchar(50)  NOT NULL  ,
	fecha                date  NOT NULL  ,
	montopago            float    ,
	estado               bool    ,
	CONSTRAINT id_fecha PRIMARY KEY ( id, fecha ),
	CONSTRAINT pk_planilla UNIQUE ( id ) 
 ) engine=InnoDB;

CREATE TABLE kinder.profesor ( 
	nombre               varchar(50)    ,
	apellido1            varchar(50)    ,
	apellido2            varchar(50)    ,
	salario              float    ,
	email                varchar(50)    ,
	fechanacimiento      date    ,
	id                   varchar(50)  NOT NULL  ,
	CONSTRAINT pk_profesor PRIMARY KEY ( id ),
	CONSTRAINT fk_profesor FOREIGN KEY ( id ) REFERENCES kinder.planilla( id ) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE TABLE kinder.usuario ( 
	id                   varchar(50)  NOT NULL  ,
	contrasena           varchar(50)    ,
	role_seccion         varchar(50)    ,
	encargado            varchar(50)    ,
	profesor             varchar(50)    ,
	CONSTRAINT pk_role PRIMARY KEY ( id ),
	CONSTRAINT fk_usuario FOREIGN KEY ( profesor ) REFERENCES kinder.profesor( id ) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT fk_usuario_0 FOREIGN KEY ( encargado ) REFERENCES kinder.encargado( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_usuario ON kinder.usuario ( profesor );

CREATE INDEX idx_usuario_0 ON kinder.usuario ( encargado );

CREATE TABLE kinder.album ( 
	nombre               varchar(200)  NOT NULL  ,
	kinder               varchar(50)    ,
	CONSTRAINT pk_albun PRIMARY KEY ( nombre ),
	CONSTRAINT fk_albun FOREIGN KEY ( kinder ) REFERENCES kinder.kinder( nombre ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_albun ON kinder.album ( kinder );

CREATE TABLE kinder.clase ( 
	id                   varchar(50)  NOT NULL  ,
	nombre               varchar(50)    ,
	profesor             varchar(50)    ,
	CONSTRAINT pk_clase PRIMARY KEY ( id ),
	CONSTRAINT fk_clase FOREIGN KEY ( profesor ) REFERENCES kinder.profesor( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_clase ON kinder.clase ( profesor );

CREATE TABLE kinder.contacto ( 
	titulo               varchar(50)    ,
	codigo               varchar(50)  NOT NULL  ,
	descripcion          varchar(50)    ,
	kinder               varchar(50)    ,
	CONSTRAINT pk_contacto PRIMARY KEY ( codigo ),
	CONSTRAINT fk_contacto FOREIGN KEY ( kinder ) REFERENCES kinder.kinder( nombre ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_contacto ON kinder.contacto ( kinder );

CREATE TABLE kinder.factura ( 
	fecha_actual         date    ,
	monto_final          float    ,
	codigo               varchar(50)  NOT NULL  ,
	kinder               varchar(50)    ,
	encargado            varchar(50)    ,
	CONSTRAINT pk_factura PRIMARY KEY ( codigo ),
	CONSTRAINT fk_factura FOREIGN KEY ( kinder ) REFERENCES kinder.kinder( nombre ) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT fk_factura_0 FOREIGN KEY ( encargado ) REFERENCES kinder.encargado( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_factura ON kinder.factura ( kinder );

CREATE INDEX idx_factura_0 ON kinder.factura ( encargado );

CREATE TABLE kinder.imagen ( 
	ruta_imagen          varchar(1000)    ,
	codigo               varchar(50)  NOT NULL  ,
	album                varchar(200)    ,
	CONSTRAINT pk_galeria PRIMARY KEY ( codigo ),
	CONSTRAINT fk_imagen FOREIGN KEY ( album ) REFERENCES kinder.album( nombre ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_imagen ON kinder.imagen ( album );

CREATE TABLE kinder.linea_pago ( 
	descripcion          varchar(50)    ,
	monto                float    ,
	id                   varchar(50)  NOT NULL  ,
	factura              varchar(50)    ,
	CONSTRAINT pk_linea_pago PRIMARY KEY ( id ),
	CONSTRAINT fk_linea_pago FOREIGN KEY ( factura ) REFERENCES kinder.factura( codigo ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_linea_pago ON kinder.linea_pago ( factura );

CREATE TABLE kinder.nino ( 
	id                   varchar(50)  NOT NULL  ,
	nombre               varchar(50)    ,
	apellido1            varchar(50)    ,
	apellido2            varchar(50)    ,
	fechanacimiento      date    ,
	direccion            varchar(50)    ,
	clase                varchar(50)    ,
	CONSTRAINT pk_nino PRIMARY KEY ( id ),
	CONSTRAINT fk_nino FOREIGN KEY ( clase ) REFERENCES kinder.clase( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_nino ON kinder.nino ( clase );

CREATE TABLE kinder.`encargado-nino` ( 
	monto_pago           float    ,
	estado               bool    ,
	morosida             bool    ,
	fecha_pago           date    ,
	id_nino              varchar(50)  NOT NULL  ,
	id_encargado         varchar(50)  NOT NULL  ,
	CONSTRAINT `idx_encargado-nino` PRIMARY KEY ( id_nino, id_encargado ),
	CONSTRAINT `fk_encargado-nino` FOREIGN KEY ( id_encargado ) REFERENCES kinder.encargado( id ) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT `fk_encargado-nino_0` FOREIGN KEY ( id_nino ) REFERENCES kinder.nino( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_encargado-nino_0 ON kinder.`encargado-nino` ( id_encargado );

CREATE INDEX idx_encargado-nino_1 ON kinder.`encargado-nino` ( id_nino );

CREATE TABLE kinder.enfermedad ( 
	nombre               varchar(50)    ,
	descripcion          varchar(50)    ,
	codigo               varchar(50)  NOT NULL  ,
	id_nino              varchar(50)    ,
	CONSTRAINT pk_enfermedades PRIMARY KEY ( codigo ),
	CONSTRAINT fk_enfermedad FOREIGN KEY ( id_nino ) REFERENCES kinder.nino( id ) ON DELETE CASCADE ON UPDATE NO ACTION
 ) engine=InnoDB;

CREATE INDEX idx_enfermedad ON kinder.enfermedad ( id_nino );

