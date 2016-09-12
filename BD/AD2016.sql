USE [master]
GO
/****** Object:  Database [AD2016]    Script Date: 11/9/2016 10:10:25 p. m. ******/
ALTER DATABASE [AD2016] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AD2016].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [AD2016] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [AD2016] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [AD2016] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [AD2016] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [AD2016] SET ARITHABORT OFF 
GO
ALTER DATABASE [AD2016] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [AD2016] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [AD2016] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [AD2016] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [AD2016] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [AD2016] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [AD2016] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [AD2016] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [AD2016] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [AD2016] SET  DISABLE_BROKER 
GO
ALTER DATABASE [AD2016] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [AD2016] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [AD2016] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [AD2016] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [AD2016] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [AD2016] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [AD2016] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [AD2016] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [AD2016] SET  MULTI_USER 
GO
ALTER DATABASE [AD2016] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [AD2016] SET DB_CHAINING OFF 
GO
ALTER DATABASE [AD2016] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [AD2016] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [AD2016] SET DELAYED_DURABILITY = DISABLED 
GO

USE [AD2016]
GO
/****** Object:  User [ad2016]    Script Date: 11/9/2016 10:10:25 p. m. ******/
CREATE USER [ad2016] FOR LOGIN [ad2016] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [ad2016]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[IdCliente] [int] IDENTITY(1,1) NOT NULL,
	[RazonSocial] [varchar](50) NULL,
	[Cuit] [varchar](50) NULL,
	[Estado] [bit] NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Telefono] [varchar](50) NOT NULL,
	[IdTipoCliente] [int] NOT NULL,
	[Nombre] [varchar](100) NULL,
	[Apellido] [varchar](200) NULL,
	[Dni] [char](8) NULL,
 CONSTRAINT [pk_Cliente] PRIMARY KEY CLUSTERED 
