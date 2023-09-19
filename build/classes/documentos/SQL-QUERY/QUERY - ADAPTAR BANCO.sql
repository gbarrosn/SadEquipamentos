--UPDATES PLATAFORMA -> OK!
--INICIO
--SELECT * INTO Copia2 FROM Completa$;


/*
SELECT * FROM Plataforma;
SELECT * FROM Completa$;
--UPDATE CRUSADO
UPDATE Completa$ SET PLATAF# = 1 WHERE CONF_COMP=8;
UPDATE Completa$ SET PLATAF# = 1 WHERE CONF_COMP=9;
UPDATE Completa$ SET PLATAF# = 1 WHERE CONF_COMP=1;
UPDATE Completa$ SET PLATAF# = 1 WHERE CONF_COMP=2;
UPDATE Completa$ SET PLATAF# = 1 WHERE CONF_COMP=4;
UPDATE Completa$ SET PLATAF# = 2 WHERE CONF_COMP=3;
UPDATE Completa$ SET PLATAF# = 2 WHERE CONF_COMP=10;
UPDATE Completa$ SET PLATAF# = 2 WHERE CONF_COMP=5;
UPDATE Completa$ SET PLATAF# = 2 WHERE CONF_COMP=6;
UPDATE Completa$ SET PLATAF# = 2 WHERE CONF_COMP=7;


--FIM

--UPDATES GERENCIA (TABELA SAD) -> OK!
--INICIO

INSERT INTO Gerencia (gerencia) values('Gerência Geral de Contratos Corporativos');
SELECT * FROM GERENCIA;

SELECT * FROM Completa$;
UPDATE Completa$ SET GERENCIA = 2 WHERE GERENCIA='APOIOGAB';
UPDATE Completa$ SET GERENCIA = 3 WHERE GERENCIA='ASJUR';
UPDATE Completa$ SET GERENCIA = 4 WHERE GERENCIA='CT TELEFÔNICA';
UPDATE Completa$ SET GERENCIA = 5 WHERE GERENCIA='GABSAD';
UPDATE Completa$ SET GERENCIA = 8 WHERE GERENCIA='GEAJU';
UPDATE Completa$ SET GERENCIA = 9 WHERE GERENCIA='GGPAE/GEPAT';
UPDATE Completa$ SET GERENCIA = 10 WHERE GERENCIA='GEACI';
UPDATE Completa$ SET GERENCIA = 11 WHERE GERENCIA='GEASE';
UPDATE Completa$ SET GERENCIA = 12 WHERE GERENCIA='GECAD';
UPDATE Completa$ SET GERENCIA = 13 WHERE GERENCIA='GCOMP';
UPDATE Completa$ SET GERENCIA = 14 WHERE GERENCIA='GECEL';
UPDATE Completa$ SET GERENCIA = 15 WHERE GERENCIA='GECOM';
UPDATE Completa$ SET GERENCIA = 16 WHERE GERENCIA='GCONT';
UPDATE Completa$ SET GERENCIA = 17 WHERE GERENCIA='GEDES';
UPDATE Completa$ SET GERENCIA = 18 WHERE GERENCIA='GEDUC';
UPDATE Completa$ SET GERENCIA = 19 WHERE GERENCIA='GELIC';
UPDATE Completa$ SET GERENCIA = 20 WHERE GERENCIA='GEPAT';
UPDATE Completa$ SET GERENCIA = 24 WHERE GERENCIA='GTINF';
UPDATE Completa$ SET GERENCIA = 25 WHERE GERENCIA='GEFIP';
UPDATE Completa$ SET GERENCIA = 27 WHERE GERENCIA='GGINF';
UPDATE Completa$ SET GERENCIA = 30 WHERE GERENCIA='GGPOP';
UPDATE Completa$ SET GERENCIA = 31 WHERE GERENCIA='GGJUG';
UPDATE Completa$ SET GERENCIA = 33 WHERE GERENCIA='ALMOXARIFADO';
UPDATE Completa$ SET GERENCIA = 34 WHERE GERENCIA='UCDOC';
UPDATE Completa$ SET GERENCIA = 35 WHERE GERENCIA='UTRAN';
UPDATE Completa$ SET GERENCIA = 36 WHERE GERENCIA='COMPRAS';
UPDATE Completa$ SET GERENCIA = 37 WHERE GERENCIA='OUVIDORIA';
UPDATE Completa$ SET GERENCIA = 38 WHERE GERENCIA='RECEPÇÃO';
UPDATE Completa$ SET GERENCIA = 39 WHERE GERENCIA='SEPRI';
UPDATE Completa$ SET GERENCIA = 40 WHERE GERENCIA='SEADM';
UPDATE Completa$ SET GERENCIA = 41 WHERE GERENCIA='SELIC';
UPDATE Completa$ SET GERENCIA = 43 WHERE GERENCIA='SUMOG';
UPDATE Completa$ SET GERENCIA = 44 WHERE GERENCIA='SUTEC';
UPDATE Completa$ SET GERENCIA = 46 WHERE GERENCIA='NIERH';
UPDATE Completa$ SET GERENCIA = 47 WHERE GERENCIA='GETEP';
UPDATE Completa$ SET GERENCIA = 48 WHERE GERENCIA='GETAD';
UPDATE Completa$ SET GERENCIA = 49 WHERE GERENCIA='GGCOL';
UPDATE Completa$ SET GERENCIA = 50 WHERE GERENCIA='GESPE';
UPDATE Completa$ SET GERENCIA = 51 WHERE GERENCIA='GEMOP';
UPDATE Completa$ SET GERENCIA = 52 WHERE GERENCIA='GEJUR';
UPDATE Completa$ SET GERENCIA = 53 WHERE GERENCIA='CASA MILITAR';
UPDATE Completa$ SET GERENCIA = 54 WHERE GERENCIA='PGE';
UPDATE Completa$ SET GERENCIA = 55 WHERE GERENCIA='NUPAT';
UPDATE Completa$ SET GERENCIA = 56 WHERE GERENCIA='GPATRIMONIAL';
UPDATE Completa$ SET GERENCIA = 57 WHERE GERENCIA='Auditório';
UPDATE Completa$ SET GERENCIA = 58 WHERE GERENCIA='GGCOR';
UPDATE Completa$ SET GERENCIA = 29 WHERE GERENCIA='GGEPG';
UPDATE Completa$ SET GERENCIA = 42 WHERE GERENCIA='SUGET';
UPDATE Completa$ SET GERENCIA = 59 WHERE GERENCIA='SEDSH';
--FIM


--UPDATE PLATAFORMA (TABELA EQUIPAMENTOS)
--Update Usuario set id_plataforma = 1 where id_configuracao=1;




-- UPDATE CARGO (TABELA SAD)
--INICIO

INSERT INTO Cargo(cargo) values('Reunião de Licitação');
INSERT INTO Cargo(cargo) values('Reunião de Licitação');

SELECT * FROM Cargo;

UPDATE Completa$ SET [CARGO ] = 36 WHERE [CARGO ]='Analista de Sistemas';
UPDATE Completa$ SET [CARGO ] = 35 WHERE [CARGO ]='Analista em Gestão';
UPDATE Completa$ SET [CARGO ] = 35 WHERE [CARGO ]='Analista em Gestã o';
UPDATE Completa$ SET [CARGO ] = 3 WHERE [CARGO ]='Analista em Gestão Administrativa';
UPDATE Completa$ SET [CARGO ] = 4 WHERE [CARGO ]='Analista Organizacional';
UPDATE Completa$ SET [CARGO ] = 16 WHERE [CARGO ]='Gerente';
UPDATE Completa$ SET [CARGO ] = 6 WHERE [CARGO ]='Apoio Administrativo';
UPDATE Completa$ SET [CARGO ] = 1 WHERE [CARGO ]='Agente Administrativo';
UPDATE Completa$ SET [CARGO ] = 1 WHERE [CARGO ]='Administrativo';
UPDATE Completa$ SET [CARGO ] = 37 WHERE [CARGO ]='Analista da ATI';
UPDATE Completa$ SET [CARGO ] = 2 WHERE [CARGO ]='Analista de Sistemas da ATI';
UPDATE Completa$ SET [CARGO ] = 38 WHERE [CARGO ]='Apoio';
UPDATE Completa$ SET [CARGO ] = 5 WHERE [CARGO ]='Apoio a OUVIDORIA';
UPDATE Completa$ SET [CARGO ] = 6 WHERE [CARGO ]='Apoio Administrativo';
UPDATE Completa$ SET [CARGO ] = 39 WHERE [CARGO ]='Apoio ao Transporte';
UPDATE Completa$ SET [CARGO ] = 7 WHERE [CARGO ]='Apoio ao Gabinete';
UPDATE Completa$ SET [CARGO ] = 7 WHERE [CARGO ]='Apoio Gabinete';
UPDATE Completa$ SET [CARGO ] = 8 WHERE [CARGO ]='Assessor Jurídico';
UPDATE Completa$ SET [CARGO ] = 9 WHERE [CARGO ]='Assessoria';
UPDATE Completa$ SET [CARGO ] = 10 WHERE [CARGO ]='Atendimento 01';
UPDATE Completa$ SET [CARGO ] = 10 WHERE [CARGO ]='Atendimento 02';
UPDATE Completa$ SET [CARGO ] = 10 WHERE [CARGO ]='Atendimento 03';
UPDATE Completa$ SET [CARGO ] = 10 WHERE [CARGO ]='Atendimento 04';
UPDATE Completa$ SET [CARGO ] = 10 WHERE [CARGO ]='Atendimento 05';
UPDATE Completa$ SET [CARGO ] = 10 WHERE [CARGO ]='Atendimento 06';
UPDATE Completa$ SET [CARGO ] = 11 WHERE [CARGO ]='Atendimento OCSAD';
UPDATE Completa$ SET [CARGO ] = 12 WHERE [CARGO ]='Cargo Comissionado';
UPDATE Completa$ SET [CARGO ] = 12 WHERE [CARGO ]='Comissionado';
UPDATE Completa$ SET [CARGO ] = 40 WHERE [CARGO ]='Chefe de Unidade';
UPDATE Completa$ SET [CARGO ] = 14 WHERE [CARGO ]='Digitalização TCI';
UPDATE Completa$ SET [CARGO ] = 15 WHERE [CARGO ]='Estagiário';
UPDATE Completa$ SET [CARGO ] = 15 WHERE [CARGO ]='Estagiario';
UPDATE Completa$ SET [CARGO ] = 15 WHERE [CARGO ]='Estagiária';
UPDATE Completa$ SET [CARGO ] = 15 WHERE [CARGO ]='Estagiaria';
UPDATE Completa$ SET [CARGO ] = 16 WHERE [CARGO ]='Gerente';
UPDATE Completa$ SET [CARGO ] = 17 WHERE [CARGO ]='Gerente Geral';
UPDATE Completa$ SET [CARGO ] = 18 WHERE [CARGO ]='Gestor de Núcleo';
UPDATE Completa$ SET [CARGO ] = 19 WHERE [CARGO ]='Gestor de Obras';
UPDATE Completa$ SET [CARGO ] = 41 WHERE [CARGO ]='Membro de Comissão';
UPDATE Completa$ SET [CARGO ] = 20 WHERE [CARGO ]='Ouvidora da SAD';
UPDATE Completa$ SET [CARGO ] = 21 WHERE [CARGO ]='Pregoeiro';
UPDATE Completa$ SET [CARGO ] = 22 WHERE [CARGO ]='Recepcionista';
UPDATE Completa$ SET [CARGO ] = 23 WHERE [CARGO ]='Sargento';
UPDATE Completa$ SET [CARGO ] = 24 WHERE [CARGO ]='Secretária';
UPDATE Completa$ SET [CARGO ] = 42 WHERE [CARGO ]='Secretária da Gerencia';
UPDATE Completa$ SET [CARGO ] = 25 WHERE [CARGO ]='Secretário de Estado';
UPDATE Completa$ SET [CARGO ] = 30 WHERE [CARGO ]='Superintendente Técnico';
UPDATE Completa$ SET [CARGO ] = 31 WHERE [CARGO ]='Suporte Técnico';
UPDATE Completa$ SET [CARGO ] = 32 WHERE [CARGO ]='Tecnico Terceirizado';
UPDATE Completa$ SET [CARGO ] = 33 WHERE [CARGO ]='Tenente';
UPDATE Completa$ SET [CARGO ] = 34 WHERE [CARGO ]='Vago';
UPDATE Completa$ SET [CARGO ] = 34 WHERE [CARGO ]='Vago(INES)';
UPDATE Completa$ SET [CARGO ] = 44 WHERE [CARGO ]='Secretário Executivo';
------------------
INSERT INTO Cargo(cargo) values('Gerência');
INSERT INTO Cargo(cargo) values('Chefe de Gabinete');
INSERT INTO Cargo(cargo) values('Secretária Executiva');
INSERT INTO Cargo(cargo) values('Servidor de PROXY');
INSERT INTO Cargo(cargo) values('Analista de Suporte');
-----------------------
UPDATE Completa$ SET [CARGO ] = 47 WHERE [CARGO ]='Gerência';
UPDATE Completa$ SET [CARGO ] = 47 WHERE [CARGO ]='Gerêndia';
UPDATE Completa$ SET [CARGO ] = 48 WHERE [CARGO ]='Chefe de Gabinete';
UPDATE Completa$ SET [CARGO ] = 49 WHERE [CARGO ]='Secretária Executiva';
UPDATE Completa$ SET [CARGO ] = 50 WHERE [CARGO ]='Servidor de PROXY';
UPDATE Completa$ SET [CARGO ] = 51 WHERE [CARGO ]='Analista de Suporte';
UPDATE Completa$ SET [CARGO ] = 1 WHERE [CARGO ]='Agente Aministrativo';
UPDATE Completa$ SET [CARGO ] = 15 WHERE [CARGO ]='Estagiaria';
UPDATE Completa$ SET [CARGO ] = 35 WHERE NOME='Viviane Araújo';
--FIM

-- UPDATE PAVIMENTO (TABELA SAD)
--INICIO

--?
--PGE - PROCURADORIA GERAL DO ESTADO
--SDSH - SECRETARIA DE DESENVOLVIMENTO SOCIAL E RECURSOS HIDRICOS

INSERT INTO Pavimento(pavimento) VALUES ('SDSH');
SELECT * FROM Pavimento;
DELETE FROM Pavimento WHERE id_pavimento=16;

UPDATE Completa$ SET [PAVIMEN TO] = 1 WHERE [PAVIMEN TO]='1º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 2 WHERE [PAVIMEN TO]='2º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 3 WHERE [PAVIMEN TO]='3º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 4 WHERE [PAVIMEN TO]='4º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 5 WHERE [PAVIMEN TO]='5º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 6 WHERE [PAVIMEN TO]='6º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 7 WHERE [PAVIMEN TO]='7º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 8 WHERE [PAVIMEN TO]='8º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 9 WHERE [PAVIMEN TO]='9º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 10 WHERE [PAVIMEN TO]='10º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 11 WHERE [PAVIMEN TO]='11º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 12 WHERE [PAVIMEN TO]='12º ANDAR';
UPDATE Completa$ SET [PAVIMEN TO] = 13 WHERE [PAVIMEN TO]='TERREO';
UPDATE Completa$ SET [PAVIMEN TO] = 14 WHERE [PAVIMEN TO]='SEMIENTERRADO';
UPDATE Completa$ SET [PAVIMEN TO] = 15 WHERE [PAVIMEN TO]='CEFOSPE';
UPDATE Completa$ SET [PAVIMEN TO] = 17 WHERE [PAVIMEN TO]='CASA MILITAR';
UPDATE Completa$ SET [PAVIMEN TO] = 18 WHERE [PAVIMEN TO]='PGE';
UPDATE Completa$ SET [PAVIMEN TO] = 19 WHERE [PAVIMEN TO]='SDSH';
--FIM

--UPDATE CONFIGURAÇÃO:
select * from Completa$;
select * from Configuracao
INSERT INTO Configuracao(configuracao) VALUES ('INTEL CORE i3 4GB');
UPDATE Completa$ SET CONF_COMP = 8 WHERE CONF_COMP='PENTIUM IV 1.0GB';
UPDATE Completa$ SET CONF_COMP = 9 WHERE CONF_COMP='PENTIUM IV 2.0GB';
UPDATE Completa$ SET CONF_COMP = 1 WHERE CONF_COMP='AMD ATHLON 1GB';
UPDATE Completa$ SET CONF_COMP = 2 WHERE CONF_COMP='AMD ATHLON 2GB';
UPDATE Completa$ SET CONF_COMP = 7 WHERE CONF_COMP='INTEL CORE I5 4GB';
UPDATE Completa$ SET CONF_COMP = 6 WHERE CONF_COMP='AMD ATHLON 8GB';
UPDATE Completa$ SET CONF_COMP = 5 WHERE CONF_COMP='AMD ATHLON 6GB';
UPDATE Completa$ SET CONF_COMP = 3 WHERE CONF_COMP='AMD ATHLON 4GB';
UPDATE Completa$ SET CONF_COMP = 4 WHERE CONF_COMP='AMD ATHLON 512MB';
UPDATE Completa$ SET CONF_COMP = 10 WHERE CONF_COMP='INTEL CORE i3 4GB';
--FIM

--UPDATE MODELO MICRO
INSERT INTO Modelo_Micro(modelo_micro) VALUES ('COMPAQ');
select * from Modelo_Micro;
UPDATE Completa$ SET MODELO = 6 WHERE MODELO='HP 6005';
UPDATE Completa$ SET MODELO = 6 WHERE MODELO='HP6005';
UPDATE Completa$ SET MODELO = 6 WHERE MODELO='HP 19';
UPDATE Completa$ SET MODELO = 1 WHERE MODELO='HD';
UPDATE Completa$ SET MODELO = 2 WHERE MODELO='HP 5750';
UPDATE Completa$ SET MODELO = 5 WHERE MODELO='NOTEBOOK DELL ';
UPDATE Completa$ SET MODELO = 9 WHERE MODELO='NOTEBOOK POSITIVO';
UPDATE Completa$ SET MODELO = 9 WHERE MODELO='POSITIVO';
UPDATE Completa$ SET MODELO = 11 WHERE MODELO='TCI';
UPDATE Completa$ SET MODELO = 12 WHERE MODELO='COMPAQ';
UPDATE Completa$ SET MODELO = 7 WHERE CONF_COMP=5;
UPDATE Completa$ SET MODELO = 7 WHERE CONF_COMP=6;
--FIM

--UPDATE MODELO MONITOR
INSERT INTO Modelo_Monitor(modelo_monitor) VALUES ('HP 15"');
select * from Completa$;
UPDATE Completa$ SET MOD_MONITOR =1 WHERE MOD_MONITOR = 'DELL 23"';
UPDATE Completa$ SET MOD_MONITOR =5 WHERE MOD_MONITOR = 'DELL 15"';
UPDATE Completa$ SET MOD_MONITOR =3 WHERE MOD_MONITOR = 'HP 19"';
UPDATE Completa$ SET MOD_MONITOR =8 WHERE MOD_MONITOR = 'HP 15"';
UPDATE Completa$ SET MOD_MONITOR =6 WHERE MOD_MONITOR = 'POSITIVO 14"';
UPDATE Completa$ SET MOD_MONITOR =7 WHERE MOD_MONITOR = 'HP 17"';
UPDATE Completa$ SET MOD_MONITOR =3 WHERE MOD_MONITOR = 'SAMSUNG 18,5"';
UPDATE Completa$ SET MOD_MONITOR =2 WHERE MOD_MONITOR = 'HP 20"';
--FIM

--update proprietario
select * from Proprietario_Micro
select * from Completa$
insert into Proprietario_Micro(proprietario_micro) values ('TCI');

UPDATE Completa$ SET PROPRIETARIO=1 WHERE PROPRIETARIO='SAD';
UPDATE Completa$ SET PROPRIETARIO=2 WHERE PROPRIETARIO='SAD/DELL';
UPDATE Completa$ SET PROPRIETARIO=3 WHERE PROPRIETARIO='PNAGE';
UPDATE Completa$ SET PROPRIETARIO=4 WHERE PROPRIETARIO='DELL';
UPDATE Completa$ SET PROPRIETARIO=5 WHERE PROPRIETARIO='TCI';
--FIM

--UPDATE MODELO MONITOR
select * from Modelo_Monitor;
select * from Completa$; select * from Modelo_Monitor;
insert into Modelo_Monitor(modelo_monitor) values ('SAMSUNG 18,5"');

UPDATE Completa$ SET MOD_MONITOR=1 WHERE MOD_MONITOR='DELL 23"';
UPDATE Completa$ SET MOD_MONITOR=2 WHERE MOD_MONITOR='HP 20"';
UPDATE Completa$ SET MOD_MONITOR=3 WHERE MOD_MONITOR='HP 18"';
UPDATE Completa$ SET MOD_MONITOR=4 WHERE MOD_MONITOR='LENOVO';
UPDATE Completa$ SET MOD_MONITOR=5 WHERE MOD_MONITOR='DELL 19"';
UPDATE Completa$ SET MOD_MONITOR=6 WHERE MOD_MONITOR='POSITIVO 14"';
UPDATE Completa$ SET MOD_MONITOR=7 WHERE MOD_MONITOR='HP 17';
UPDATE Completa$ SET MOD_MONITOR=7 WHERE SERIE_MONITOR='BRG814P50K';
UPDATE Completa$ SET MOD_MONITOR=8 WHERE MOD_MONITOR='HP 15"';
UPDATE Completa$ SET MOD_MONITOR=10 WHERE MOD_MONITOR='COMPAQ 14"';
UPDATE Completa$ SET MOD_MONITOR=11 WHERE SERIE_MONITOR='BRG003FG20';
--UPDATE Completa$ SET MOD_MONITOR=6 WHERE MOD_MONITOR='DELL 23"';

--update proprietario monitor
select * from Proprietario_Micro
select * from Completa$
insert into Proprietario_Monitor(proprietario_monitor) values ('TCI');

UPDATE Completa$ SET PROP_MONITOR=1 WHERE PROP_MONITOR='SAD';
UPDATE Completa$ SET PROP_MONITOR=2 WHERE PROP_MONITOR='SAD/DELL';
UPDATE Completa$ SET PROP_MONITOR=3 WHERE PROP_MONITOR='PNAGE';
UPDATE Completa$ SET PROP_MONITOR=4 WHERE PROP_MONITOR='DELL';
UPDATE Completa$ SET PROP_MONITOR=5 WHERE PROP_MONITOR='TCI';
--FIM

--UPDATE SISTEMA OP
select * from Sistema;

UPDATE Completa$ SET sistema=4 WHERE PLATAF#=PLATAF#;
UPDATE Completa$ SET sistema=2 WHERE MODELO=5;
UPDATE Completa$ SET sistema=2 WHERE modelo=9;


--select * from Completa$
UPDATE Completa$ SET tombo_micro=01373 where tombo_micro='013.73';
UPDATE Completa$ SET tombo_micro=162533 where tombo_micro='162.533';
UPDATE Completa$ SET tombo_micro=165769 where tombo_micro='165.769';
UPDATE Completa$ SET tombo_micro=165822 where tombo_micro='165.822';
UPDATE Completa$ SET tombo_micro=165754 where tombo_micro='165.754';
UPDATE Completa$ SET tombo_micro=165798 where tombo_micro='165.798';
UPDATE Completa$ SET tombo_micro=165793 where tombo_micro='165.793';
UPDATE Completa$ SET tombo_micro=165795 where tombo_micro='165.795';
UPDATE Completa$ SET tombo_micro=165791 where tombo_micro='165.791';
UPDATE Completa$ SET tombo_micro=165808 where tombo_micro='165.808';
UPDATE Completa$ SET tombo_micro=165987 where tombo_micro='165.987';
UPDATE Completa$ SET tombo_micro=165805 where tombo_micro='165.805';
UPDATE Completa$ SET tombo_micro=165988 where tombo_micro='165.988';
UPDATE Completa$ SET tombo_micro=165802 where tombo_micro='165.802';
UPDATE Completa$ SET tombo_micro=07812 where tombo_micro='078.12';
UPDATE Completa$ SET tombo_micro=162533 where tombo_micro='162.533';
UPDATE Completa$ SET tombo_micro=165769 where tombo_micro='165.769';
UPDATE Completa$ SET tombo_micro=165822 where tombo_micro='165.822';
UPDATE Completa$ SET tombo_micro=165754 where tombo_micro='165.754';
UPDATE Completa$ SET tombo_micro=165798 where tombo_micro='165.798';
UPDATE Completa$ SET tombo_micro=165793 where tombo_micro='165.793';
UPDATE Completa$ SET tombo_micro=165795 where tombo_micro='165.795';
UPDATE Completa$ SET tombo_micro=165791 where tombo_micro='165.791';
UPDATE Completa$ SET tombo_micro=165808 where tombo_micro='165.808';
UPDATE Completa$ SET tombo_micro=165987 where tombo_micro='165.987';
UPDATE Completa$ SET tombo_micro=165805 where tombo_micro='165.805';
UPDATE Completa$ SET tombo_micro=165988 where tombo_micro='165.988';
UPDATE Completa$ SET tombo_micro=165802 where tombo_micro='165.802';
UPDATE Completa$ SET tombo_micro=165828 where tombo_micro='165.828';
UPDATE Completa$ SET tombo_micro=165829 where tombo_micro='165.829';
UPDATE Completa$ SET tombo_micro=165826 where tombo_micro='165.826';
UPDATE Completa$ SET tombo_micro=0 where tombo_micro='HP 19"';
UPDATE Completa$ SET tombo_micro=165868 where tombo_micro='165.868';
UPDATE Completa$ SET tombo_micro=165752 where tombo_micro='165.752';
UPDATE Completa$ SET tombo_micro=162537 where tombo_micro=' 162537';
UPDATE Completa$ SET tombo_micro=0 where tombo_micro='9FS70Y1';
UPDATE Completa$ SET tombo_micro=165827 where tombo_micro='165.827';
UPDATE Completa$ SET tombo_micro=162537 where tombo_micro=' 162537';
UPDATE Completa$ SET tombo_micro=0 where tombo_micro='9FS70Y1';
UPDATE Completa$ SET tombo_micro=165827 where tombo_micro='165.827';
UPDATE Completa$ SET tombo_micro=165828 where tombo_micro='165.828';
UPDATE Completa$ SET tombo_micro=165829 where tombo_micro='165.829';
UPDATE Completa$ SET tombo_micro=165826 where tombo_micro='165.826';
UPDATE Completa$ SET tombo_micro=165752 where tombo_micro='165.752';
UPDATE Completa$ SET tombo_micro=0 where tombo_micro='';

UPDATE Completa$ SET tombo_micro=0 where tombo_micro IS NULL;


UPDATE Completa$ SET tombo_monitor=0 WHERE tombo_monitor IS NULL;
UPDATE Completa$ SET tombo_monitor=0 WHERE tombo_monitor='';
UPDATE Completa$ SET tombo_monitor=165856 WHERE tombo_monitor='165.856';
UPDATE Completa$ SET tombo_monitor=162508 WHERE tombo_monitor='162.508';
UPDATE Completa$ SET tombo_monitor=165861 WHERE tombo_monitor='165.861';
UPDATE Completa$ SET tombo_monitor=0 WHERE tombo_monitor=' NOTE';
UPDATE Completa$ SET tombo_monitor=165866 WHERE tombo_monitor='165.866';
UPDATE Completa$ SET tombo_monitor=165928 WHERE tombo_monitor='165.928';
UPDATE Completa$ SET tombo_monitor=07993 WHERE tombo_monitor='079.93';
UPDATE Completa$ SET tombo_monitor=05547 WHERE tombo_monitor='055.47';
UPDATE Completa$ SET tombo_monitor=07993 WHERE tombo_monitor='079.93';
UPDATE Completa$ SET tombo_monitor=165875 WHERE tombo_monitor='165.875';
UPDATE Completa$ SET tombo_monitor=165854 WHERE tombo_monitor='165.854';
UPDATE Completa$ SET tombo_monitor=165876 WHERE tombo_monitor='165.876';
UPDATE Completa$ SET tombo_monitor=165874 WHERE tombo_monitor='165.874';
UPDATE Completa$ SET tombo_monitor=165871 WHERE tombo_monitor='165.871';
UPDATE Completa$ SET tombo_monitor=165859 WHERE tombo_monitor='165.859';
UPDATE Completa$ SET tombo_monitor=165872 WHERE tombo_monitor='165.872';
UPDATE Completa$ SET tombo_monitor=165853 WHERE tombo_monitor='165.853';
UPDATE Completa$ SET tombo_monitor=165936 WHERE tombo_monitor='165.936';
UPDATE Completa$ SET tombo_monitor=165873 WHERE tombo_monitor='165.873';
UPDATE Completa$ SET tombo_monitor=165877 WHERE tombo_monitor='165.877';
UPDATE Completa$ SET tombo_monitor=165927 WHERE tombo_monitor='165.927';
UPDATE Completa$ SET tombo_monitor=165867 WHERE tombo_monitor='165.867';
UPDATE Completa$ SET tombo_monitor=165863 WHERE tombo_monitor='165.863';
UPDATE Completa$ SET tombo_monitor=165856 WHERE tombo_monitor='165.856';
UPDATE Completa$ SET tombo_monitor=162508 WHERE tombo_monitor='162.508';
UPDATE Completa$ SET tombo_monitor=165861 WHERE tombo_monitor='165.861';
UPDATE Completa$ SET tombo_monitor=165866 WHERE tombo_monitor='165.866';
UPDATE Completa$ SET tombo_monitor=165928 WHERE tombo_monitor='165.928';
UPDATE Completa$ SET tombo_monitor=07993 WHERE tombo_monitor='079.93';
UPDATE Completa$ SET tombo_monitor=05547 WHERE tombo_monitor='055.47';
UPDATE Completa$ SET tombo_monitor=07993 WHERE tombo_monitor='079.93';
UPDATE Completa$ SET tombo_monitor=165875 WHERE tombo_monitor='165.875';
UPDATE Completa$ SET tombo_monitor=165854 WHERE tombo_monitor='165.854';
UPDATE Completa$ SET tombo_monitor=165876 WHERE tombo_monitor='165.876';
UPDATE Completa$ SET tombo_monitor=165874 WHERE tombo_monitor='165.874';
UPDATE Completa$ SET tombo_monitor=165871 WHERE tombo_monitor='165.871';
UPDATE Completa$ SET tombo_monitor=165859 WHERE tombo_monitor='165.859';
UPDATE Completa$ SET tombo_monitor=165872 WHERE tombo_monitor='165.872';
UPDATE Completa$ SET tombo_monitor=165936 WHERE tombo_monitor='165.936';
UPDATE Completa$ SET tombo_monitor=165873 WHERE tombo_monitor='165.873';
UPDATE Completa$ SET tombo_monitor=165877 WHERE tombo_monitor='165.877';
UPDATE Completa$ SET tombo_monitor=165927 WHERE tombo_monitor='165.927';
UPDATE Completa$ SET tombo_monitor=165867 WHERE tombo_monitor='165.867';
UPDATE Completa$ SET tombo_monitor=165863 WHERE tombo_monitor='165.863';
UPDATE Completa$ SET tombo_monitor=165848 WHERE tombo_monitor='165.848';
UPDATE Completa$ SET tombo_monitor=165847 WHERE tombo_monitor='165.847';
UPDATE Completa$ SET tombo_monitor=165850 WHERE tombo_monitor='165.850';
UPDATE Completa$ SET tombo_monitor=165868 WHERE tombo_monitor='165.868';
UPDATE Completa$ SET tombo_monitor=165862 WHERE tombo_monitor='165.862';
UPDATE Completa$ SET tombo_monitor=0 WHERE tombo_monitor='S/T';
UPDATE Completa$ SET tombo_monitor=165870 WHERE tombo_monitor='165.870';
UPDATE Completa$ SET tombo_monitor=165871 WHERE tombo_monitor='165.871';
UPDATE Completa$ SET tombo_monitor=165869 WHERE tombo_monitor='165.869';
UPDATE Completa$ SET tombo_monitor=165849 WHERE tombo_monitor='165.849';
UPDATE Completa$ SET tombo_monitor=07915 WHERE tombo_monitor=' 07915';
UPDATE Completa$ SET tombo_monitor=165849 WHERE tombo_monitor='165.849';
UPDATE Completa$ SET tombo_monitor=165849 WHERE tombo_monitor='165.849';
UPDATE Completa$ SET tombo_monitor=165848 WHERE tombo_monitor='165.848';
UPDATE Completa$ SET tombo_monitor=165847 WHERE tombo_monitor='165.847';
UPDATE Completa$ SET tombo_monitor=165850 WHERE tombo_monitor='165.850';
UPDATE Completa$ SET tombo_monitor=165868 WHERE tombo_monitor='165.868';
UPDATE Completa$ SET tombo_monitor=165862 WHERE tombo_monitor='165.862';
UPDATE Completa$ SET tombo_monitor=165870 WHERE tombo_monitor='165.870';
UPDATE Completa$ SET tombo_monitor=165871 WHERE tombo_monitor='165.871';
UPDATE Completa$ SET tombo_monitor=165869 WHERE tombo_monitor='165.869';
UPDATE Completa$ SET tombo_monitor=165849 WHERE tombo_monitor='165.849';


SELECT * INTO Copia22102014 FROM uSUARIO;



SELECT  ORD, COUNT(ORD) nr
FROM    Completa$
GROUP BY ORD
HAVING  COUNT(ORD) > 1

select * from Completa$

 
SET NOCOUNT ON
SET ROWCOUNT 1
WHILE 1 = 1
   BEGIN
      DELETE  FROM Completa$
      WHERE  ORD IN (SELECT  ORD
                               FROM    Completa$
                               GROUP BY ORD
                               HAVING  COUNT(*) > 1)
      IF @@Rowcount = 0
         BREAK ;
   END
SET ROWCOUNT 0



--set marca micro

select * from Marca_Micro;
select * from Modelo_Micro;
--insert into Marca_Micro (marca_micro) values ('GENÉRICO');

UPDATE Completa$ SET id_marca_micro=1 WHERE id_modelo_micro=1 or id_modelo_micro=2 or id_modelo_micro=4 or id_modelo_micro=6 or id_modelo_micro=7 or id_modelo_micro=12;
UPDATE Completa$ SET id_marca_micro=2 WHERE id_modelo_micro=5 or id_modelo_micro=8;

--SET MARCA MONITOR

--set garantia

UPDATE Completa$ SET garantia='Não Informado' where nome=nome;
--fim



select * from Marca_Monitor;
select * from Modelo_Monitor;

insert into Marca_Monitor(marca_monitor) values ('Samsung');

UPDATE Completa$ SET id_marca_monitor=1 WHERE id_modelo_monitor=1 or id_modelo_monitor=5;
UPDATE Completa$ SET id_marca_monitor=2 WHERE id_modelo_monitor=3 or id_modelo_monitor=3 or id_modelo_monitor=7 or id_modelo_monitor=8 or id_modelo_monitor=9;
UPDATE Completa$ SET id_marca_monitor=3 WHERE id_modelo_monitor=4;
UPDATE Completa$ SET id_marca_monitor=4 WHERE id_modelo_monitor=6;
UPDATE Completa$ SET id_marca_monitor=5 WHERE id_modelo_monitor=11;

--set valores vazios

UPDATE Completa$ SET cmtech=000 WHERE cmtech='';
*/

