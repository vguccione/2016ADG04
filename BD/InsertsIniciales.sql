USE AD2016_new
GO


ALTER TABLE producto
ALTER COLUMN unidad varchar(255)
go

/*Roles usuario*/

SET IDENTITY_INSERT dbo.Rol ON
GO  


Insert into Rol (IdRol,Descripcion) VALUES(1,'ADMINISTRACION')
Insert into Rol (IdRol,Descripcion) VALUES(2,'VEHICULOS')
Insert into Rol (IdRol,Descripcion) VALUES(3,'ENVIO')
Insert into Rol (IdRol,Descripcion) VALUES(4,'ENCOMIENDA')


SET IDENTITY_INSERT dbo.Rol off;  
GO


/*usuario administrador*/

SET IDENTITY_INSERT dbo.[Usuario] on;  
GO  


INSERT INTO [dbo].[Usuario]  (IdUsuario, Apellido, dni, fechaCreacion, Nombre, Password, UltimoAcceso, usuario, IdSucursal) 
VALUES (1,'Administrador','123456',getDate(),'Admin','admin',getDate(),'admin',null)
GO


SET IDENTITY_INSERT dbo.[Usuario] off;  
GO


/*UsuarioRol*/
INSERT INTO UsuarioRol VALUES(1,1)
INSERT INTO UsuarioRol VALUES(1,2)
INSERT INTO UsuarioRol VALUES(1,3)
INSERT INTO UsuarioRol VALUES(1,4)


/*Paises y Provincias*/
SET IDENTITY_INSERT dbo.pais ON;  
GO  

INSERT INTO pais (IdPais,Descripcion) VALUES(1,'Argentina')
INSERT INTO pais (IdPais,Descripcion) VALUES(2,'Espana')
INSERT INTO pais (IdPais,Descripcion) VALUES(3,'Francia')
INSERT INTO pais (IdPais,Descripcion) VALUES(4,'Colombia')
INSERT INTO pais (IdPais,Descripcion) VALUES(5,'China')
INSERT INTO pais (IdPais,Descripcion) VALUES(6,'Peru')
INSERT INTO pais (IdPais,Descripcion) VALUES(7,'Mexico')
INSERT INTO pais (IdPais,Descripcion) VALUES(8,'USA')
INSERT INTO pais (IdPais,Descripcion) VALUES(9,'Inglaterra')
INSERT INTO pais (IdPais,Descripcion) VALUES(10,'Italia')
INSERT INTO pais (IdPais,Descripcion) VALUES(11,'Alemania')
INSERT INTO pais (IdPais,Descripcion) VALUES(12,'Japon')

SET IDENTITY_INSERT dbo.Pais off;  
GO  

SET IDENTITY_INSERT dbo.provincia ON;  
GO  

INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(1,'Buenos Aires',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(2,'Mendoza',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(3,'Cordoba',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(4,'La Pampa',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(5,'Santa Fe',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(6,'Capital Federal',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(7,'La Rioja',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(8,'Catamarca',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(9,'Salta',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(10,'Jujuy',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(11,'Tucuman',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(12,'Rio Negro',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(13,'Tierra del Fuego',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(14,'Neuquen',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(15,'Misiones',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(16,'Entre Rios',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(17,'Formosa',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(18,'San Juan',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(19,'Chubut',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(20,'Santa Cruz',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(21,'Santiago del Estero',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(22,'Chaco',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(23,'Corrientes',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(24,'San Luis',1)

SET IDENTITY_INSERT dbo.provincia off;  
GO  

