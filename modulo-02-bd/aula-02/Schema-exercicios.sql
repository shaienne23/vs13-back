

CREATE TABLE VEM_SER.PAIS (
    id_pais NUMBER(38,0) PRIMARY KEY NOT NULL,
    nome VARCHAR2(50) NOT NULL
);

CREATE TABLE VEM_SER.ESTADO (
    id_estado NUMBER(38,0) PRIMARY KEY NOT NULL,
    id_pais NUMBER(38,0) NOT NULL,
    nome VARCHAR2(50) NOT NULL,
    CONSTRAINT FK_ESTADO_ID_PAIS FOREIGN KEY (id_pais) REFERENCES VEM_SER.PAIS (id_pais)
);

CREATE TABLE VEM_SER.CIDADE (
    id_cidade NUMBER(38,0) NOT NULL,
    id_estado NUMBER(38,0) NOT NULL,
    nome VARCHAR2(50) NOT NULL,
    PRIMARY KEY (id_cidade, id_estado),
    CONSTRAINT FK_CIDADE_ID_ESTADO FOREIGN KEY (id_estado) REFERENCES VEM_SER.ESTADO (id_estado)
);


CREATE TABLE VEM_SER.BAIRRO (
    id_bairro NUMBER(38,0) NOT NULL,
    id_cidade NUMBER(38,0) NOT NULL,
    id_estado NUMBER(38,0) NOT NULL,
    nome VARCHAR2(50) NOT NULL,
    PRIMARY KEY (id_bairro, id_cidade),
    CONSTRAINT FK_BAIRRO_ID_CIDADE_ESTADO FOREIGN KEY (id_cidade, id_estado) REFERENCES VEM_SER.CIDADE (id_cidade, id_estado)
);


CREATE TABLE VEM_SER.ENDERECO (
    id_endereco NUMBER(38,0) PRIMARY KEY NOT NULL,
    id_bairro NUMBER(38,0) NOT NULL,
    id_cidade NUMBER(38,0) NOT NULL,
    logradouro VARCHAR2(255) NOT NULL,
    numero NUMBER(38,0) NOT NULL,
    complemento VARCHAR2(100),
    cep CHAR(9),
    CONSTRAINT FK_ENDERECO_ID_BAIRRO_E_CIDADE FOREIGN KEY (id_bairro, id_cidade) REFERENCES VEM_SER.BAIRRO (id_bairro, id_cidade)
);

SELECT * FROM VEM_SER.ENDERECO

CREATE SEQUENCE VEM_SER.SEQ_IDS
  START WITH     1
  INCREMENT BY   1
  NOCACHE
  NOCYCLE;
 
INSERT INTO VEM_SER.PAIS (id_pais, nome) 
VALUES ( VEM_SER.SEQ_IDS.NEXTVAL, 'Brasil');

INSERT INTO VEM_SER.PAIS (id_pais, nome) VALUES ( VEM_SER.SEQ_IDS.NEXTVAL, 'Estados Unidos');
 
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 1, 'Minas Gerais');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 1, 'Amazonas');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 2, 'Nova York');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 2, 'Nova Jersey');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 4, 'Belo Horizonte');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 4, 'Uberlândia');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 5, 'Manaus');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 5, 'Parintins');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 6, 'Nova York');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 6, 'Buffalo');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 7, 'Jersey City');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 7, 'Newark');

INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 9, 4, 'Centro');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 9, 4, 'Savassi');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 12, 5, 'Centro');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 12, 5, 'Cachoeirinha');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 10, 4, 'Centro');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 10, 4, 'Santa Mônica');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 11, 5, 'Cidade Nova');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 11, 5, 'Parque 10');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 13, 6, 'Midtown');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 13, 6, 'Upper West Side');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 14, 6, 'Downtown');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 14, 6, 'Allentown');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 15, 7, 'Journal Square');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 15, 7, 'Hamilton Park');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 16, 7, 'Downtown Newark');
INSERT INTO VEM_SER.BAIRRO (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 16, 7, 'Ironbound');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 20, 9, 'Rua do Centro', 1, 'Prédio A', '12345-678');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 20, 9, 'Avenida Principal', 20, 'PREDIO', '54321-876');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 21, 9, 'Rua da Savassi', 5, 'Apartamento 101', '98765-432');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 21, 9, 'Avenida da Savassi', 15, 'Casa 2', '87654-321');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 22, 12, 'Praça Central', 10, 'Bloco A, Apt 301', '12345-678');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 22, 12, 'Boulevard Broadway', 25, 'Penthouse Suite', '98765-432');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 23, 12, 'Rua do Bosque', 8, 'Apartamento 303', '54321-678');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 23, 12, 'Avenida da Liberdade', 25, 'Casa 3', '98765-432');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 24, 10, 'Praça Central', 10, 'Bloco A Apt 301', '12345-678');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 24, 10, 'Boulevard Broadway', 25, 'Penthouse Suite', '98765-432');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 25, 10, 'Rua daS FLORES', 5, 'Apartamento 200', '98765-112');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 25, 10, 'Avenida DOS CEUS', 11, 'Casa 2', '81154-321');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 28, 14, '	street sunshine', 75, 'Ap 101', '98765');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 28, 14, 'Avenue president', 85, 'house 2', '87654');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 29, 14, 'street red', 50, 'park', '98765');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 29, 14, 'strawberry street ', 15, 'Casa 2', '87654');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 30, 15, 'Fox street', 78, 'Apartamento 101', '98765');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 30, 15, 'skyfall street', 75, 'house 2', '87654');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 31, 15, 'dog street ', 15, 'ap 101', '98765');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 31, 15, 'Big foot Street', 15, '3 floor', '87654');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 32, 16, 'clowds streets', 55, 'park', '98765');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 32, 16, 'Ada Avenue', 35, 'Casa 2', '87654');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 33, 16, 'iron street', 1115, ' 101', '98767');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 33, 16, 'spider street ', 115, 'house 2', '87654');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 34, 11, 'Rua nova', 5, 'Apartamento 231', '23456-432');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 34, 11, 'Avenida C', 15, 'Casa 243', '87754-321');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 35, 11, 'Rua da Savassi', 5, 'Apartamento 101', '98765-432');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 35, 11, 'Avenida da Savassi', 15, 'Casa 2', '87654-321');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 36, 13, 'street hearth', 25, 'park', '98765');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 36, 13, 'Avenue happy', 15, 'house 12', '06606');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 37, 13, 'avenue apple', 5, ' 101', '98765');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) 
VALUES (VEM_SER.SEQ_IDS.NEXTVAL, 37, 13, 'Avenue Sun', 15, 'house 2', '87658');


SELECT * FROM VEM_SER.PAIS;
SELECT * FROM VEM_SER.ESTADO;
SELECT * FROM VEM_SER.CIDADE;
SELECT * FROM VEM_SER.BAIRRO;
SELECT * FROM VEM_SER.ENDERECO






