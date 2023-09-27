USE [Equipamentos]
GO

/****** Object:  Table [dbo].[Completa$]    Script Date: 21/01/2015 15:01:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Completa$](
	[id_usuario] [float] NULL,
	[nome] [varchar](50) NULL,
	[id_gerencia] [int] NULL,
	[id_cargo] [int] NULL,
	[id_pavimento] [int] NULL,
	[host_nome] [varchar](50) NULL,
	[tombo_micro] [int] NULL,
	[serie_micro] [varchar](50) NULL,
	[id_configuracao] [int] NULL,
	[id_marca_micro] [int] NULL,
	[id_modelo_micro] [int] NULL,
	[id_plataforma] [int] NULL,
	[id_proprietario_micro] [int] NULL,
	[id_so] [int] NULL,
	[tombo_monitor] [int] NULL,
	[serie_monitor] [varchar](50) NULL,
	[id_modelo_monitor] [int] NULL,
	[id_marca_monitor] [int] NULL,
	[id_proprietario_monitor] [int] NULL,
	[garantia] [varchar](50) NULL,
	[cmtech] [nvarchar](255) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

