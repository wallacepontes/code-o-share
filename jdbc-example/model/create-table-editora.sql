USE cos_jdbcexampledb ;
CREATE TABLE Editora (
    id BIGINT NOT NULL AUTO_INCREMENT ,
    nome VARCHAR (255) NOT NULL ,
    email VARCHAR (255) NOT NULL ,
    PRIMARY KEY (id)
    ) ENGINE = InnoDB ;