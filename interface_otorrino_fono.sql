create database interface_otorrino_fono;

use interface_otorrino_fono;

SHOW TABLES;
SHOW DATABASES;

create table funcionario(
	cpf varchar(50) not null primary key,
    nome varchar (100) not null,
    email varchar (50) not null unique,
    senha varchar (50) not null,
    data_nasc date not null,
    genero varchar(30) not null,
    funcao varchar (50) not null,
	num_registro varchar (50),
    telefone varchar(15) not null,
    administrador bool not null
);

insert into funcionario(cpf, nome, email, senha, data_nasc, genero, funcao, num_registro, telefone, administrador) values ( '12345678912', 'administrador', 'admin@gmail.com', '12345', '2000-01-01', 'prefiro não declarar', 'não declarada', '123456/CRM-PE', 888888888, 1);
    
create table paciente(
	cpf varchar(50) not null primary key,
    nome varchar (50) not null,
    email varchar (50) not null unique,
    data_nasc date not null,
    genero varchar(10) not null,
    telefone varchar (15) not null,
    endereco varchar (50) not null,
    cidade varchar (50) not null,
	estado varchar (50) not null,
    cep varchar (50) not null,
    prontuario varchar(50) not null
);

create table consulta(
	id int auto_increment not null primary key,
	cpf_funcionario varchar(50) not null references funcionario(cpf),
    cpf_paciente varchar(50) not null references paciente(cpf),
	data_consulta date not null,
	anamnese text not null,
    avaliacao_vocal text not null,
    diagnostico text not null,
    conduta text not null,
    obsevacoes text,
    exames blob
);

SELECT * FROM funcionario;
SELECT * FROM paciente;