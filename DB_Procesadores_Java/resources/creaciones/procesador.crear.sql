CREATE TABLE IF NOT EXISTS procesador (
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