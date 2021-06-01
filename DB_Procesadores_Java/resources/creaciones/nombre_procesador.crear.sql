CREATE TABLE IF NOT EXISTS nombre_procesador (
  modelo_procesador varchar(20) PRIMARY KEY,
  familia varchar(30),
  generacion int(10) DEFAULT 1
);