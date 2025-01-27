create table pacientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    telefone varchar(20) not null,
    ativo boolean not null,

    primary key(id)

);