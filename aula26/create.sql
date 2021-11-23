create table IF NOT EXISTS endereco(
id int auto_increment primary key,
rua varchar(64),
numero varchar (12),
cidade varchar (64),
estado varchar (2));

create table IF NOT EXISTS dentista(
id int auto_increment primary key,
nome varchar(64),
sobrenome varchar (64),
matricula int);

create table IF NOT EXISTS usuario(
id int auto_increment primary key,
nome varchar(64),
email varchar(64),
senha varchar(64),
acesso int);

create table IF NOT EXISTS paciente(
id int auto_increment primary key,
nome varchar(64),
sobrenome varchar (64),
cpf varchar (14),
data_cadastro TIMESTAMP WITHOUT TIME ZONE,
endereco_id int);

create table IF NOT EXISTS consulta(
id int auto_increment primary key,
paciente int,
dentista int,
data_cadastro TIMESTAMP WITHOUT TIME ZONE);