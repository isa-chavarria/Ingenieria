insert into kinderBD.kinder values('Kinder Lulu','San Sebastian Calle tres, 100 m este y 250 m sur.
','2227-3171.','El Jardín de Niños Lulú empezó a formarse en el mes de marzo de 1986, cuando en ese entonces la señora Rosibeth Jiménez García decidió brindar la educación a su hija menor y a su sobrino, ya que; en la comunidad no se encontraba ningún kinder, donde los niños recibieran una educación de calidad, donde el juego no fuera simplemente un juego, sino un motivo de aprendizaje. Para mediados de ese mismo año, ingresan dos vecinos y la prima de una de ellos. El Jardín de Niños Lulú, está ubicado en San Sebastián, Calle tres 75 m sur, 100 m este y 250 m sur de la entrada principal del Walmark
Dicho Jardín lleva el nombre de Lulú, en honor al sobrenombre que se le utilizaba a la fundadora, por el parecido a la pequeña Lulú, perteneciente a una caricatura con el mismo nombre, la cual, es una niña muy simpática, aunque a veces muy traviesa, que tiene una personalidad alegre, dinámica y muy inteligente. En los primeros diez años, trabajó con los niveles de preparatoria y kinder. Para 1997 se abre el nivel de prekinder y en el 2004 se da la apertura del nivel de materno. El Jardín de Niños Lulú es un centro de educación preescolar de carácter privado, que atiende a niños de edades comprendidas entre dos y cinco años, de nivel socioeconómico medio y medio alto, sin embargo; se caracteriza por el favorecimiento a los alumnos de escasos recursos. Obtiene los recursos económicos para su funcionamiento de las cuotas de matrícula y de las mensualidades. Tiene como tarea, estimular el desarrollo intelectual, por medio de la invención de nuevas ideas, la modificación constante del curriculum, según las necesidades de cada educando, con el fin de la búsqueda de la excelencia integral de cada niño, usando como fundamentos el amor, el rigor y la fe, para que los estudiantes se desarrollen plenamente en la dimensión cognoscitiva, socio-afectiva, psicomotora y espiritual.','Ser una comunidad humana y académica, que busca promover a los niños y las niñas, sin distinciones, hacia estados de superación y realización integral, mediante una formación de calidad, de acuerdo al avance tecnológico, pero a bajo costo económico.','Brindar a los educandos, a bajo costo económico, la oportunidad de instrucción a la vez de suplirles la necesidad recreativa latente en la comunidad, lo anterior con el propósito de perfeccionar su ser,logrando así, personas preparadas para desempeñar responsablemente sus funciones en la sociedad.');

-------------------INSERT GRUPOS----------------------------------------------------------

/*insert into kinderbd.clase values ('1','4-0569-0203','Materno');
insert into kinderbd.clase values ('2','1-07720-0892','Prekinder');
insert into kinderbd.clase values ('3','2-0315-0116','kinder');
insert into kinderbd.clase values ('4','1-0304-0551','Preparatoria');
*/

insert into kinderbd.clase (profesor,nivel)values ('4-0569-0203','Materno');
insert into kinderbd.clase (profesor,nivel)values ('1-07720-0892','Prekinder');
insert into kinderbd.clase (profesor,nivel)values ('2-0315-0116','kinder');
insert into kinderbd.clase (profesor,nivel)values ('1-0304-0551','Preparatoria');

-------------------INSERT PROFESORES----------------------------------------------------------
insert into kinderbd.profesor values ('Maria','Solano','Jimenez',300000,'maria.solano@hotmail.com','1985-05-12','4-0569-0203','','','Profesor');
insert into kinderbd.profesor values ('Carmen','Vargas','Soto',350000,'carmen06@hotmail.com','1985-06-08','1-07720-0892','','','Profesor');
insert into kinderbd.profesor values ('Marcos','Azofeifa','Cortes',300000,'marcoAzofeifa1711@gmail.com','1985-11-17','2-0315-0116','','','Profesor');
insert into kinderbd.profesor values ('Kimberly','Chacon','Arguedas',300000,'kimChacon11@gmail.com','1985-03-11','1-0304-0551','','','Profesor');

select * from kinderbd.usuario;
select * from kinderbd.encargado;
select * from kinderbd.usu_enc;
insert into kinderbd.usuario values('12345678','daryl@hotmail.com','1234','Administrador');
insert into kinderbd.encargado values('Daryl','12345678','Chinchilla','Navarro','Masculino','daryl@hotmail.com','','','','');
insert into kinderbd.usu_enc values('12345678','12345678');




select * from kinderbd.encargado;
select * from kinderbd.usuario;
select * from kinderbd.usu_enc;
select * from kinderbd.enc_nino;
select * from kinderbd.nino;
select * from kinderbd.profesor;
select * from kinderbd.clase;
select * from kinderbd.familiar;
select * from kinderbd.telefono;
select * from kinderbd.matricula;


insert into kinderbd.meses (mes) values('ENERO');
insert into kinderbd.meses (mes) values('FEBRERO');
insert into kinderbd.meses (mes) values('MARZO');
insert into kinderbd.meses (mes) values('ABRIL');
insert into kinderbd.meses (mes) values('MAYO');
insert into kinderbd.meses (mes) values('JUNIO');
insert into kinderbd.meses (mes) values('JULIO');
insert into kinderbd.meses (mes) values('AGOSTO');
insert into kinderbd.meses (mes) values('SETIEMBRE');
insert into kinderbd.meses (mes) values('OCTUBRE');
insert into kinderbd.meses (mes) values('NOVIEMBRE');
insert into kinderbd.meses (mes) values('DICIEMBRE');





//----------------INSERT NINOS-------


insert into kinderbd.usuario (id,email,contrasena,rol) values('32434678','gabriela@hotmail.com','bbbb','Encargado');
insert into kinderbd.encargado (nombre,id,apellido1,apellido2,email,direccion,telefono,fecha_nacimiento,ruta_imagen) values('Gabriela','32434678','Castro','Mora','gaby@hotmail.com','Paso Ancho','2227-5807','25/03/2012','');
insert into kinderbd.usu_enc values('32434678','32434678');
insert into Kinderbd.nino (id,estado,grupo)values('32434678',true,'1');
insert into kinderbd.enc_nino('32434678','32434678');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Mario','1-1581-429C','Castro','Altamirano','32','Transportes Rivera','Chofer','32434678','Padre','2547-0707','86885206');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Jaqueline','1-1279-0804','Mora','Castro','29','Envisa','Ventas','32434678','Madre','2547-0707','8517-4899');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Cristina','56754f435','Castro','Duran','','','','32434678','Encargado','','22275807');


