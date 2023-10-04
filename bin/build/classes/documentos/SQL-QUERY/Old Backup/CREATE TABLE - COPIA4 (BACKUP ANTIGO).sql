--SCRIPT COPIA4

CREATE DATABASE Equipamentos;
GO
USE Equipamentos;

CREATE TABLE Usuario (id_usuario integer IDENTITY(1,1) CONSTRAINT PK_id_usuario PRIMARY KEY,
						nome VARCHAR(50) not null,
						id_gerencia integer,
						id_cargo integer,
						id_pavimento integer,
						host_nome VARCHAR (50) not null,
						tombo_micro integer,
						serie_micro VARCHAR (50) not null,
						id_configuracao integer,
						id_marca_micro integer,
						id_modelo_micro integer,
						id_plataforma integer,
						id_proprietario_micro integer,
						id_so integer,
						tombo_monitor integer,
						serie_monitor VARCHAR(50) not null,
						id_modelo_monitor integer,
						id_marca_monitor integer,
						id_proprietario_monitor integer,
						garantia VARCHAR(50)
						cmtech INTEGER);


CREATE TABLE Plataforma (id_plataforma integer IDENTITY(1,1)CONSTRAINT PK_id_plataforma PRIMARY KEY,
						 plataforma varchar(50) not null);

CREATE TABLE Gerencia (id_gerencia integer IDENTITY(1,1)CONSTRAINT PK_id_gerencia PRIMARY KEY,
					   gerencia varchar(50) not null);

CREATE TABLE Cargo (id_cargo integer IDENTITY(1,1)CONSTRAINT PK_id_cargo PRIMARY KEY,
					cargo varchar(50) not null);

CREATE TABLE Pavimento (id_pavimento integer IDENTITY(1,1)CONSTRAINT PK_id_pavimento PRIMARY KEY,
						pavimento varchar(50) not null);

CREATE TABLE Marca_Micro (id_marca_micro integer IDENTITY(1,1)CONSTRAINT PK_id_marca_micro PRIMARY KEY,
						  marca_micro varchar(50) not null);

CREATE TABLE Configuracao (id_configuracao integer IDENTITY(1,1)CONSTRAINT PK_id_configuração PRIMARY KEY,
						   configuracao varchar(50) not null);

CREATE TABLE Modelo_Micro (id_modelo_micro integer IDENTITY(1,1)CONSTRAINT PK_id_modelo_micro PRIMARY KEY,
						   modelo_micro varchar(50) not null);

CREATE TABLE Sistema (id_so integer IDENTITY(1,1)CONSTRAINT PK_id_so PRIMARY KEY,
					  so varchar(50) not null);

CREATE TABLE Proprietario_Micro (id_proprietario_micro integer IDENTITY(1,1)CONSTRAINT PK_id_proprietario_micro PRIMARY KEY,
								 proprietario_micro varchar(50) not null);

CREATE TABLE Proprietario_Monitor (id_proprietario_monitor integer IDENTITY(1,1)CONSTRAINT PK_id_proprietario_monitor PRIMARY KEY,
								   proprietario_monitor varchar(50) not null);

CREATE TABLE Marca_Monitor (id_marca_monitor integer IDENTITY(1,1)CONSTRAINT PK_id_marca_monitor PRIMARY KEY,
							marca_monitor varchar(50) not null);

CREATE TABLE Modelo_Monitor (id_modelo_monitor integer IDENTITY(1,1)CONSTRAINT PK_id_modelo_monitor PRIMARY KEY,
							modelo_monitor varchar(50) not null);

CREATE TABLE Obs (id_obs integer IDENTITY(1,1)CONSTRAINT PK_id_obs PRIMARY KEY,
				  id_usuario  integer,
				  obs VARCHAR (200) not null,
				  data_obs VARCHAR (70) not null
				  nome_usuario VARCHAR(50));


ALTER TABLE Obs ADD CONSTRAINT FK_id_usuario FOREIGN KEY(id_usuario)REFERENCES Usuario (id_usuario);
ALTER TABLE Usuario ADD CONSTRAINT FK_Plataforma FOREIGN KEY(id_plataforma)REFERENCES Plataforma (id_plataforma);
ALTER TABLE Usuario ADD CONSTRAINT FK_Gerencia FOREIGN KEY(id_gerencia)REFERENCES Gerencia (id_gerencia);
ALTER TABLE Usuario ADD CONSTRAINT FK_Cargo FOREIGN KEY(id_cargo)REFERENCES Cargo (id_cargo);
ALTER TABLE Usuario ADD CONSTRAINT FK_Pavimento FOREIGN KEY(id_pavimento)REFERENCES Pavimento (id_pavimento);
ALTER TABLE Usuario ADD CONSTRAINT FK_Marca_Micro FOREIGN KEY(id_marca_micro)REFERENCES Marca_Micro (id_marca_micro);
ALTER TABLE Usuario ADD CONSTRAINT FK_Configuracao FOREIGN KEY(id_configuracao)REFERENCES Configuracao (id_configuracao);
ALTER TABLE Usuario ADD CONSTRAINT FK_Modelo_Micro FOREIGN KEY(id_modelo_micro)REFERENCES Modelo_Micro (id_modelo_micro);
ALTER TABLE Usuario ADD CONSTRAINT FK_Sistema FOREIGN KEY(id_so)REFERENCES Sistema (id_so);
ALTER TABLE Usuario ADD CONSTRAINT FK_Proprietario_Micro FOREIGN KEY(id_proprietario_micro)REFERENCES Proprietario_Micro (id_proprietario_micro);
ALTER TABLE Usuario ADD CONSTRAINT FK_Proprietario_Monitor FOREIGN KEY(id_proprietario_monitor)REFERENCES Proprietario_Monitor (id_proprietario_monitor);
ALTER TABLE Usuario ADD CONSTRAINT FK_Marca_Monitor FOREIGN KEY(id_marca_monitor)REFERENCES Marca_Monitor (id_marca_monitor);
ALTER TABLE Usuario ADD CONSTRAINT FK_Modelo_Monitor FOREIGN KEY(id_modelo_monitor)REFERENCES Modelo_Monitor (id_modelo_monitor);

