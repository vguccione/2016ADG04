/************* alter cliente ******************/
alter table cliente
add IdDireccion int not null
go

ALTER TABLE [dbo].Cliente  WITH CHECK ADD FOREIGN KEY([IdDireccion])
REFERENCES [dbo].[Direccion] ([IdDireccion])
GO


/******** alter direccion *********/
ALTER TABLE [dbo].[Direccion] DROP CONSTRAINT [FK__Direccion__IdCli__4316F928]
GO

alter table Direccion
drop column IdCliente
go