DROP DATABASE IF EXISTS ProcesadoresDB;
CREATE DATABASE ProcesadoresDB CHARACTER SET utf8mb4;
USE ProcesadoresDB;

CREATE TABLE nombre_procesador (
  modelo_procesador varchar(20) PRIMARY KEY,
  familia varchar(30),
  generacion int(10) DEFAULT 1
);

CREATE TABLE arquitectura (
  id INT PRIMARY KEY,
  version_arquitectura ENUM('ARM','x86-64'),
  disenio varchar(20),
  tecnologia ENUM('Thumb','Jazelle','No tiene') DEFAULT 'No tiene',
  estandar ENUM('AMD 64','Intel 64','No tiene') DEFAULT 'No tiene'
);

CREATE TABLE fabricante (
  codigo varchar(50) PRIMARY KEY,
  codigo_postal varchar(50), 
  nombre VARCHAR(20),
  numero int(3),
  pais varchar(20),
  calle varchar(50),
  telefono varchar(50),
  correo varchar(50),
  web varchar(50)
);

CREATE TABLE zocalo (
  id INT PRIMARY KEY,
  tipo VARCHAR(30),
  tecnologia VARCHAR(20) NOT NULL,
  fecha_lanzamiento date
);

CREATE TABLE placa_base (
  id INT PRIMARY KEY,
  id_socket int,
  nombre varchar (20),
FOREIGN KEY (id_socket) REFERENCES zocalo(id)
);

CREATE TABLE grafica_integrada (
  id INT PRIMARY KEY,
  nombre_grafica varchar(20),
  frec_basica float,
  frec_max float,
  memoria_max int,
  resolucion ENUM('720p','1080p','2K','4K','8K','16K')
);

CREATE TABLE procesador (
  id INT(8) PRIMARY KEY,
  codigo_fabricante VARCHAR(50),
  id_socket INT,
  id_arquitectura INT,
  modelo varchar(20), 
  fecha_lanzamiento DATE,
  nucleos int,
  hilos int,
  frecuencia float,
  overclock BOOLEAN,
  tdp FLOAT,
  precio float,
  graficapropia BOOLEAN,
  FOREIGN KEY (codigo_fabricante) REFERENCES fabricante(codigo),
  FOREIGN KEY (id_socket) REFERENCES zocalo(id),
  FOREIGN KEY (id_arquitectura) REFERENCES arquitectura(id),
  FOREIGN KEY (modelo) REFERENCES nombre_procesador(modelo_procesador)
);


CREATE TABLE procesador_grafica_integrada (
  id_procesador INT,
  id_grafica_integrada int,
FOREIGN KEY (id_procesador) REFERENCES procesador(id),
FOREIGN KEY (id_grafica_integrada) REFERENCES grafica_integrada(id)
);

 delimiter //
 create trigger procesador
   after insert
   on procesador
   for each row
  begin
    if procesador.graficapropia=1 then
      insert into procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (procesador.id,null);
    end if;
  end //
  delimiter ;




