CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE estante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    id_estante INT,
    FOREIGN KEY (id_estante) REFERENCES estante(id)
);