--select * from Completa$

--SELECT * INTO Copia4 FROM Completa$;
--try
-----INSERT INTO Usuario (nome,id_gerencia,id_cargo,id_pavimento,host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,id_marca_monitor, id_proprietario_monitor,garantia,cmtech)
-----SELECT nome,id_gerencia,id_cargo,id_pavimento,host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,id_marca_monitor, id_proprietario_monitor,garantia,cmtech FROM Completa$;

--select * from Usuario

--UPDATE Completa$ SET cmtech=0 where cmtech='HP 6005';

--removendo NULL e vazio
/*
insert into Gerencia (gerencia) values ('Não Informado');
select * from Gerencia;
update Completa$ set id_gerencia=62 where id_gerencia='';
update Completa$ set id_gerencia=62 where id_gerencia is null;

insert into Cargo(cargo) values ('Não Informado');
select * from Cargo;
update Completa$ set id_cargo=61 where id_cargo='';
update Completa$ set id_cargo=61 where id_cargo is null;

insert into Pavimento(pavimento) values ('Não Informado');
select * from Pavimento;
update Completa$ set id_pavimento=21 where id_pavimento='';
update Completa$ set id_pavimento=21 where id_pavimento is null;

insert into Configuracao(configuracao) values ('Não Informado');
select * from Configuracao;
update Completa$ set id_configuracao=12 where id_configuracao='';
update Completa$ set id_configuracao=12 where id_configuracao is null;

insert into Marca_Micro (marca_micro) values ('Não Informado');
select * from Marca_Micro;
update Completa$ set id_marca_micro=10 where id_marca_micro='';
update Completa$ set id_marca_micro=10 where id_marca_micro is null;

insert into Modelo_Micro(modelo_micro) values ('Não Informado');
select * from Modelo_Micro;
update Completa$ set id_modelo_micro=14 where id_modelo_micro='';
update Completa$ set id_modelo_micro=14 where id_modelo_micro is null;

insert into Plataforma(plataforma) values ('Não Informado');
select * from Plataforma;
update Completa$ set id_plataforma=3 where id_plataforma='';
update Completa$ set id_plataforma=3 where id_plataforma is null;

insert into Proprietario_Micro(proprietario_micro) values ('Não Informado');
select * from Proprietario_Micro;
update Completa$ set id_proprietario_micro=7 where id_proprietario_micro='';
update Completa$ set id_proprietario_micro=7 where id_proprietario_micro is null;

insert into Sistema(so) values ('Não Informado');
select * from Sistema;
update Completa$ set id_so=9 where id_so='';
update Completa$ set id_so=9 where id_so is null;

insert into Modelo_Monitor(modelo_monitor) values ('Não Informado');
select * from Modelo_Monitor
update Completa$ set id_modelo_monitor=12 where id_modelo_monitor=14;
update Completa$ set id_modelo_monitor=14 where id_modelo_monitor is null;

insert into Marca_Monitor(marca_monitor) values ('Não Informado');
select * from Marca_Monitor;
update Completa$ set id_marca_monitor=6 where id_marca_monitor=10;
update Completa$ set id_marca_monitor=6 where id_marca_monitor=10;

insert into Proprietario_Monitor(proprietario_monitor) values ('Não Informado');
select * from Proprietario_Monitor
update Completa$ set id_proprietario_monitor=5 where id_proprietario_monitor='';
update Completa$ set id_proprietario_monitor=5 where id_proprietario_monitor is null;
*/
--ppp
--update Completa$ set cmtech=0 where cmtech='';
--update Completa$ set cmtech=0 where cmtech is null;

--select * from Completa$;
--update Completa$ set serie_micro='Não informado' where serie_micro='';

--INSERT INTO Usuario (nome,id_gerencia,id_cargo,id_pavimento,host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,id_marca_monitor, id_proprietario_monitor,garantia,cmtech)
--SELECT nome,id_gerencia,id_cargo,id_pavimento,host_nome,tombo_micro,serie_micro,id_configuracao,id_marca_micro,id_modelo_micro,id_plataforma,id_proprietario_micro,id_so,tombo_monitor,serie_monitor,id_modelo_monitor,id_marca_monitor, id_proprietario_monitor,garantia,cmtech FROM Completa$;

--select * from Marca_Monitor;
--select * from Completa$;

SELECT * INTO Copia22102014 FROM Usuario;