---------------

insert into kinderbd.usuario (id,email,contrasena,rol) values('116674036','samuel@gmail.com','1234','Encargado');
insert into kinderbd.encargado (nombre,id,apellido1,apellido2,email,direccion,telefono,fecha_nacimiento,ruta_imagen) values('Samuel','116674036','Fallas','Castillo','samuel@gmail.com','Urbanizacion Maduras','2259-3347','01/04/2013','');
insert into kinderbd.usu_enc values('116674036','116674036');
insert into Kinderbd.nino (id,estado,grupo)values('116674036',true,'1');
insert into kinderbd.enc_nino values('116674036','116674036');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Esteban','1-1237-944','Murillo','Corrales','30','SINAI','Oficinista','116674036','Padre','2250-7434','8674-0221');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Corina','1-1101-827','Castillo','Mora','34','Casa','Ama de Casa','116674036','Madre','','8650-9632');



insert into kinderbd.usuario (id,email,contrasena,rol) values('110382746','mathi@gmail.com','1234','Encargado');
insert into kinderbd.encargado (nombre,id,apellido1,apellido2,email,direccion,telefono,fecha_nacimiento,ruta_imagen) values('Mathias','110382746','Jimenez','Solano','mathi@gmail.com','San Sebastian','','30/04/2012','');
insert into kinderbd.usu_enc values('110382746','110382746');
insert into Kinderbd.nino (id,estado,grupo)values('110382746',true,'2');
insert into kinderbd.enc_nino values('110382746','110382746');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Allan','113830288','Porras','Saborio','26','Bazar Colo','Dependiente','110382746','Padre','2226-0635','6181-2422');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Gabriela','1-1447-0241','Solano','Solano','25','Bazar Colo','Dependiente','110382746','Madre','2226-0635','6181-2422');

