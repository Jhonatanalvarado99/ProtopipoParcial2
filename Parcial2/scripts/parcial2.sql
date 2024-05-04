-- DROP DATABASE parcial2;
CREATE DATABASE parcial2;
USE parcial2;
CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(60) NOT NULL,
  password VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_usuario) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS colaboradores(
id_colab VARCHAR(60) NOT NULL,
nombre_colab VARCHAR(50) NOT NULL,
apellido_colab VARCHAR(60) NOT NULL,
direccion_colab VARCHAR(60) NOT NULL,
telefono_colab VARCHAR(60) NOT NULL,
PRIMARY KEY (id_colab)
 ) ENGINE = InnoDB DEFAULT CHARSET=latin1;