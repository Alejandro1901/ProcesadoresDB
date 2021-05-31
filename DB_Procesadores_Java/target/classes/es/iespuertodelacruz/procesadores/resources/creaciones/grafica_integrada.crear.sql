CREATE TABLE grafica_integrada (
  id INT PRIMARY KEY,
  nombre_grafica varchar(100),
  frec_basica float,
  frec_max float,
  memoria_max int,
  resolucion ENUM('720p','1080p','2K','4K','8K','16K')
);