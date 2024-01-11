
-- tabelas Pessoa e Contato OKOK
SELECT *
FROM Pessoa p
RIGHT JOIN Contato c ON p.id_pessoa = c.id_pessoa;

-- tabelas Pessoa, PESSOA X PESSOA ENDERECO e Endereco Pessoa
SELECT *
FROM VEM_SER.PESSOA p
RIGHT JOIN VEM_SER.CONTATO c ON p.ID_PESSOA = c.ID_PESSOA
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (p.id_pessoa = pxpe.ID_PESSOA)
RIGHT JOIN VEM_SER.ENDERECO_PESSOA ep ON (pxpe.ID_ENDERECO  = ep.ID_ENDERECO)

--Todas as tabelas (começando por pessoa) --Fazer um FULL JOIN entre tabelas:
--Pessoa e Contato OKOK
SELECT * FROM PESSOA p
FULL JOIN CONTATO c ON p.ID_PESSOA = c.ID_PESSOA

--Pessoa, PESSOA X PESSOA ENDERECO e Endereco Pessoa OKOK
SELECT * FROM PESSOA p
FULL JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON p.ID_PESSOA = pxpe.ID_PESSOA

--Todas as tabelas (começando por pessoa)
--* Utilizando o EXISTS, selecione as pessoas que tem endereço okOK
SELECT p.id_pessoa, p.nome
FROM PESSOA p
WHERE EXISTS (
    SELECT 1
    FROM PESSOA_X_PESSOA_ENDERECO pxpe
    WHERE p.id_pessoa = pxpe.id_pessoa
);

--* Selecione id, nome da tabela pessoa junto com id, logradouro da tabela endereço

SELECT
p.ID_PESSOA AS ID,
p.NOME AS DESCRICAO,
'Pessoa' AS TIPO
FROM PESSOA p

UNION

SELECT
ep.ID_ENDERECO AS ID,
ep. lOGRADOURO AS DESCRICAO,
'endereço' AS TIPO
FROM ENDERECO_PESSOA ep