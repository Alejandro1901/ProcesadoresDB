DROP DATABASE IF EXISTS ProcesadoresDB;
CREATE DATABASE ProcesadoresDB CHARACTER SET utf8mb4;
USE ProcesadoresDB;

CREATE TABLE nombre_procesador (
  modelo_procesador INT PRIMARY KEY,
  familia varchar(30),
  generacion int(5)
);

CREATE TABLE arquitectura (
  id INT PRIMARY KEY,
  version_arquitectura varchar(30),
  diseño varchar(20),
  tecnologia varchar(30),
  estandar VARCHAR(20)
);

CREATE TABLE fabricante (
  codigo varchar(50) PRIMARY KEY,
  codigo_postal varchar(50), 
  nombre VARCHAR(20),
  numero int(3),
  pais varchar(20),
  calle varchar(50),
  telefono varchar(11),
  correo varchar(30),
  web varchar(50)
);

CREATE TABLE socket (
  id INT PRIMARY KEY,
  tipo VARCHAR(30),
  tecnologia VARCHAR(20) NOT NULL,
  fecha_lanzamiento date
);

CREATE TABLE placa_base (
  id INT PRIMARY KEY,
  id_socket int,
  nombre varchar (20),
FOREIGN KEY (id_socket) REFERENCES socket(id)
);

CREATE TABLE grafica_integrada (
  id INT PRIMARY KEY,
  nombre_grafica varchar(20),
  frec_basica float,
  frec_max float,
  memoria_max int,
  resolucion varchar(5)
);

CREATE TABLE procesador (
  id INT(8) PRIMARY KEY,
  codigo_fabricante VARCHAR(50),
  id_socket INT,
  id_arquitectura INT,
  modelo INT, 
  fecha_lanzamiento DATE,
  nucleos int,
  hilos float,
  frecuencia float,
  overclock BOOLEAN,
  tdp FLOAT,
  precio float,
  FOREIGN KEY (codigo_fabricante) REFERENCES fabricante(codigo),
  FOREIGN KEY (id_socket) REFERENCES socket(id),
  FOREIGN KEY (id_arquitectura) REFERENCES arquitectura(id),
  FOREIGN KEY (modelo) REFERENCES nombre_procesador(modelo_procesador)
);


CREATE TABLE procesador_grafica_integrada (
  id_procesador INT,
  id_grafica_integrada int,
FOREIGN KEY (id_procesador) REFERENCES procesador(id),
FOREIGN KEY (id_grafica_integrada) REFERENCES grafica_integrada(id)
);
nombre_procesador (
  modelo_procesador INT PRIMARY KEY,
  familia varchar(30),
  generacion int(5)
);
INSERT INTO nombre_procesador VALUES(1, '3600X', 'Ryzen', '5', );
