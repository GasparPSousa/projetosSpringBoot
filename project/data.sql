create table IF NOT EXISTS dentista(
  id int auto_increment primary key,
  nome varchar(32),
  sobrenome varchar(64),
  matricula int
);

create table IF NOT EXISTS endereco(
   id int auto_increment primary key,
   rua varchar(255),
   numero varchar (255),
   cidade varchar (255),
   estado varchar (255)
);

