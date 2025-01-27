create table consultas (

    id bigint not null auto_increment,
    paciente_id bigint not null,
    medico_id bigint not null,
    data_hora timestamp not null,
    local varchar(100) not null,
    ativo boolean not null,

    primary key(id),

    constraint fk_paciente foreign key(paciente_id) references pacientes(id) on delete cascade,
    constraint fk_medico foreign key(medico_id) references medicos(id) on delete cascade
);
