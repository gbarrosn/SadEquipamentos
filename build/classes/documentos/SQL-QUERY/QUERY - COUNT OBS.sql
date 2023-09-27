select nome from usuario,obs where usuario.id_usuario = obs.id_usuario SELECT COUNT(id_obs) FROM Obs

SELECT COUNT(id_obs) as 'Contagem' FROM Obs where id_usuario=2478

select nome from usuario,obs where usuario.id_usuario=obs.id_usuario

select * from usuario order by nome




SELECT Nome, count(*) AS Quantidade
FROM Usuario,Obs
WHERE usuario.id_usuario=obs.id_usuario
GROUP BY nome
ORDER BY nome;

select * from Usuario