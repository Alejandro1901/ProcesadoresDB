CREATE TABLE procesador_grafica_integrada (
  id_procesador INT,
  id_grafica_integrada int,
FOREIGN KEY (id_procesador) REFERENCES procesador(id),
FOREIGN KEY (id_grafica_integrada) REFERENCES grafica_integrada(id)
);