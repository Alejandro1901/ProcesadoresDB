CREATE TABLE IF NOT EXISTS fabricante (
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