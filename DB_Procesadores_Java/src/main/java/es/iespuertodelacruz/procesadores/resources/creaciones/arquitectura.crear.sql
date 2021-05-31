CREATE TABLE IF NOT EXISTS arquitectura (
  id INT PRIMARY KEY,
  version_arquitectura ENUM('ARM','x86-64'),
  disenio varchar(20),
  tecnologia ENUM('Thumb','Jazelle','No tiene') DEFAULT 'No tiene',
  estandar ENUM('AMD 64','Intel 64','No tiene') DEFAULT 'No tiene'
);