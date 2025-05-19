create database sistema_usuarios;

use sistema_usuarios;

create table usuarios(
idUser int auto_increment primary key,
nome varchar(100),
email varchar(100) unique,
senha varchar(50)
);