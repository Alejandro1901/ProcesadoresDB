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
  fecha_lanzamiento VARCHAR(10)
);

CREATE TABLE placa_base (
  id INT PRIMARY KEY,
  id_socket int,
  nombre varchar (100),
FOREIGN KEY (id_socket) REFERENCES zocalo(id)
);

CREATE TABLE grafica_integrada (
  id INT PRIMARY KEY,
  nombre_grafica varchar(100),
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
  modelo varchar(50), 
  fecha_lanzamiento VARCHAR(10),
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

-- Tabla Procesadores

-- INTEL

-- Familia Core i9
  -- 11 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11900K","Core i9",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11900F","Core i9",11);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("11900","Core i9",11);
  -- 10 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10900","Core i9",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10900K","Core i9",10);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("10900F","Core i9",10);
  -- 9 gen
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9900","Core i9",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9900K","Core i9",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9900KF","Core i9",9);

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
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9700K","Core i7",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9700F","Core i7",9);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9700","Core i7",9);

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
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("9600KF","Core i5",9);
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
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3950X","Ryzen 9",3);

-- Familia Ryzen 7
  -- Serie 5000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5800X","Ryzen 7",5);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("5800","Ryzen 7",5);
  -- Serie 3000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("3800X","Ryzen 7",3);
  -- Serie 2000
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("2700X","Ryzen 7",2);

-- Familia Ryzen 5
  -- Serie 5000
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
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("680 Gold","Kryo",6);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("670 Gold","Kryo",6);
  -- Serie 500
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("585","Kryo",5);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("560","Kryo",5);
  -- Serie 400
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("495","Kryo",4);
INSERT INTO nombre_procesador (modelo_procesador,familia,generacion) VALUES ("470","Kryo",4);

-- Tabla Arquitectura
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (1,"x86-64","Tiger Lake","Intel 64");
-- 11 gen i3
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (2,"x86-64","Rocket Lake","Intel 64"); 
-- 11 gen i9, i7, i5
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (3,"x86-64","Comet Lake","Intel 64");
-- 10 gen i9, i7, i5, i3
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (4,"x86-64","Coffee Lake","Intel 64");
-- 9 gen i9, i7, i5, i3
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (5,"x86-64","Ice Lake","Intel 64");
-- 3 gen Xeon Platinum, Gold
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (6,"x86-64","Cascade Lake","Intel 64");
-- 2 gen Xeon Platinumo, Gold
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (7,"x86-64","Zen 3","AMD 64");
-- Serie 5000 Ryzen 9, 7, 5
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (8,"x86-64","Zen 2","AMD 64");
-- Serie 3000 Ryzen 9, 7, 5, 3, Ryzen Threadripper, Athlon
INSERT INTO arquitectura (id,version_arquitectura,disenio,estandar) VALUES (9,"x86-64","Zen +","AMD 64");
-- Serie 2000 Ryzen 7, 5, Ryzen Threadripper, Athlon
INSERT INTO arquitectura (id,version_arquitectura,disenio,tecnologia) VALUES (10,"ARM","Cortex-A78","Thumb");
-- 680, 670 Gold
INSERT INTO arquitectura (id,version_arquitectura,disenio,tecnologia) VALUES (11,"ARM","Cortex-A77","Thumb");
-- 585, 560
INSERT INTO arquitectura (id,version_arquitectura,disenio,tecnologia) VALUES (12,"ARM","Cortex-A76","Thumb");
-- 495, 470

-- Tabla Fabricante
INSERT INTO fabricante (codigo,codigo_postal,nombre,numero,pais,calle,telefono,correo,web) VALUES ("US4581401001","95052","Intel",3186,"Estados Unidos","Mission College Blvd","408-765-8080","investor.relations@intel.com","https://www.intel.es");
INSERT INTO fabricante (codigo,codigo_postal,nombre,numero,pais,calle,telefono,correo,web) VALUES ("US0079031078","95054","AMD",2485,"Estados Unidos","Augustine Drive","877-284-1566 ","support@amd.com","https://www.amd.com/es");
INSERT INTO fabricante (codigo,codigo_postal,nombre,numero,pais,calle,telefono,correo,web) VALUES ("US7475251036","92121","Qualcomm",5775 ,"Estados Unidos","Morehouse Drive","858-587-1121 ","support@qualcomm.com","https://www.qualcomm.com/");
INSERT INTO fabricante (codigo,codigo_postal,nombre,numero,pais,calle,telefono,correo,web) VALUES ("RE8957215654","CB1 9NJ","Arm Limited",110 ,"Reino Unido","Fulbourn Road","+44 (1223) 400 400"," info@armreinounido.com","https://www.arm.com/");

INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (1,"1200","LGA","Q2'20"); 
-- Intel Core i9, i7, i5 11 gen, 10 gen (i3-10 gen)
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (2,"1449","BGA","Q1'21"); 
-- Intel Core i3 11 gen
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (3,"1151","LGA","Q2'19"); 
-- Intel Core 9 gen
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (4,"4189","LGA","Q3'19"); 
-- Xeon Platinum 3 gen, Xeon Gold 3 gen
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (5,"5903","BGA","Q2'19"); 
-- Xeon Platinum 2 gen
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (6,"3647","LGA","Q2'16");
-- Xeon Gold 2 gen
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (7,"AM4","PGA","Q3'16");
-- AMD Ryzen, Athlon
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (8,"TRX4","PGA","Q4'19");
-- Ryzen Threadripper 3 gen
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (9,"TR4","PGA","Q3'17");
-- Ryzen Threadripper 2 gen
INSERT INTO zocalo (id, tipo, tecnologia, fecha_lanzamiento) VALUES (10,"Personalizado","NaN","NaN");
-- Socket para ARM

-- placa base con tipo de socket lga 1200

INSERT INTO placa_base (id,id_socket,nombre) VALUES (1,1,"Gigabyte Ga-H310M-H");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (2,1,"Asus 1200 ROG STRIX B460-F");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (3,1,"Asus ROG MAXIMUS XII EXTREME");

-- placa base con tipo de socket lga 4189

INSERT INTO placa_base (id,id_socket,nombre) VALUES (4,4,"DellC27VV");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (5,4,"Supermicro MBD-X12SPA-TF");

-- placa base con tipo de socket lga 3647

INSERT INTO placa_base (id,id_socket,nombre) VALUES (6,6,"Supermicro X11DPi-N");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (7,6,"ASUS Z11PR-D16");

-- placa base con tipo de socket AM4

INSERT INTO placa_base (id,id_socket,nombre) VALUES (8,7,"Asus PRIME B450M-A II");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (9,7,"Asus ROG Strix X570-E Gaming");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (10,7,"Asus ROG Crosshair VIII Formula");

-- placa base con tipo de socket TRX4

INSERT INTO placa_base (id,id_socket,nombre) VALUES (11,8,"Msi TRX40 PRO");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (12,8,"Asus TRX4 PRIME TRX40-PRO");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (13,8,"ROG Zenith II Extreme");

-- placa base con tipo de socket TR4

INSERT INTO placa_base (id,id_socket,nombre) VALUES (14,9,"Gigabyte X399 Aorus PRO");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (15,9,"Asrock X399 Taichi");
INSERT INTO placa_base (id,id_socket,nombre) VALUES (16,9,"Asrock Fatal1ty X399");

INSERT INTO grafica_integrada (id,nombre_grafica,frec_basica,frec_max,memoria_max,resolucion) VALUES (1,"Intel UHD Graphics 750",0.35,1.30,64,"4K"); 
-- Intel Core 11 gen
INSERT INTO grafica_integrada (id,nombre_grafica,frec_basica,frec_max,memoria_max,resolucion) VALUES (2,"Intel UHD Graphics 630",0.35,1.20,64,"4K"); 
-- Intel Core 10,9 gen
INSERT INTO grafica_integrada (id,nombre_grafica,frec_basica,frec_max,memoria_max,resolucion) VALUES (3,"Radeon RX Vega 11 Graphics",0.35,1.30,64,"4K"); 
-- Ryzen 5 3400G
INSERT INTO grafica_integrada (id,nombre_grafica,frec_basica,frec_max,memoria_max,resolucion) VALUES (4,"Radeon Vega 8 Graphics",0.35,1.25,64,"1080p"); 
-- Ryzen 3 3200G
INSERT INTO grafica_integrada (id,nombre_grafica,frec_basica,frec_max,memoria_max,resolucion) VALUES (5,"Radeon Vega 3 Graphics",0.30,1.10,64,"1080p"); 
-- Ryzen Athlon

