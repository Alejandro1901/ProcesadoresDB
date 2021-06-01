CREATE TABLE IF NOT EXISTS zocalo (
  id INT PRIMARY KEY,
  tipo VARCHAR(30),
  tecnologia VARCHAR(20) NOT NULL,
  fecha_lanzamiento VARCHAR(10)
);