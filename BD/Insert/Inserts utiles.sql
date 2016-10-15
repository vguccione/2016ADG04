USE [distribucionPaquetes]
GO

INSERT INTO Coordenada VALUES('34°35′59″S','58°22′55″O﻿')
INSERT INTO Coordenada VALUES('36°35′49″S','48°22′55″O﻿')

INSERT INTO pais VALUES('Argentina')
INSERT INTO provincia VALUES('Buenos Aires',1)
INSERT INTO provincia VALUES('Mendoza',1)
INSERT INTO provincia VALUES('Cordoba',1)
INSERT INTO provincia VALUES('La Pampa',1)

INSERT INTO Direccion VALUES('Calle prueba a', 1231,'Capital Federal', 222, 1, 1)
INSERT INTO Direccion VALUES('Calle prueba b', 1231,'Rosario', 222, 1, 3)

INSERT INTO [dbo].[Sucursal] VALUES ('Sucursal A','23432423',1,1)
GO
INSERT INTO [dbo].[Sucursal] VALUES ('Sucursal B','1111111',2,2)
GO

INSERT INTO Cliente VALUES('p','email@email.com',1,'1231231','13123122','','Lopez','34242342', 'Pepe',2,null)

INSERT INTO Producto VALUES('categoria A',2332,'Producto A','u',1)

INSERT INTO PlanMantenimiento VALUES('Plan A','plan mantenimiento A')
INSERT INTO PlanMantenimiento VALUES('Plan B','plan mantenimiento B')

INSERT INTO tareaMantenimiento VALUES('k','cambiar ruedas',1000,null,1)
INSERT INTO tareaMantenimiento VALUES('t','revisar frenos',null,30,1)
INSERT INTO tareaMantenimiento VALUES('k','cambiar ruedas',2000,null,2)
INSERT INTO tareaMantenimiento VALUES('t','revisar frenos',null,60,2)

INSERT INTO Vehiculo VALUES('2010-01-01', 100, 200, 300, '', null, 1000, 1000, 'Mercedes Benz', 'Camion1', 'AAA0001', 2934, 0, 2334, 3234, 1, 1)
INSERT INTO Vehiculo VALUES('2010-01-01', 200, 400, 600, '', null, 1550, 1200, 'Mercedes Benz', 'Camion2', 'AAA0002', 2955, 0, 2334, 3234, 1, 1)
INSERT INTO Vehiculo VALUES('2010-01-01', 300, 600, 400, '', null, 1340, 1040, 'Mercedes Benz', 'Camion3', 'AAA0003', 3434, 0, 2334, 3234, 2, 2)
INSERT INTO Vehiculo VALUES('2010-01-01', 400, 400, 200, '', null, 1020, 1230, 'Mercedes Benz', 'Camion4', 'AAA0004', 2934, 0, 2334, 3234, 2, 2)


INSERT INTO Proveedor VALUES(1,'23434343','mail@mail.com','Proveedor A','234343',1)
INSERT INTO Proveedor VALUES(1,'12323223','mailB@mail.com','Proveedor B','234343',2)
INSERT INTO TallerMecanico VALUES(234,'oficial',1)
INSERT INTO TallerMecanico VALUES(2124,'lubricentro',2)

INSERT INTO TareaMantenimientoRealizada VALUES(1000,GETDATE(),1,1,1)
INSERT INTO TareaMantenimientoRealizada VALUES(null,GETDATE(),1,2,1)
INSERT INTO TareaMantenimientoRealizada VALUES(1500,GETDATE(),2,3,2)
INSERT INTO TareaMantenimientoRealizada VALUES(1000,GETDATE(),1,3,3)
INSERT INTO TareaMantenimientoRealizada VALUES(null,GETDATE(),1,4,3)

INSERT INTO Proveedor VALUES(1,'111111','seguro@mail.com','Seguro','234343',1)
INSERT INTO Seguro VALUES('Seguro aloja',23422,432,'Todo riesgo',3)

INSERT INTO Proveedor VALUES(1,'22222','ss@mail.com','Servicio Seguridad','234343',2)
INSERT INTO ServicioSeguridad VALUES('SS aloja',432,4)

INSERT INTO MapaDeRuta VALUES(1000,48,2,1,100)