-- Intel i9
    -- 11 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (1,"US4581401001",1,2,"11900K","Q1'21",8,16,3.5,true,125,569.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (2,"US4581401001",1,2,"11900F","Q1'21",8,16,2.5,false,65,434.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (3,"US4581401001",1,2,"11900","Q1'21",8,16,2.5,false,65,444.90,true);
    -- 10 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (4,"US4581401001",1,3,"10900","Q2'20",10,20,2.8,false,65,409.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (5,"US4581401001",1,3,"10900K","Q2'20",10,20,3.7,true,125,429.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (6,"US4581401001",1,3,"10900F","Q2'20",10,20,2.8,false,65,389.90,false);
    -- 9 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (7,"US4581401001",3,4,"9900","Q2'19",8,16,3.1,false,65,339.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (8,"US4581401001",3,4,"9900K","Q4'18",8,16,3.6,true,95,349.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (9,"US4581401001",3,4,"9900KF","Q1'19",8,16,3.6,true,95,349.90,false);
-- Intel i7
    -- 11 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (10,"US4581401001",1,2,"11700F","Q1'21",8,16,2.5,false,65,309.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (11,"US4581401001",1,2,"11700","Q1'21",8,16,2.5,false,65,329.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (12,"US4581401001",1,2,"11700K","Q1'21",8,16,3.6,true,95,399.90,true);
    -- 10 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (13,"US4581401001",1,3,"10700","Q2'20",8,16,2.9,false,65,299.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (14,"US4581401001",1,3,"10700K","Q2'20",8,16,3.8,true,95,319.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (15,"US4581401001",1,3,"10700F","Q2'20",8,16,2.9,false,65,289.90,false);
    -- 9 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (16,"US4581401001",3,4,"9700K","Q4'18",8,8,3.6,true,95,274.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (17,"US4581401001",3,4,"9700F","Q2'19",8,8,3.0,false,65,262.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (18,"US4581401001",3,4,"9700","Q2'19",8,8,3.0,false,65,274.90,true);
-- Intel i5
    -- 11 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (19,"US4581401001",1,2,"11600","Q1'21",6,12,2.8,false,65,224.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (20,"US4581401001",1,2,"11600K","Q1'21",6,12,3.9,true,125,272.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (21,"US4581401001",1,2,"11600KF","Q1'21",6,12,3.9,true,125,247.90,false);
    -- 10 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (22,"US4581401001",1,3,"10505","Q1'21",6,12,3.2,false,65,209.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (23,"US4581401001",1,3,"10400F","Q2'20",6,12,2.9,false,65,169.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (24,"US4581401001",1,3,"10600K","Q2'20",6,12,4.1,true,125,199.90,true);
    -- 9 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (25,"US4581401001",3,4,"9600KF","Q1'19",6,6,3.7,true,95,178.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (26,"US4581401001",3,4,"9600","Q1'19",6,6,3.1,false,65,168.90,true);
-- Intel i3
    -- 11 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (27,"US4581401001",2,1,"1115G4E","Q3'20",2,4,2.2,false,15,285.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (28,"US4581401001",2,1,"1125G4","Q1'21",4,8,3.7,false,28,281.90,true);
    -- 10 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (29,"US4581401001",1,3,"10325","Q1'21",4,8,3.9,false,65,154.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (30,"US4581401001",1,3,"10105F","Q1'21",4,8,3.7,false,65,97.90,false);
    -- 9 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (31,"US4581401001",3,4,"9100","Q2'19",4,4,3.6,false,65,122.90,true);
-- Familia Xeon Platinum
    -- 3 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (32,"US4581401001",4,5,"8360Y","Q2'21",36,72,2.4,false,250,4702.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (33,"US4581401001",4,5,"8358","Q2'21",32,64,2.6,false,250,3950.90,false);
    -- 2 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (34,"US4581401001",5,6,"9222","Q3'19",32,64,2.3,false,250,3500.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (35,"US4581401001",5,6,"8284","Q2'19",28,56,3.0,false,240,3300.90,false);
-- Famila Xeon Gold
    -- 3 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (36,"US4581401001",4,5,"5315Y","Q2'21",8,16,3.2,false,140,895.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (37,"US4581401001",4,5,"6338","Q2'21",32,64,2.0,false,205,2612.90,false);
    -- 2 gen
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (38,"US4581401001",6,6,"6250","Q1'20",8,16,3.9,false,185,3400.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (39,"US4581401001",6,6,"5218R","Q1'20",20,40,2.1,false,125,1280.90,false);

-- AMD

-- Familia Ryzen 9
    -- Serie 5000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (40,"US0079031078",7,7,"5950X","Q2'20",16,32,3.4,true,105,829.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (41,"US0079031078",7,7,"5900X","Q2'20",12,24,3.7,true,105,549.90,false);
    -- Serie 3000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (42,"US0079031078",7,8,"3900X","Q3'19",12,24,3.8,true,105,438.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (43,"US0079031078",7,8,"3950X","Q3'19",16,32,3.5,true,105,749.90,false);
-- Familia Ryzen 7
    -- serie 5000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (44,"US0079031078",7,7,"5800X","Q2'20",8,16,3.8,true,105,443.95,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (45,"US0079031078",7,7,"5800","Q1'21",8,16,3.4,true,65,343.90,false);
    -- serie 3000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (46,"US0079031078",7,8,"3800X","Q3'19",8,16,3.9,true,105,258.90,false);
    -- serie 2000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (47,"US0079031078",7,9,"2700X","Q2'18",8,16,3.7,true,105,532.90,false);
-- Familia Ryzen 5
    -- serie 5000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (48,"US0079031078",7,7,"5600X","Q2'20",6,12,3.7,true,65,299.90,false);
    -- serie 3000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (49,"US0079031078",7,8,"3400G","Q3'19",4,8,3.7,true,65,260.90,true);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (50,"US0079031078",7,8,"3600X","Q3'19",6,12,3.8,true,95,259.90,false);
    -- serie 2000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (51,"US0079031078",7,9,"2600","Q2'18",6,12,3.4,true,65,164.90,false);
-- Familia Ryzen 3
    -- serie 3000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (52,"US0079031078",7,8,"3100","Q2'20",4,8,3.6,true,65,189.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (53,"US0079031078",7,8,"3200G","Q2'20",4,4,3.6,true,65,195.90,true);
-- Familia Ryzen Threadripper
    -- serie 3000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (54,"US0079031078",8,8,"3990X","Q3'20",64,128,2.9,true,280,4058.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (55,"US0079031078",8,8,"3960X","Q4'19",24,48,3.8,true,280,1376.90,false);
    -- serie 2000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (56,"US0079031078",9,9,"2950X","Q3'18",16,32,3.5,true,180,920.90,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (57,"US0079031078",9,9,"2920X","Q4'18",12,24,3.5,true,180,541.90,false);
-- Familia Athlon
    -- serie 3000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (58,"US0079031078",7,8,"320GE","Q3'19",2,4,3.5,false,35,90.90,true);
    -- serie 2000
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (59,"US0079031078",7,9,"240GE","Q4'18",2,4,3.5,false,35,75.90,true);

-- Qualcomm

-- Familia Kyro
    -- serie 600
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (60,"US7475251036",10,10,"680 Gold","Q3'20",4,8,2.8,false,10,0.0,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (61,"US7475251036",10,10,"670 Gold","Q2'20",4,8,2.5,false,10,0.0,false);
    -- serie 500
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (62,"US7475251036",10,11,"585","Q3'18",2,4,3.0,false,10,0.0,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (63,"US7475251036",10,11,"560","Q2'18",2,4,2.5,false,10,0.0,false);
    -- serie 500
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (64,"US7475251036",10,12,"495","Q3'16",2,4,2.0,false,12,0.0,false);
INSERT INTO procesador (id,codigo_fabricante,id_socket,id_arquitectura,modelo,fecha_lanzamiento,nucleos,hilos,frecuencia,overclock,tdp,precio,graficapropia) VALUES (65,"US7475251036",10,12,"470","Q2'16",2,4,1.8,false,12,0.0,false);

-- Intel Core 11 gen
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (1,1);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (3,1);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (11,1);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (12,1);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (19,1);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (20,1);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (27,1);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (28,1);
-- Intel Core 10,9 gen
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (4,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (5,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (7,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (8,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (13,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (14,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (16,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (18,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (22,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (24,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (26,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (29,2);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (31,2);
-- Ryzen 5 3400G
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (49,3);
-- Ryzen 3 3200G
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (53,4);
-- Athlon
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (58,5);
INSERT INTO procesador_grafica_integrada (id_procesador,id_grafica_integrada) VALUES (59,5);

drop trigger if exists procesador_trigger;

 delimiter //
 create trigger procesador_trigger
   after insert
   on procesador
   for each row
  begin
    if new.graficapropia=true then
      insert into procesador_grafica_integrada (id_procesador) VALUES (new.id);
    end if;
  end //
  delimiter ;




