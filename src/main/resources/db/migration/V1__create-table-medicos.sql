create table medicos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,

    primary key(id)

);