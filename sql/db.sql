-- criação banco de dados
create database sistema_usuarios;
-- usando o banco
use sistema_usuarios;
-- criando tabela de usuários
create table usuarios(
idUser int auto_increment primary key,
nome varchar(100),
email varchar(100) unique,
senha varchar(50)
);
