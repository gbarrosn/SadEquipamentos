CREATE TABLE Obs (id_obs integer IDENTITY(1,1)CONSTRAINT PK_id_obs PRIMARY KEY,
				  id_usuario  integer,
				  obs VARCHAR (200) not null,
				  data_obs VARCHAR (70) not null
				  nome_usuario VARCHAR(50));


ALTER TABLE Obs ADD CONSTRAINT FK_id_usuario FOREIGN KEY(id_usuario)REFERENCES Usuario (id_usuario);
