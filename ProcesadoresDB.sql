DROP DATABASE IF EXISTS ProcesadoresDB;
CREATE DATABASE ProcesadoresDB CHARACTER SET utf8mb4;
USE ProcesadoresDB;

CREATE TABLE nombre_procesador (
  modelo_procesador varchar(20) PRIMARY KEY,
  familia varchar(30),
  generacion int(5)
);

CREATE TABLE arquitectura (
  id INT PRIMARY KEY,
  version varchar(30),
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
  modelo varchar(20), 
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

INSERT INTO nombre_procesador VALUES ("3600X","Ryzen 5",3);
INSERT INTO nombre_procesador VALUES ("2600","Ryzen 5",2);

-- INTEL

-- Familia Core i9
  -- 11 gen
INSERT INTO nombre_procesador VALUES ("11900K","Core i9",11);
INSERT INTO nombre_procesador VALUES ("11900F","Core i9",11);
INSERT INTO nombre_procesador VALUES ("11900","Core i9",11);
  -- 10 gen
INSERT INTO nombre_procesador VALUES ("10910","Core i9",10);
INSERT INTO nombre_procesador VALUES ("10900K","Core i9",10);
INSERT INTO nombre_procesador VALUES ("10900F","Core i9",10);
  -- 9 gen
INSERT INTO nombre_procesador VALUES ("9900","Core i9",9);
INSERT INTO nombre_procesador VALUES ("9900K","Core i9",9);
INSERT INTO nombre_procesador VALUES ("9880H","Core i9",9);

-- Familia Core i7
  -- 11 gen
INSERT INTO nombre_procesador VALUES ("11700F","Core i7",11);
INSERT INTO nombre_procesador VALUES ("11700","Core i7",11);
INSERT INTO nombre_procesador VALUES ("11700K","Core i7",11);
  -- 10 gen
INSERT INTO nombre_procesador VALUES ("10700","Core i7",10);
INSERT INTO nombre_procesador VALUES ("10700K","Core i7",10);
INSERT INTO nombre_procesador VALUES ("10700F","Core i7",10);
  -- 9 gen
INSERT INTO nombre_procesador VALUES ("9700K ","Core i7",9);
INSERT INTO nombre_procesador VALUES ("9700F ","Core i7",9);
INSERT INTO nombre_procesador VALUES ("9700 ","Core i7",9);

-- Familia Core i5
  -- 11 gen
INSERT INTO nombre_procesador VALUES ("11600","Core i5",11);
INSERT INTO nombre_procesador VALUES ("11600K","Core i5",11);
INSERT INTO nombre_procesador VALUES ("11600KF","Core i5",11);
  -- 10 gen
INSERT INTO nombre_procesador VALUES ("10505","Core i5",10);
INSERT INTO nombre_procesador VALUES ("10400F","Core i5",10);
INSERT INTO nombre_procesador VALUES ("10600K","Core i5",10);
  -- 9 gen
INSERT INTO nombre_procesador VALUES ("9600","Core i5",9);
INSERT INTO nombre_procesador VALUES ("9600","Core i5",9);


-- Familia Core i3
  -- 11 gen
INSERT INTO nombre_procesador VALUES ("1115G4E","Core i3",11);
INSERT INTO nombre_procesador VALUES ("1125G4","Core i3",11);
  -- 10 gen
INSERT INTO nombre_procesador VALUES ("10325","Core i3",10);
INSERT INTO nombre_procesador VALUES ("10105F","Core i3",10);
  -- 9 gen
INSERT INTO nombre_procesador VALUES ("9100","Core i3",9);

-- AMD

-- Familia Ryzen 9
  -- Serie 5000
INSERT INTO nombre_procesador VALUES ("5950X","Ryzen 9",5);
INSERT INTO nombre_procesador VALUES ("5900X","Ryzen 9",5);
  -- Serie 3000
INSERT INTO nombre_procesador VALUES ("3900X","Ryzen 9",3);
INSERT INTO nombre_procesador VALUES ("5950X","Ryzen 9",3);

-- Familia Ryzen 7
  -- Serie 5000
INSERT INTO nombre_procesador VALUES ("5800X","Ryzen 7",5);
INSERT INTO nombre_procesador VALUES ("5800","Ryzen 7",5);
  -- Serie 3000
INSERT INTO nombre_procesador VALUES ("3800X","Ryzen 7",3);

-- Familia Ryzen 5
  --Serie 5000
INSERT INTO nombre_procesador VALUES ("5600X","Ryzen 5",5);
  -- Serie 3000
INSERT INTO nombre_procesador VALUES ("3400G","Ryzen 5",3); -- Grafica integrada
INSERT INTO nombre_procesador VALUES ("3600","Ryzen 5",3);

-- Familia Ryzen 3
  -- Serie 3000



INSERT INTO nombre_procesador VALUES ("2700X ","Ryzen 7",2);
INSERT INTO nombre_procesador VALUES ("3960X","Ryzen Threadripper",3);


 




