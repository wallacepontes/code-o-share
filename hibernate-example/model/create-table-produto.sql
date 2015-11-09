USE hibernateexampleDB;
CREATE TABLE Produto (
    id BIGINT NOT NULL AUTO_INCREMENT ,
    nome VARCHAR (255) NOT NULL ,
    preco DOUBLE NOT NULL ,
    PRIMARY KEY (id)
    ) ENGINE = InnoDB 