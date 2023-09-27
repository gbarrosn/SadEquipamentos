USE [Equipamentos]
GO

/****** Object:  View [dbo].[view_cmtech]    Script Date: 21/01/2015 15:05:41 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[view_cmtech] AS
select Pavimento.pavimento,Usuario.host_nome,Usuario.cmtech,Usuario.garantia,Usuario.tombo_micro 
from Usuario,Gerencia,Cargo,Pavimento,Configuracao,Marca_Micro,Modelo_Micro,
Plataforma,Proprietario_Micro,Sistema,Modelo_Monitor,Marca_Monitor,Proprietario_Monitor 
where usuario.id_gerencia=gerencia.id_gerencia and usuario.id_cargo=cargo.id_cargo 
and usuario.id_pavimento=pavimento.id_pavimento and usuario.id_configuracao=configuracao.id_configuracao
and usuario.id_marca_micro=marca_micro.id_marca_micro and usuario.id_modelo_micro=modelo_micro.id_modelo_micro
and usuario.id_plataforma=plataforma.id_plataforma and usuario.id_proprietario_micro=proprietario_micro.id_proprietario_micro 
and usuario.id_so=sistema.id_so and usuario.id_modelo_monitor=modelo_monitor.id_modelo_monitor and
usuario.id_marca_monitor=marca_monitor.id_marca_monitor and usuario.id_proprietario_monitor=proprietario_monitor.id_proprietario_monitor

GO

