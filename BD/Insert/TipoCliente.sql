-- SET IDENTITY_INSERT to ON.  
SET IDENTITY_INSERT dbo.TipoCliente ON;  
GO  

insert into dbo.TipoCliente (IdTipoCliente, Descripcion) values (1,'Particular')
insert into dbo.TipoCliente (IdTipoCliente, Descripcion) values (2,'Empresa')

go


-- SET IDENTITY_INSERT to OFF.  
SET IDENTITY_INSERT dbo.TipoCliente OFF;  
GO  

select * from TipoCliente


