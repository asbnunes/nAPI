CREATE TABLE Jutsu (
    id_jutsu bigint not null auto_increment,
    nome_jutsu varchar(255) not null,
    id_personagem bigint not null,
    PRIMARY KEY (id_jutsu),
    FOREIGN KEY (id_personagem) REFERENCES Personagem(id)
)