
create view tombos_6_digitos as

select Pavimento.pavimento as 'Pavimento',Usuario.nome as 'Nome do Usuário',Usuario.host_nome as 'Host Name',Gerencia.gerencia as 'Gerência',Cargo.cargo as 'Cargo',Modelo_Micro.modelo_micro as 'Modelo do Microcomputador',Configuracao.configuracao as 'Configuração',Sistema.so as 'Sistema Operacional',Plataforma.plataforma as 'Plataforma',Usuario.tombo_micro as 'Nº de Tombo do Micro',Usuario.serie_micro as 'Nº de Série do Micro',Usuario.cmtech as 'Etiqueta CMTECH',Marca_Micro.marca_micro as 'Marca do Microcomputador',Proprietario_Micro.proprietario_micro as 'Proprietário do Micro',Usuario.garantia as 'Período de Garantia',Usuario.notebook as 'Notebook?',Modelo_Monitor.modelo_monitor as 'Modelo do Monitor',Usuario.tombo_monitor as 'Nº de Tombo do Monitor',Usuario.serie_monitor as 'Nº de Série do Monitor',Marca_Monitor.marca_monitor as 'Marca do Monitor',Proprietario_Monitor.proprietario_monitor as 'Proprietário do Monitor'
from Usuario,Gerencia,Cargo,Pavimento,Configuracao,Marca_Micro,Modelo_Micro,
Plataforma,Proprietario_Micro,Sistema,Modelo_Monitor,Marca_Monitor,Proprietario_Monitor 
where usuario.id_gerencia=gerencia.id_gerencia and usuario.id_cargo=cargo.id_cargo 
and usuario.id_pavimento=pavimento.id_pavimento and usuario.id_configuracao=configuracao.id_configuracao
and usuario.id_marca_micro=marca_micro.id_marca_micro and usuario.id_modelo_micro=modelo_micro.id_modelo_micro
and usuario.id_plataforma=plataforma.id_plataforma and usuario.id_proprietario_micro=proprietario_micro.id_proprietario_micro 
and usuario.id_so=sistema.id_so and usuario.id_modelo_monitor=modelo_monitor.id_modelo_monitor and
usuario.id_marca_monitor=marca_monitor.id_marca_monitor and usuario.id_proprietario_monitor=proprietario_monitor.id_proprietario_monitor

and len(tombo_micro)=6;

