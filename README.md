# Sistema de Control de Estudiantes (Java + MySQL + DAO)

Este proyecto es una **aplicación de consola desarrollada en Java**, que implementa un sistema CRUD (Crear, Leer, Actualizar y Eliminar) para la gestión de estudiantes.  
Está construido siguiendo el **patrón DAO (Data Access Object)** para separar la lógica de negocio del acceso a datos, y utiliza **MySQL** como base de datos relacional.  
Se ejecuta desde consola y permite interactuar con los registros de estudiantes de manera sencilla.

---

## Características principales

- Arquitectura basada en el patrón **DAO**
- Conexión a **base de datos MySQL**
- Operaciones completas **CRUD**
- Implementación modular con clases separadas por responsabilidad
- Uso de **JDBC** y **PreparedStatement** para la gestión segura de consultas
- Proyecto gestionado con **Maven**

---

## Funcionalidades

### 1. Listar todos los estudiantes
Obtiene y muestra todos los registros existentes en la base de datos ordenados por su ID.

### 2. Buscar estudiante por su ID
Permite consultar un estudiante por su ID

### 3. Insertar un nuevo estudiante
Insertar un nuevo registro en la base de datos

### 4. Actualizar un estudiante
Actualizar los valores de un estudiante ya existente en la base de datos

### 5. Eliminar un estudiante
Eliminar un registro de estudiante por su ID ya existente en la base de datos

## Modelo de datos

```sql
CREATE DATABASE control_estudiantes;

USE control_estudiantes;

CREATE TABLE estudiante (
  id_estudiante INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  apellido VARCHAR(100),
  telefono VARCHAR(20),
  email VARCHAR(100)
);
```
## Configuración del entorno
- Java 21 o superior 
- Maven 3+ 
- MySQL Server 8+
- IDE recomendado: IntelliJ IDEA

## Configuración de conexión
Edita la clase Conexion.java con tus credenciales de base de datos:

```java
private static final String baseDatos = "nombre_bd_aqui";
private static final String url = "jdbc:mysql://localhost:3306/" + baseDatos;
private static final String usuario = "usuario_aqui";
private static final String constrasenia = "constrasenia_aqui";
```

---

##  < Autor />

Desarrollado por: churi-dev

---


