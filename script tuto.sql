DROP SCHEMA IF EXISTS primefaces_tuto;
CREATE SCHEMA primefaces_tuto;

CREATE TABLE persona (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    sexo ENUM('M','F')
);

CREATE TABLE producto (
    codart CHAR(5) PRIMARY KEY,
    desart VARCHAR(30) NOT NULL,
    pvpart FLOAT(6 , 2 ) UNSIGNED NOT NULL
);

CREATE TABLE lineapedido (
    refped CHAR(5),
    codart CHAR(5),
    cantart INT(4) UNSIGNED NOT NULL DEFAULT 1,
    INDEX (refped),
    FOREIGN KEY (refped)
        REFERENCES pedido (refped)
        ON UPDATE CASCADE,
    INDEX (codart),
    FOREIGN KEY (codart)
        REFERENCES articulo (codart)
        ON UPDATE CASCADE,
    PRIMARY KEY (refped , codart)
);