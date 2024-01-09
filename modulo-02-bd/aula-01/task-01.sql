CREATE TABLE VEM_SER.ESTUDANTE (
    id_estudante NUMBER PRIMARY KEY,
    nome VARCHAR2(200) NOT NULL,
    data_nascimento DATE NOT NULL,
    nr_matricula NUMBER(10) UNIQUE NOT NULL,
    ativo CHAR(1) CHECK (ativo IN ('S', 'N')) NOT NULL
);

 CREATE SEQUENCE VEM_SER.SEQ_ESTUDANTE
  START WITH     1
  INCREMENT BY   1
  NOCACHE
  NOCYCLE;


INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Shaienne Oliveira', TO_DATE('28-05-1991', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'S');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Gustavo Oliveira', TO_DATE('07-12-2012','dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'N');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Daniel de Oliveira', TO_DATE('12-06-1995', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'S');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Theo de Oliveira', TO_DATE('01-06-2023', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'N');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'James de Oliveira', TO_DATE('01-06-2023', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'S');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Leo Oliveira', TO_DATE('01-05-2021', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'N');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Travis de Oliveira', TO_DATE('10-03-2021', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'S');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Mike de Oliveira', TO_DATE('11-08-2023', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'N');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES(VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Gary de Oliveira', TO_DATE('28-06-2005', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'S');

INSERT INTO VEM_SER.ESTUDANTE(id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'Jake de Oliveira', TO_DATE('01-09-2023', 'dd-mm-yyyy'), VEM_SER.SEQ_ESTUDANTE.NEXTVAL, 'N');


SELECT * FROM VEM_SER.ESTUDANTE