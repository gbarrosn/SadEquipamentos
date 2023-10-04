select data_alteracao,
       substring(data_alteracao,1,16) as data,
	   substring(data_alteracao,19,30) as por
  from usuario