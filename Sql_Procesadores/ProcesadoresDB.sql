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
FOREIGN KEY (id_socket) REFERENCES socket(id)
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

--Tabla Procesadores

-- INTEL

-- Familia Core i9
  -- 11 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11900K","Core i9",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11900F","Core i9",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11900","Core i9",11);
  -- 10 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10910","Core i9",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10900K","Core i9",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10900F","Core i9",10);
  -- 9 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9900","Core i9",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9900K","Core i9",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9880H","Core i9",9);

-- Familia Core i7
  -- 11 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11700F","Core i7",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11700","Core i7",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11700K","Core i7",11);
  -- 10 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10700","Core i7",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10700K","Core i7",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10700F","Core i7",10);
  -- 9 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9700K ","Core i7",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9700F ","Core i7",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9700 ","Core i7",9);

-- Familia Core i5
  -- 11 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11600","Core i5",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11600K","Core i5",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11600KF","Core i5",11);
  -- 10 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10505","Core i5",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10400F","Core i5",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10600K","Core i5",10);
  -- 9 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9600","Core i5",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9600","Core i5",9);

-- Familia Core i3
  -- 11 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("1115G4E","Core i3",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("1125G4","Core i3",11);
  -- 10 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10325","Core i3",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10105F","Core i3",10);
  -- 9 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9100","Core i3",9);

-- Familia Xeon Platinum
  -- 3 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("8360Y","Xeon Platinum",3);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("8358","Xeon Platinum",3);
  -- 2 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9222","Xeon Platinum",2);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("8284","Xeon Platinum",2);

-- Familia Xeon Gold
  -- 3 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5315Y","Xeon Gold",3);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("6338","Xeon Gold",3);
  -- 2 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("6250","Xeon Gold",2);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5218R","Xeon Gold",2);


-- AMD

-- Familia Ryzen 9
  -- Serie 5000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5950X","Ryzen 9",5);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5900X","Ryzen 9",5);
  -- Serie 3000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3900X","Ryzen 9",3);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5950X","Ryzen 9",3);

-- Familia Ryzen 7
  -- Serie 5000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5800X","Ryzen 7",5);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5800","Ryzen 7",5);
  -- Serie 3000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3800X","Ryzen 7",3);
  -- Serie 2000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("2700X ","Ryzen 7",2);

-- Familia Ryzen 5
  --Serie 5000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5600X","Ryzen 5",5);
  -- Serie 3000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3400G","Ryzen 5",3); -- Grafica integrada
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3600X","Ryzen 5",3);
  -- Serie 2000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("2600","Ryzen 5",2);

-- Familia Ryzen 3
  -- Serie 3000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3100","Ryzen 3",3);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3200G","Ryzen 3",3); -- Grafica integrada

-- Familia Ryzen Threadripper
  -- Serie 3000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3990X","Ryzen Threadripper",3);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3960X","Ryzen Threadripper",3);
  -- Serie 2000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("2950X","Ryzen Threadripper",2);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("2920X","Ryzen Threadripper",2);
  
-- Familia Athlon
  -- Serie 3000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("320GE","Athlon",3); -- Grafica integrada
  -- Serie 2000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("240GE","Athlon",2); -- Grafica integrada


-- Qualcomm
-- Familia Kryo
  -- Serie 600
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("680","Kryo",6);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("670","Kryo",6);
  -- Serie 500
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("585","Kryo",5);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("560","Kryo",5);
  -- Serie 400
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("495","Kryo",4);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("470","Kryo",4);

-- ARM Limited
-- Familia Cortex
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("A78","Cortex",1);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("A76","Cortex",1);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("A78C","Cortex",1);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("A78AE","Cortex",1);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("A77","Cortex",1);


-- Tabla Fabricante
INSERT INTO fabricante (codigo,codigo_postal,nombre,numero,pais,calle,telefono,correo,web) VALUES ("US4581401001","95052","Intel",3186,"Estados Unidos","Mission College Blvd","408-765-8080","investor.relations@intel.com","https://www.intel.es");
INSERT INTO fabricante (codigo,codigo_postal,nombre,numero,pais,calle,telefono,correo,web) VALUES ("US0079031078","95054","AMD",2485,"Estados Unidos","Augustine Drive","877-284-1566 ","support@amd.com","https://www.amd.com/es");
INSERT INTO fabricante (codigo,codigo_postal,nombre,numero,pais,calle,telefono,correo,web) VALUES ("US7475251036","92121","Qualcomm",5775 ,"Estados Unidos","Morehouse Drive","858-587-1121 ","support@qualcomm.com","https://www.qualcomm.com/");
INSERT INTO fabricante (codigo,codigo_postal,nombre,numero,pais,calle,telefono,correo,web) VALUES ("RE8957215654","CB1 9NJ","Arm Limited",110 ,"Reino Unido","Fulbourn Road","+44 (1223) 400 400"," info@armreinounido.com","https://www.arm.com/");



 




