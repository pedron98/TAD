CREATE DATABASE dbtad;

USE datad;

CREATE TABLE if not exists tb_cliente(
		ID integer primary key auto_increment,
        NOME varchar(50) not null unique,
        IDADE integer not null,
        SEXO enum('M','F'),
        RUA varchar(120),
        BAIRRO varchar(50),
		NUMERO Integer        
);

SELECT * FROM tb_cliente;