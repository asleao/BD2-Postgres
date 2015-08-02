/*
SELECT cli.id, cli.nome, count(cli.id)  AS filmes_estrangeiros_locados
FROM cliente cli 
JOIN locacao loc 
on (cli.id = loc.cliente_id) 
JOIN filme fil 
on (loc.filme_id = fil.id) 
inner JOIN categoria AS cat
on (fil.categoria_id = cat.id)
where fil.preco > 60.00 AND cli.nome LIKE '%an%' AND cat.descricao <> 'Aventura' 
group by cli.id
*/

/*
SELECT cat.descricao, sum(cat.preco) AS soma_valores FROM locacao loc
inner JOIN
filme fil
on (fil.id = loc.filme_id)
inner JOIN
categoria cat
on (cat.id = fil.categoria_id)
group by cat.descricao
*/

/*
SELECT c.id,c.nome,c.sexo,f.nome, ct.descricao 
FROM cliente c inner JOIN locacao l
on (c.id = l.cliente_id)
inner JOIN filme f 
on (l.filme_id = f.id)
inner JOIN categoria ct
on (ct.id = f.categoria_id)
where ct.id in (1,2) 
AND c.sexo = '1'
*/

/*
SELECT c.*,l.*,ct.*,f.* 
FROM cliente c inner JOIN locacao l
on (c.id = l.cliente_id)
inner JOIN filme f 
on (l.filme_id = f.id)
inner JOIN categoria ct
on (ct.id = f.categoria_id)
where ct.id in (1,2) 
AND sexo =  '1'
*/

/*
SELECT c.*,l.*,ct.*,f.* 
FROM cliente c inner JOIN locacao l
on (c.id = l.cliente_id)
inner JOIN filme f 
on (l.filme_id = f.id)
inner JOIN categoria ct
on (ct.id = f.categoria_id)
where ct.id in (
		SELECT categoria.id 
		FROM categoria INNER JOIN filme 
		ON (filme.categoria_id = categoria.id) 
		WHERE descricao <> 'Aventura'
		group by categoria.id 
	) 
AND sexo =  '1'
*/

--Custom
--Locacoes com clientes que locaram filmes com a categoria contendo a letra A
-- Campo String indexado
SELECT * FROM locacao l 
WHERE cliente_id IN (
	SELECT c.id FROM cliente c
	INNER JOIN locacao loc
	ON (loc.cliente_id = c.id)
	INNER JOIN filme f
	ON (loc.filme_id = f.id)
	INNER JOIN categoria cat
	ON (f.categoria_id = cat.id)
	WHERE cat.descricao LIKE '%a%'
)
