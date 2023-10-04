select * from Usuario,Gerencia,Cargo,Pavimento,Configuracao,Marca_Micro,Modelo_Micro,Plataforma,Proprietario_Micro,Sistema,Modelo_Monitor,Marca_Monitor,Proprietario_Monitor 
where usuario.id_gerencia=gerencia.id_gerencia and usuario.id_cargo=cargo.id_cargo and usuario.id_pavimento=pavimento.id_pavimento and usuario.id_configuracao=configuracao.id_configuracao and usuario.id_marca_micro=marca_micro.id_marca_micro and usuario.id_modelo_micro=modelo_micro.id_modelo_micro and usuario.id_plataforma=plataforma.id_plataforma and usuario.id_proprietario_micro=proprietario_micro.id_proprietario_micro and usuario.id_so=sistema.id_so and usuario.id_modelo_monitor=modelo_monitor.id_modelo_monitor and usuario.id_marca_monitor=marca_monitor.id_marca_monitor and usuario.id_proprietario_monitor=proprietario_monitor.id_proprietario_monitor

and (usuario.nome LIKE '%airt%'
or usuario.host_nome LIKE '%airt%'
or usuario.tombo_micro LIKE '%airt%' 
or usuario.serie_micro LIKE '%airt%'
or usuario.tombo_monitor LIKE '%airt%' 
or usuario.serie_monitor LIKE '%airt%' 
or usuario.garantia LIKE '%airt%' 
or usuario.cmtech LIKE '%airt%'
or usuario.notebook LIKE '%airt%'
or usuario.obs LIKE '%airt%')  

order by pavimento.id_pavimento,gerencia.id_gerencia,nome