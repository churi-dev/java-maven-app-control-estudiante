package com.estudiante.datos;

import com.estudiante.conexion.Conexion;
import com.estudiante.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class EstudianteDAO {

    public List<Estudiante> ListarEstudiante() {
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();

        // preparar la consulta a bd
        PreparedStatement ps;
        // guardaar el resultado de la consulta
        ResultSet res;

        // conexion a bd
        Connection conn = Conexion.getConnection();

        // consulta bd mysql
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";

        try {
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();

            // iterar cada registro
            while (res.next()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(res.getInt("id_estudiante"));
                estudiante.setNombre(res.getString("nombre"));
                estudiante.setApellido(res.getString("apellido"));
                estudiante.setTelefono(res.getString("telefono"));
                estudiante.setEmail(res.getString("email"));

                // agregamos cada estudiante
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al consultar el registro: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }

        return estudiantes;
    }

    public Estudiante BuscarEstudianteById(int id) {

        Estudiante estudiante = null;

        PreparedStatement ps;
        ResultSet res;
        Connection conn = Conexion.getConnection();

        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeQuery();

            while (res.next()) {
                estudiante = new Estudiante();
                estudiante.setIdEstudiante(res.getInt("id_estudiante"));
                estudiante.setNombre(res.getString("nombre"));
                estudiante.setApellido(res.getString("apellido"));
                estudiante.setTelefono(res.getString("telefono"));
                estudiante.setEmail(res.getString("email"));
                return estudiante;
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error al consultar el registro: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }

        return estudiante;
    }

    public boolean InsertarEstudiante(Estudiante estudiante) {

        PreparedStatement ps;
        Connection conn = Conexion.getConnection();
        String sql = "INSERT INTO estudiante(nombre, apellido, telefono, email) VALUES(?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute(); // solo insertar no devolver datos

            return true;

        } catch (Exception e) {
            System.out.println("Ocurrio un error al insertar el registro: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }

        }

        return false;
    }

    public boolean ActualizarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection conn = Conexion.getConnection();
        String sql = "UPDATE estudiante SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE id_estudiante = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Ocurrio un error al actualizar el registro: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }

        return false;
    }

    public boolean ELiminarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection conn = Conexion.getConnection();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Ocurrio un error al eliminar el registro: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }
}
