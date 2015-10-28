USE livraria ;
CREATE TABLE Livro (
    id BIGINT NOT NULL AUTO_INCREMENT ,
    titulo VARCHAR (255) NOT NULL ,
    preco DOUBLE NOT NULL ,
    editora_id BIGINT NOT NULL ,
    PRIMARY KEY (id),
    CONSTRAINT fk_editora FOREIGN KEY fk_editora ( editora_id )
    REFERENCES Editora (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE = InnoDB ;