--------------
insert into kinderbd.usuario (id,email,contrasena,rol) values('115696754','annie@hotmail.com','kkkk','Encargado');
insert into kinderbd.encargado (nombre,id,apellido1,apellido2,email,direccion,telefono,fecha_nacimiento,ruta_imagen) values('Amy','115696754','Rodriguez','Abarca','annie@hotmail.com','Alajuelita','','23/09/2012','');
insert into kinderbd.usu_enc values('115696754','115696754');
insert into Kinderbd.nino (id,estado,grupo)values('115696754',true,'1');
insert into kinderbd.enc_nino values('115696754','115696754');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Annie','113850330','Abarca','Ramirez','26','PlazaDelSol','Cajera','115696754','Madre','22256093','84425055');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Mauleem','114259865','Abarca','Ramirez','','','','115696754','Encargado','','87604749');



insert into kinderbd.usuario (id,email,contrasena,rol) values('163907676','nicole@hotmail.com','0909','Encargado');
insert into kinderbd.encargado (nombre,id,apellido1,apellido2,email,direccion,telefono,fecha_nacimiento,ruta_imagen) values('Neidon','163907676','Arroyo','Quesada','nicole@hotmail.com','FiscaliaNicaragua150Norte','','31/10/2012','');
insert into kinderbd.usu_enc values('163907676','163907676');
insert into Kinderbd.nino (id,estado,grupo)values('163907676',true,'1');
insert into kinderbd.enc_nino values('163907676','163907676');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Nicole','114800705','Quesada','Campos','24','','Ama de casa','163907676','Madre','','83445675');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Jonathan','116797698','Ordeñana','Ramirez','','','','163907676','Encargado','','89153182');

--
insert into kinderbd.usuario (id,email,contrasena,rol) values('119762876','maria@gmail.com','1234','Encargado');
insert into kinderbd.encargado (nombre,id,apellido1,apellido2,email,direccion,telefono,fecha_nacimiento,ruta_imagen) values('Maria','119762876','Leon','Streber','maria@gmail.com','Paso Ancho','2286-4262','03/12/2010','');
insert into kinderbd.usu_enc values('119762876','119762876');
insert into Kinderbd.nino (id,estado,grupo)values('119762876',true,'4');
insert into kinderbd.enc_nino values('119762876','119762876');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Juan','114142950','Leon','Artavia','43','Ekono','Vendedor','119762876','Padre','2286-4262','8862-8793');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Natalia','163759156','Streber','Solano','40','Casa','Ama de Casa','119762876','Madre','8309-4943','');


insert into kinderbd.usuario (id,email,contrasena,rol) values('119886949','aaron@gmail.com','1234','Encargado');
insert into kinderbd.encargado (nombre,id,apellido1,apellido2,email,direccion,telefono,fecha_nacimiento,ruta_imagen) values('Aaron','119886949','Segura','Garro','aaron@gmail.com','Guarari','2227-0356','12/09/2011','');
insert into kinderbd.usu_enc values('119886949','119886949');
insert into Kinderbd.nino (id,estado,grupo)values('119886949',true,'3');
insert into kinderbd.enc_nino values('119886949','119886949');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Victor','113830288','Segura','Peñá','35','Perimercados','Cajero','119886949','Padre','','2227-0354');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Maria','1-3256-0816','Garro','Rivera','32','Casa','Ama de Casa','119886949','Madre','','8829-6424');


insert into kinderbd.usuario (id,email,contrasena,rol) values('123125634','vero@hotmail.com','7777','Encargado');
insert into kinderbd.encargado (nombre,id,apellido1,apellido2,email,direccion,telefono,fecha_nacimiento,ruta_imagen) values('Layan','123125634','Valencia','Aleman','vero@hotmail.com','Paso Ancho','40808226','9/09/2012','');
insert into kinderbd.usu_enc values('123125634','123125634');
insert into Kinderbd.nino (id,estado,grupo)values('123125634',true,'2');
insert into kinderbd.enc_nino('123125634','123125634');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Enrique','115675427','Valencia','Segura','27','','Comerciante','123125634','Padre','25478765','87453218');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Veronica','114580913','Aleman','Noguera','25','Comerciante','Ventas','123125634','Madre','40808226','61537106');
insert into kinderbd.familiar (nombre,id,apellido1,apellido2,edad,lugarTrabajo,ocupacion,idnino,parentesco,numeroTrabajo,numeroPersonal)
values ('Amalia','567538754','Noguera','Duran','','','','123125634','Encargado','','40808226');




