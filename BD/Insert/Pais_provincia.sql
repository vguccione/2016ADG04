/******************* -insertar paises y provincias ****************/
-- SET IDENTITY_INSERT to ON.  
SET IDENTITY_INSERT dbo.Pais ON;  
GO  

insert into dbo.Pais (IdPais, Descripcion) values (1,'Argentina')
insert into dbo.Pais (IdPais, Descripcion) values (2,'Brasil')

go

-- SET IDENTITY_INSERT to OFF.  
SET IDENTITY_INSERT dbo.Pais OFF;  
GO  

select * from Pais

-- SET IDENTITY_INSERT to ON.  
SET IDENTITY_INSERT dbo.Provincia ON;  
GO  

insert into dbo.Provincia (IdProvincia, Descripcion) values (1,'Capital Federal')
insert into dbo.Provincia (IdProvincia, Descripcion) values (2,'Buenos Aires')
insert into dbo.Provincia (IdProvincia, Descripcion) values (3,'Cordoba')
insert into dbo.Provincia (IdProvincia, Descripcion) values (4,'Santa Fe')

go

-- SET IDENTITY_INSERT to OFF.  
SET IDENTITY_INSERT dbo.Provincia OFF;  
GO  

select * from Provincia