CREATE TABLE Personagem (
    id bigint not null auto_increment,
    nome varchar(60) not null,
    sexo varchar(255) not null,
    cla varchar(255) not null,
    aldeia varchar(255) not null,
    registroNinja varchar(255),
    patenteNinja varchar(255),
    primary key (id)
)