(
	[IdCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CondicionesEspecialesVehiculo]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CondicionesEspecialesVehiculo](
	[IdCondicionesEspecialesVehiculo] [int] IDENTITY(1,1) NOT NULL,
	[IdVehiculo] [int] NOT NULL,
	[Descripcion] [varchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCondicionesEspecialesVehiculo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Coordenada]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Coordenada](
	[IdCoordenada] [int] IDENTITY(1,1) NOT NULL,
	[Latitud] [float] NOT NULL,
	[Longitud] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCoordenada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CuentaCorriente]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CuentaCorriente](
	[IdCtaCte] [int] IDENTITY(1,1) NOT NULL,
	[IdCliente] [int] NULL,
	[Credito] [float] NOT NULL,
	[LimiteCredito] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCtaCte] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Direccion]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Direccion](
	[IdDireccion] [int] IDENTITY(1,1) NOT NULL,
	[Calle] [varchar](100) NOT NULL,
	[Nro] [int] NOT NULL,
	[Localidad] [varchar](100) NOT NULL,
	[CodigoPostal] [int] NOT NULL,
	[IdProvincia] [int] NOT NULL,
	[IdPais] [int] NOT NULL,
	[IdCliente] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDireccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Encomienda]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Encomienda](
	[IdEncomienda] [int] IDENTITY(1,1) NOT NULL,
	[TipoEncomienda] [varchar](2) NOT NULL,
	[IdSucursalOrigen] [int] NOT NULL,
	[IdSucursalDestino] [int] NOT NULL,
	[IdSucursalActual] [int] NULL,
	[IdDireccionOrigen] [int] NULL,
	[IdDireccionDestino] [int] NULL,
	[FechaCreacion] [datetime] NOT NULL,
	[FechaEstimadaEntrega] [datetime] NOT NULL,
	[Estado] [char](50) NOT NULL,
	[Tercerizado] [bit] NOT NULL,
	[IdItemFactura] [int] NOT NULL,
	[IdCliente] [int] NOT NULL,
	[IdEnvio] [int] NOT NULL,
	[Largo] [float] NULL,
	[Alto] [float] NULL,
	[Ancho] [float] NULL,
	[Peso] [float] NULL,
	[Volumen] [float] NULL,
	[Tratamiento] [varchar](50) NULL,
	[Apilable] [bit] NULL,
	[CantApilable] [smallint] NULL,
	[Refrigerado] [bit] NULL,
	[CondicionTransporte] [varchar](50) NULL,
	[IndicacionesManipulacion] [varchar](1000) NULL,
	[Fragilidad] [varchar](20) NULL,
	[NombreReceptor] [varchar](100) NOT NULL,
	[ApellidoReceptor] [varchar](100) NOT NULL,
	[DniReceptor] [char](8) NOT NULL,
	[VolumenGranel] [float] NULL,
	[UnidadGranel] [varchar](25) NULL,
	[CargaGranel] [varchar](100) NULL,
 CONSTRAINT [pk_Encomienda] PRIMARY KEY CLUSTERED 
(
	[IdEncomienda] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Envio]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Envio](
	[IdEnvio] [int] IDENTITY(1,1) NOT NULL,
	[IdSucursalOrigen] [int] NOT NULL,
	[IdSucursalDestino] [int] NOT NULL,
	[IdCoordenadaActual] [int] NOT NULL,
	[Estado] [varchar](20) NOT NULL,
	[FechaLlegadaEstimada] [date] NOT NULL,
	[HoraLlegadaEstimada] [time](7) NOT NULL,
	[FechaSalida] [date] NOT NULL,
	[HoraSalida] [time](7) NOT NULL,
	[IdVehiculo] [int] NULL,
	[Propio] [bit] NOT NULL,
	[NroTracking] [int] NULL,
	[IdProveedor] [int] NULL,
	[IdMapaDeRuta] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEnvio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Factura]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Factura](
	[IdFactura] [int] IDENTITY(1,1) NOT NULL,
	[TipoFactura] [char](1) NOT NULL,
	[Fecha] [datetime] NOT NULL,
	[Pagada] [bit] NOT NULL,
	[IdCtaCte] [int] NULL,
	[Vencimiento] [datetime] NOT NULL,
	[FechaVencimiento] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFactura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ItemFactura]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemFactura](
	[IdItemFactura] [int] IDENTITY(1,1) NOT NULL,
	[IdFactura] [int] NULL,
	[Cantidad] [int] NOT NULL,
	[Valor] [money] NOT NULL,
	[Descripcion] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdItemFactura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MapaDeRuta]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MapaDeRuta](
	[IdMapaDeRuta] [int] IDENTITY(1,1) NOT NULL,
	[DisanciaKm] [float] NOT NULL,
	[IdSucursalOrigen] [int] NOT NULL,
	[IdSucursalDestino] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMapaDeRuta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MapaDeRutaCoordenada]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MapaDeRutaCoordenada](
	[IdMapaDeRutaCoordenada] [int] IDENTITY(1,1) NOT NULL,
	[IdCoordenada] [int] NOT NULL,
	[IdMapaDeRuta] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMapaDeRutaCoordenada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Pais]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pais](
	[IdPais] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPais] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PlanMantenimiento]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PlanMantenimiento](
	[IdPlanMantenimiento] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [varchar](50) NOT NULL,
	[Comentarios] [varchar](255) NOT NULL,
 CONSTRAINT [pk_PlanMantenimiento] PRIMARY KEY CLUSTERED 
(
	[IdPlanMantenimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Producto]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[IdProducto] [int] IDENTITY(1,1) NOT NULL,
	[CodigoProducto] [int] NOT NULL,
	[IdCliente] [int] NOT NULL,
	[Descripcion] [varchar](100) NOT NULL,
	[Unidad] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProductoEncomienda]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductoEncomienda](
	[IdProductoEncomienda] [int] IDENTITY(1,1) NOT NULL,
	[IdEncomienda] [int] NOT NULL,
	[IdProducto] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProductoEncomienda] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Proveedor]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proveedor](
	[IdProveedor] [int] IDENTITY(1,1) NOT NULL,
	[Activo] [varchar](1) NOT NULL,
	[Cuit] [varchar](10) NOT NULL,
	[RazonSocial] [varchar](50) NOT NULL,
	[IdDireccion] [int] NULL,
	[Email] [varchar](50) NOT NULL,
	[Telefono] [varchar](50) NOT NULL,
	[IdTipoProveedor] [int] NOT NULL,
	[TarifaPorKm] [float] NULL,
	[Tarifa] [float] NULL,
	[TipoTaller] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Provincia]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Provincia](
	[IdProvincia] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProvincia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Remito]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Remito](
	[IdRemito] [int] IDENTITY(1,1) NOT NULL,
	[NombreReceptor] [varchar](100) NOT NULL,
	[ApellidoReceptor] [varchar](100) NOT NULL,
	[DniReceptor] [char](8) NOT NULL,
	[Conformado] [bit] NOT NULL,
	[FechaConformado] [bit] NOT NULL,
	[IdEncomienda] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRemito] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RolUsuario]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RolUsuario](
	[IdRolUsuario] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRolUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sucursal]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sucursal](
	[IdSucursal] [int] IDENTITY(1,1) NOT NULL,
	[IdDireccion] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSucursal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TareaMantenimiento]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TareaMantenimiento](
	[IdTareaMantenimiento] [int] IDENTITY(1,1) NOT NULL,
	[IdPlanMantenimiento] [int] NOT NULL,
	[Tarea] [varchar](255) NOT NULL,
	[CantidadKilometros] [float] NULL,
	[CantidadDias] [float] NULL,
 CONSTRAINT [pk_TareaMantenimiento] PRIMARY KEY CLUSTERED 
(
	[IdTareaMantenimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TareaMantenimientoRealizada]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TareaMantenimientoRealizada](
	[IdTareaMantenimientoRealizada] [int] IDENTITY(1,1) NOT NULL,
	[IdTareaMantenimiento] [int] NOT NULL,
	[IdVehiculo] [int] NOT NULL,
	[FechaRealizada] [datetime] NOT NULL,
	[CantidadKilometros] [float] NOT NULL,
	[IdProveedor] [int] NOT NULL,
 CONSTRAINT [pk_TareaMantenimientoRealizada] PRIMARY KEY CLUSTERED 
(
	[IdTareaMantenimientoRealizada] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TipoCliente]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoCliente](
	[IdTipoCliente] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTipoCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TipoProveedor]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoProveedor](
	[IdTipoProveedor] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTipoProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[IdUsuario] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](100) NOT NULL,
	[Apellido] [varchar](100) NOT NULL,
	[Dni] [char](8) NOT NULL,
	[IdSucursal] [int] NULL,
	[IdRolUsuario] [int] NULL,
	[NombreUsuario] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[UltimoAcceso] [datetime] NOT NULL,
	[FechaCreacion] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Vehiculo]    Script Date: 11/9/2016 10:10:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vehiculo](
	[IdVehiculo] [int] IDENTITY(1,1) NOT NULL,
	[Largo] [float] NULL,
	[Alto] [float] NULL,
	[Ancho] [float] NULL,
	[Peso] [float] NULL,
	[Volumen] [float] NULL,
	[Refrigerado] [bit] NULL,
	[CondicionTransporte] [varchar](50) NULL,
	[KmRecorridos] [float] NOT NULL,
	[Marca] [varchar](100) NOT NULL,
	[Modelo] [varchar](100) NOT NULL,
	[Patente] [varchar](15) NOT NULL,
	[Anio] [smallint] NOT NULL,
	[Tara] [float] NOT NULL,
	[CostoKM] [float] NOT NULL,
	[FechaIngreso] [Datetime] not null,
	[IdPlanMantenimiento] [int] NOT NULL,
	[IdSucursalActual] int not null,
PRIMARY KEY CLUSTERED 
(
	[IdVehiculo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD FOREIGN KEY([IdTipoCliente])
REFERENCES [dbo].[TipoCliente] ([IdTipoCliente])
GO
ALTER TABLE [dbo].[CondicionesEspecialesVehiculo]  WITH CHECK ADD FOREIGN KEY([IdVehiculo])
REFERENCES [dbo].[Vehiculo] ([IdVehiculo])
GO
ALTER TABLE [dbo].[CuentaCorriente]  WITH CHECK ADD FOREIGN KEY([IdCliente])
REFERENCES [dbo].[Cliente] ([IdCliente])
GO
ALTER TABLE [dbo].[Direccion]  WITH CHECK ADD FOREIGN KEY([IdCliente])
REFERENCES [dbo].[Cliente] ([IdCliente])
GO
ALTER TABLE [dbo].[Direccion]  WITH CHECK ADD FOREIGN KEY([IdPais])
REFERENCES [dbo].[Pais] ([IdPais])
GO
ALTER TABLE [dbo].[Direccion]  WITH CHECK ADD FOREIGN KEY([IdProvincia])
REFERENCES [dbo].[Provincia] ([IdProvincia])
GO
ALTER TABLE [dbo].[Encomienda]  WITH CHECK ADD FOREIGN KEY([IdCliente])
REFERENCES [dbo].[Cliente] ([IdCliente])
GO
ALTER TABLE [dbo].[Encomienda]  WITH CHECK ADD FOREIGN KEY([IdDireccionOrigen])
REFERENCES [dbo].[Direccion] ([IdDireccion])
GO
ALTER TABLE [dbo].[Encomienda]  WITH CHECK ADD FOREIGN KEY([IdDireccionDestino])
REFERENCES [dbo].[Direccion] ([IdDireccion])
GO
ALTER TABLE [dbo].[Encomienda]  WITH CHECK ADD FOREIGN KEY([IdEnvio])
REFERENCES [dbo].[Envio] ([IdEnvio])
GO
ALTER TABLE [dbo].[Encomienda]  WITH CHECK ADD FOREIGN KEY([IdItemFactura])
REFERENCES [dbo].[ItemFactura] ([IdItemFactura])
GO
ALTER TABLE [dbo].[Encomienda]  WITH CHECK ADD FOREIGN KEY([IdSucursalOrigen])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
ALTER TABLE [dbo].[Encomienda]  WITH CHECK ADD FOREIGN KEY([IdSucursalDestino])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
ALTER TABLE [dbo].[Encomienda]  WITH CHECK ADD FOREIGN KEY([IdSucursalActual])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD FOREIGN KEY([IdCoordenadaActual])
REFERENCES [dbo].[Coordenada] ([IdCoordenada])
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD FOREIGN KEY([IdMapaDeRuta])
REFERENCES [dbo].[MapaDeRuta] ([IdMapaDeRuta])
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD FOREIGN KEY([IdProveedor])
REFERENCES [dbo].[Proveedor] ([IdProveedor])
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD FOREIGN KEY([IdSucursalOrigen])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD FOREIGN KEY([IdSucursalDestino])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD FOREIGN KEY([IdVehiculo])
REFERENCES [dbo].[Vehiculo] ([IdVehiculo])
GO
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD FOREIGN KEY([IdCtaCte])
REFERENCES [dbo].[CuentaCorriente] ([IdCtaCte])
GO
ALTER TABLE [dbo].[ItemFactura]  WITH CHECK ADD FOREIGN KEY([IdFactura])
REFERENCES [dbo].[Factura] ([IdFactura])
GO
ALTER TABLE [dbo].[MapaDeRuta]  WITH CHECK ADD FOREIGN KEY([IdSucursalOrigen])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
ALTER TABLE [dbo].[MapaDeRuta]  WITH CHECK ADD FOREIGN KEY([IdSucursalDestino])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
ALTER TABLE [dbo].[MapaDeRutaCoordenada]  WITH CHECK ADD FOREIGN KEY([IdCoordenada])
REFERENCES [dbo].[Coordenada] ([IdCoordenada])
GO
ALTER TABLE [dbo].[MapaDeRutaCoordenada]  WITH CHECK ADD FOREIGN KEY([IdMapaDeRuta])
REFERENCES [dbo].[MapaDeRuta] ([IdMapaDeRuta])
GO
ALTER TABLE [dbo].[Producto]  WITH CHECK ADD FOREIGN KEY([IdCliente])
REFERENCES [dbo].[Cliente] ([IdCliente])
GO
ALTER TABLE [dbo].[ProductoEncomienda]  WITH CHECK ADD FOREIGN KEY([IdEncomienda])
REFERENCES [dbo].[Encomienda] ([IdEncomienda])
GO
ALTER TABLE [dbo].[ProductoEncomienda]  WITH CHECK ADD FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[Proveedor]  WITH CHECK ADD FOREIGN KEY([IdDireccion])
REFERENCES [dbo].[Direccion] ([IdDireccion])
GO
ALTER TABLE [dbo].[Proveedor]  WITH CHECK ADD FOREIGN KEY([IdTipoProveedor])
REFERENCES [dbo].[TipoProveedor] ([IdTipoProveedor])
GO
ALTER TABLE [dbo].[Remito]  WITH CHECK ADD FOREIGN KEY([IdEncomienda])
REFERENCES [dbo].[Encomienda] ([IdEncomienda])
GO
ALTER TABLE [dbo].[Sucursal]  WITH CHECK ADD FOREIGN KEY([IdDireccion])
REFERENCES [dbo].[Direccion] ([IdDireccion])
GO
ALTER TABLE [dbo].[TareaMantenimiento]  WITH CHECK ADD FOREIGN KEY([IdPlanMantenimiento])
REFERENCES [dbo].[PlanMantenimiento] ([IdPlanMantenimiento])
GO
ALTER TABLE [dbo].[TareaMantenimientoRealizada]  WITH CHECK ADD FOREIGN KEY([IdProveedor])
REFERENCES [dbo].[Proveedor] ([IdProveedor])
GO
ALTER TABLE [dbo].[TareaMantenimientoRealizada]  WITH CHECK ADD FOREIGN KEY([IdTareaMantenimiento])
REFERENCES [dbo].[TareaMantenimiento] ([IdTareaMantenimiento])
GO
ALTER TABLE [dbo].[TareaMantenimientoRealizada]  WITH CHECK ADD FOREIGN KEY([IdVehiculo])
REFERENCES [dbo].[Vehiculo] ([IdVehiculo])
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD FOREIGN KEY([IdRolUsuario])
REFERENCES [dbo].[RolUsuario] ([IdRolUsuario])
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD FOREIGN KEY([IdSucursal])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
ALTER TABLE [dbo].[Vehiculo]  WITH CHECK ADD FOREIGN KEY([IdPlanMantenimiento])
REFERENCES [dbo].[PlanMantenimiento] ([IdPlanMantenimiento])
GO
ALTER TABLE [dbo].[Vehiculo]  WITH CHECK ADD FOREIGN KEY([IdSucursalActual])
REFERENCES [dbo].[Sucursal] ([IdSucursal])
GO
USE [master]
GO
ALTER DATABASE [AD2016] SET  READ_WRITE 
GO
