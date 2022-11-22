CREATE TABLE Personagem (
    id bigint not null auto_increment,
    nome varchar(60) not null,
    sexo varchar(255) not null,
    cla varchar(255) not null,
    aldeia varchar(255) not null,
    jutsu varchar(255) not  null,
    patente_ninja varchar(255),
    dublador_jp varchar(255),
    dublador_pt varchar(255),
    primary key (id)
)