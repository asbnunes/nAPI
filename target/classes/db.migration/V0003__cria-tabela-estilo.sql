CREATE TABLE Estilo (
    id bigint not null,
    estilo varchar(255) not null,
    FOREIGN KEY (id) REFERENCES Personagem(id)
)