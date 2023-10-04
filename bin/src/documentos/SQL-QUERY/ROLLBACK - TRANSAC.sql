--DECLARE @TRANSACTION VARCHAR(300) = 'TRAN1413225134024' BEGIN TRAN TRAN1413225134024 INSERT INTO Usuario (nome,id_gerencia,id_cargo,id_pavimento,host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,id_marca_monitor, id_proprietario_monitor,garantia,cmtech)VALUES ('aaaaaaaaaaaaaa',4,3,5,'234234',234234,'234234',4,2,2,1,2,4,234234,'234234',2,2,1,'234234',23423);

--SELECT * from usuario where nome LIKE '%tes%';
--delete from usuario where nome = 'TESTE-TRANSACT';





--DECLARE @TRANSACTION VARCHAR(200) = 'TRAN9' 
BEGIN TRANSACTION TRAN9
SAVE TRANSACTION TRAN9
INSERT INTO Usuario (nome,id_gerencia,id_cargo,id_pavimento,host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,id_marca_monitor, id_proprietario_monitor,garantia,cmtech)
VALUES ('TESTE-9',5,1,2,'234234',234234,'234234',5,3,1,2,2,6,2344,'234234',2,1,2,'234',23434)


ROLLBACK TRANSACTION TRAN9;



--DECLARE @TRANSACTION VARCHAR(200) = 'TRAN1414002476957' BEGIN TRANSACTION TRAN1414002476957 SAVE TRANSACTION TRAN1414002476957 INSERT INTO Usuario (nome,id_gerencia,id_cargo,id_pavimento,host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,id_marca_monitor, id_proprietario_monitor,garantia,cmtech)VALUES ('23423423',4,3,4,'234234',234234,'234234',2,3,6,2,2,3,234234,'324234',3,1,2,'234234',345345)


DECLARE @TRANSACTION VARCHAR(200) = 'TRAN1414002855140' BEGIN TRANSACTION TRAN1414002855140 SAVE TRANSACTION TRAN1414002855140 INSERT INTO Usuario (nome,id_gerencia,id_cargo,id_pavimento,host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,id_marca_monitor, id_proprietario_monitor,garantia,cmtech)VALUES ('2342323423',1,1,2,'23R',234234,'23423',2,2,4,1,2,5,234324,'32423',3,2,3,'32423423',4234)
ROLLBACK TRANSACTION TRAN1414002855140
/*
select * from Modelo_Monitor;
insert into Configuracao(configuracao) values ('INTEL CORE i3 2GB');

select * from Modelo_Micro;
select * from Usuario where id_modelo_monitor=7;
*/

update usuario set notebook ='não' where notebook is null;