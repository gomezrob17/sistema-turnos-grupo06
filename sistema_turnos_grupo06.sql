CREATE DATABASE IF NOT EXISTS sistema_turnos_grupo6;
USE sistema_turnos_grupo6;

-- Tabla Persona
CREATE TABLE persona (
    idPersona INT AUTO_INCREMENT PRIMARY KEY,
    dni INT NOT NULL,
    nombre VARCHAR(50),
    apellido VARCHAR(50)
);

-- Tabla Cliente (hereda de Persona)
CREATE TABLE cliente (
    idPersona INT PRIMARY KEY,
    fechaAlta DATE,
    activo BOOLEAN,
    FOREIGN KEY (idPersona) REFERENCES persona(idPersona)
);

-- Tabla Contacto (1:1 con Cliente)
CREATE TABLE contacto (
    idContacto INT PRIMARY KEY,
    email VARCHAR(100),
    telefono VARCHAR(30),
    FOREIGN KEY (idContacto) REFERENCES cliente(idPersona)
);

-- Tabla Profesional (hereda de Persona)
CREATE TABLE profesional (
    idPersona INT PRIMARY KEY,
    matricula VARCHAR(30),
    sueldo DOUBLE,
    activo BOOLEAN,
    FOREIGN KEY (idPersona) REFERENCES persona(idPersona)
);

-- Tabla Especialidad
CREATE TABLE especialidad (
    idEspecialidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

-- Tabla intermedia: profesional_especialidad (N:N)
CREATE TABLE profesional_especialidad (
    idProfesional INT,
    idEspecialidad INT,
    PRIMARY KEY (idProfesional, idEspecialidad),
    FOREIGN KEY (idProfesional) REFERENCES profesional(idPersona),
    FOREIGN KEY (idEspecialidad) REFERENCES especialidad(idEspecialidad)
);

-- Tabla EstadoTurno
CREATE TABLE estadoturno (
    idEstado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30)
);

-- Tabla Sucursal
CREATE TABLE sucursal (
    idSucursal INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    direccion VARCHAR(100)
);

-- Tabla Turno
CREATE TABLE turno (
    idTurno INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    hora TIME,
    idCliente INT,
    idProfesional INT,
    idEstado INT,
    idSucursal INT,
    FOREIGN KEY (idCliente) REFERENCES cliente(idPersona),
    FOREIGN KEY (idProfesional) REFERENCES profesional(idPersona),
    FOREIGN KEY (idEstado) REFERENCES estadoturno(idEstado),
    FOREIGN KEY (idSucursal) REFERENCES sucursal(idSucursal)
);
