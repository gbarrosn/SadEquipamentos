/*

select data_alteracao,date_alteracao, usuario_alteracao,
       substring(data_alteracao,1,16) as data,
	   substring(data_alteracao,23,30) as por
  from usuario

  select date_alteracao, usuario_alteracao from Usuario

*/



--UPDATE Usuario
--SET usuario_alteracao = substring(data_alteracao, 23, LEN(data_alteracao))

SELECT * FROM USUARIO

Select * into BKP_USUARIO from Usuario

UPDATE usuario
SET usuario_alteracao = substring(data_alteracao, 23, LEN(data_alteracao)),
    date_alteracao = substring(data_alteracao,1,16)


drop table bkp_usuario
