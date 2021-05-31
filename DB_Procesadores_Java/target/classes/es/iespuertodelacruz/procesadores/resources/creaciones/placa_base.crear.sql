CREATE TABLE placa_base (
  id INT PRIMARY KEY,
  id_socket int,
  nombre varchar (100),
FOREIGN KEY (id_socket) REFERENCES zocalo(id)
);