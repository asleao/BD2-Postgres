COPY (SELECT * FROM cliente) TO '/tmp/cliente.csv' WITH CSV header;
COPY (SELECT * FROM filme) TO '/tmp/filme.csv' WITH CSV header;
COPY (SELECT * FROM categoria)  TO '/tmp/categoria.csv' WITH CSV header;
COPY (SELECT * FROM locacao) TO '/tmp/locacao.csv' WITH CSV header;