--ALTER TABLE Gerencia ADD CONSTRAINT FK_pavimento_gerencia FOREIGN KEY(id_pavimento)REFERENCES Pavimento(id_pavimento);
--UPDATE Gerencia SET id_pavimento=23 where id_pavimento is null;

--USUARIO:

--1º ANDAR:
--UPDATE USUARIO SET id_pavimento=1 WHERE id_gerencia=37
--UPDATE USUARIO SET id_pavimento=1 WHERE id_gerencia=10
--UPDATE USUARIO SET id_pavimento=1 WHERE id_gerencia=12

--2º ANDAR:
--UPDATE USUARIO SET id_pavimento=2 WHERE id_gerencia=57

--3º ANDAR:
--UPDATE USUARIO SET id_pavimento=3 WHERE id_gerencia=42
--UPDATE USUARIO SET id_pavimento=3 WHERE id_gerencia=6
--UPDATE USUARIO SET id_pavimento=3 WHERE id_gerencia=72
--UPDATE USUARIO SET id_pavimento=3 WHERE id_gerencia=74
--UPDATE USUARIO SET id_pavimento=3 WHERE id_gerencia=75

--4º ANDAR:
--UPDATE USUARIO SET id_pavimento=4 WHERE id_gerencia=71
--UPDATE USUARIO SET id_pavimento=4 WHERE id_gerencia=76
--UPDATE USUARIO SET id_pavimento=4 WHERE id_gerencia=77
--UPDATE USUARIO SET id_pavimento=4 WHERE id_gerencia=78
--UPDATE USUARIO SET id_pavimento=4 WHERE id_gerencia=79
--UPDATE USUARIO SET id_pavimento=4 WHERE id_gerencia=80
--UPDATE USUARIO SET id_pavimento=4 WHERE id_gerencia=81
--UPDATE USUARIO SET id_pavimento=4 WHERE id_gerencia=70

--5º ANDAR:
--UPDATE USUARIO SET id_pavimento=5 WHERE id_gerencia=28
--UPDATE USUARIO SET id_pavimento=5 WHERE id_gerencia=19
--UPDATE USUARIO SET id_pavimento=5 WHERE id_gerencia=69

--6º ANDAR:
--UPDATE USUARIO SET id_pavimento=6 WHERE id_gerencia=27
--UPDATE USUARIO SET id_pavimento=6 WHERE id_gerencia=82
--UPDATE USUARIO SET id_pavimento=6 WHERE id_gerencia=9
--UPDATE USUARIO SET id_pavimento=6 WHERE id_gerencia=45

--7º ANDAR:
--UPDATE USUARIO SET id_pavimento=7 WHERE id_gerencia=58
--UPDATE USUARIO SET id_pavimento=7 WHERE id_gerencia=16
--UPDATE USUARIO SET id_pavimento=7 WHERE id_gerencia=13
--UPDATE USUARIO SET id_pavimento=7 WHERE id_gerencia=73

--8º ANDAR:
--UPDATE USUARIO SET id_pavimento=8 WHERE id_gerencia=8
--UPDATE USUARIO SET id_pavimento=8 WHERE id_gerencia=66
--UPDATE USUARIO SET id_pavimento=8 WHERE id_gerencia=51

--9º ANDAR:
--UPDATE USUARIO SET id_pavimento=9 WHERE id_gerencia=25
--UPDATE USUARIO SET id_pavimento=9 WHERE id_gerencia=30
--UPDATE USUARIO SET id_pavimento=9 WHERE id_gerencia=68



--10º ANDAR:
--UPDATE USUARIO SET id_pavimento=10 WHERE id_gerencia=18
--UPDATE USUARIO SET id_pavimento=10 WHERE id_gerencia=67
--UPDATE USUARIO SET id_pavimento=10 WHERE id_gerencia=24
--UPDATE USUARIO SET id_pavimento=10 WHERE id_gerencia=29

--11º ANDAR:
--UPDATE USUARIO SET id_pavimento=11 WHERE id_gerencia=39
--UPDATE USUARIO SET id_pavimento=11 WHERE id_gerencia=47
--UPDATE USUARIO SET id_pavimento=11 WHERE id_gerencia=41
--UPDATE USUARIO SET id_pavimento=11 WHERE id_gerencia=3
--UPDATE USUARIO SET id_pavimento=11 WHERE id_gerencia=40
--UPDATE USUARIO SET id_pavimento=11 WHERE id_gerencia=43
--UPDATE USUARIO SET id_pavimento=11 WHERE id_gerencia=23

--12º ANDAR:
--UPDATE USUARIO SET id_pavimento=12 WHERE id_gerencia=64
--UPDATE USUARIO SET id_pavimento=12 WHERE id_gerencia=31
--UPDATE USUARIO SET id_pavimento=12 WHERE id_gerencia=15
--UPDATE USUARIO SET id_pavimento=12 WHERE id_gerencia=65
--UPDATE USUARIO SET id_pavimento=12 WHERE id_gerencia=2

select * from Gerencia where gerencia like '%super%'




















--GERENCIA:
--UPDATE GERENCIA SET id_pavimento=2 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=3 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=5 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=6 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=8 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=9 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=10 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=11 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=12 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=13 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=15 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=16 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=18 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=19 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=23 WHERE id_gerencia=0

--UPDATE GERENCIA SET id_pavimento=24 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=25 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=27 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=28 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=29 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=30 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=11 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=12 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=13 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=15 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=16 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=18 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=19 WHERE id_gerencia=0
--UPDATE GERENCIA SET id_pavimento=23 WHERE id_gerencia=0
