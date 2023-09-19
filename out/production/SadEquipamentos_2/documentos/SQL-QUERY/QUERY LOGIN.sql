CREATE TABLE LoginEquip (id_login integer IDENTITY(1,1) CONSTRAINT PK_id_login PRIMARY KEY,
usuario VARCHAR(50) not null,
senha VARCHAR(50) not null,
adm VARCHAR(3));