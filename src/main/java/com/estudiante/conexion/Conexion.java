package com.estudiante.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String baseDatos = "nombre_bd_aqui";
    private static final String url = "jdbc:mysql://localhost:3306/" + baseDatos;
    private static final String usuario = "usuario_aqui";
    private static final String constrasenia = "constrasenia_aqui";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // cargar clase de driver de mysql en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, constrasenia);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en conexion: " + e.getMessage());
        }

        return connection;
    }
}
