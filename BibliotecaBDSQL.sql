--
-- File generated with SQLiteStudio v3.2.1 on vi. abr. 24 22:09:17 2020
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Gestor
CREATE TABLE Gestor (Cod_Gestor INTEGER PRIMARY KEY UNIQUE NOT NULL, email CHAR UNIQUE NOT NULL, Nombre CHAR NOT NULL, Apellidos CHAR NOT NULL, Telefono INTEGER, Contrasenya CHAR NOT NULL);
INSERT INTO Gestor (Cod_Gestor, email, Nombre, Apellidos, Telefono, Contrasenya) VALUES (0, 'admin@gmail.com', 'admin', 'admin', 635831684, 'admin');

-- Table: Libro
CREATE TABLE Libro (Cod_Libro INTEGER PRIMARY KEY NOT NULL UNIQUE, Titulo CHAR NOT NULL, Autor CHAR NOT NULL, Genero CHAR NOT NULL, Reserva_Max INTEGER NOT NULL);
INSERT INTO Libro (Cod_Libro, Titulo, Autor, Genero, Reserva_Max) VALUES (1, 'AA', 'AA', 'AA', 12);
INSERT INTO Libro (Cod_Libro, Titulo, Autor, Genero, Reserva_Max) VALUES (2, 'El Quijjote', 'Cervantes', 'Novela historica', 3);

-- Table: Reserva_Libro
CREATE TABLE Reserva_Libro (Cod_Reserva INTEGER PRIMARY KEY NOT NULL UNIQUE, Cod_Usuario INTEGER REFERENCES Usuario (Cod_Usuario) ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, Cod_Libro INTEGER REFERENCES Libro (Cod_Libro) ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, Fecha_Devolucion DATE NOT NULL);
INSERT INTO Reserva_Libro (Cod_Reserva, Cod_Usuario, Cod_Libro, Fecha_Devolucion) VALUES (1, 0, 1, 'Sun Apr 26 18:38:49 CEST 2020');
INSERT INTO Reserva_Libro (Cod_Reserva, Cod_Usuario, Cod_Libro, Fecha_Devolucion) VALUES (2, 0, 1, 'Tue May 05 19:06:38 CEST 2020');

-- Table: Reserva_Sala
CREATE TABLE Reserva_Sala (Cod_Reserva INTEGER PRIMARY KEY NOT NULL UNIQUE, Cod_Usuario INTEGER REFERENCES Usuario (Cod_Usuario) ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, Cod_Sala INTEGER REFERENCES Sala (Cod_Sala) ON DELETE CASCADE ON UPDATE CASCADE NOT NULL, Fecha DATE NOT NULL, Calefaccion BOOLEAN);
INSERT INTO Reserva_Sala (Cod_Reserva, Cod_Usuario, Cod_Sala, Fecha, Calefaccion) VALUES (1, 0, 1, 'Sun Apr 19 19:52:41 CEST 2020', 'true');
INSERT INTO Reserva_Sala (Cod_Reserva, Cod_Usuario, Cod_Sala, Fecha, Calefaccion) VALUES (2, 0, 1, 'Fri Apr 24 19:06:43 CEST 2020', 'false');

-- Table: Sala
CREATE TABLE Sala (Cod_Sala INTEGER PRIMARY KEY NOT NULL UNIQUE, Ubicacion STRING NOT NULL, Usuarios INTEGER NOT NULL);
INSERT INTO Sala (Cod_Sala, Ubicacion, Usuarios) VALUES (1, 'Piso 1', 4);
INSERT INTO Sala (Cod_Sala, Ubicacion, Usuarios) VALUES (2, 'Piso 1', 5);
INSERT INTO Sala (Cod_Sala, Ubicacion, Usuarios) VALUES (3, 'Piso 2', 5);
INSERT INTO Sala (Cod_Sala, Ubicacion, Usuarios) VALUES (4, 'Piso 2', 6);
INSERT INTO Sala (Cod_Sala, Ubicacion, Usuarios) VALUES (5, 'Piso 3', 10);

-- Table: Usuario
CREATE TABLE Usuario (Cod_Usuario INTEGER PRIMARY KEY, email CHAR, Nombre CHAR, Apellidos CHAR, Telefono INTEGER, Contrasenya CHAR);
INSERT INTO Usuario (Cod_Usuario, email, Nombre, Apellidos, Telefono, Contrasenya) VALUES (1, 'a@a.com', 'AA', 'AA', 123456, '123');
INSERT INTO Usuario (Cod_Usuario, email, Nombre, Apellidos, Telefono, Contrasenya) VALUES (2, 'b@b.com', 'BB', 'BB', 1234556, '123');
INSERT INTO Usuario (Cod_Usuario, email, Nombre, Apellidos, Telefono, Contrasenya) VALUES (3, 'a@aa.com', 'a', 'a', 123, '123');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
