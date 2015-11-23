USE cos_jsfintegrationdb ;
CREATE TABLE Carro (
    id BIGINT NOT NULL AUTO_INCREMENT ,
    marca VARCHAR (100) NOT NULL ,
    modelo VARCHAR (100) NOT NULL ,
    PRIMARY KEY (id)
    ) ENGINE = InnoDB 