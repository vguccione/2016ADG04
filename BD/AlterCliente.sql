ALTER TABLE Cliente DROP CONSTRAINT [FK__Cliente__IdTipoC__412EB0B6]
GO

ALTER TABLE Cliente DROP CONSTRAINT [FK__Cliente__IdTipoC__00200768]
GO

ALTER TABLE Cliente DROP CONSTRAINT [FK__Cliente__IdTipoC__3F115E1A]
GO

ALTER TABLE Cliente
drop column idTipoCliente
GO

ALTER TABLE cliente
add  TipoCliente char not null
go

