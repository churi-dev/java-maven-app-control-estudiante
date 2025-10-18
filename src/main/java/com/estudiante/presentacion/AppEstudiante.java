package com.estudiante.presentacion;

import com.estudiante.datos.EstudianteDAO;
import com.estudiante.dominio.Estudiante;

import java.util.List;
import java.util.Scanner;

public class AppEstudiante {

    public static void main(String[] args) {
        App();
    }

    public static void App() {

        Scanner teclado = new Scanner(System.in);
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        boolean isSalir = false;
        int opcion = 0;

        while (!isSalir) {

            try {
                Menu();
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1: {
                        ListarEstudiante(estudianteDAO);
                        break;
                    }
                    case 2: {
                        BuscarEstudiante(teclado, estudianteDAO);
                        break;
                    }
                    case 3: {
                        AgregarEstudiante(teclado, estudianteDAO);
                        break;
                    }
                    case 4: {
                        ActualizarEstudiante(teclado, estudianteDAO);
                        break;
                    }
                    case 5: {
                        EliminarEstudiante(teclado, estudianteDAO);
                        break;
                    }
                    case 6: {
                        System.out.println("Cerrando sistema estudiantes...!");
                        isSalir = true;
                    }
                    default: {
                        System.out.println("Opción no encontrada.");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ser un valor numerico");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    private static void ListarEstudiante(EstudianteDAO estudianteDAO) {
        System.out.println("-> Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDAO.ListarEstudiante();
        estudiantes.forEach(System.out::println);
        System.out.println();
    }

    private static void BuscarEstudiante(Scanner teclado, EstudianteDAO estudianteDAO) {
        System.out.println("Ingrese id del estudiante: ");
        var id = Integer.parseInt(teclado.nextLine());

        Estudiante estudiante = estudianteDAO.BuscarEstudianteById(id);

        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante);
        } else {
            System.out.println("Estudiante no encontrado: " + id);
        }
    }

    private static void AgregarEstudiante(Scanner teclado, EstudianteDAO estudianteDAO) {
        System.out.println("Ingrese nombre: ");
        var nombre = teclado.nextLine();
        System.out.println("Ingrese apellido: ");
        var apellido = teclado.nextLine();
        System.out.println("Ingrese telefono: ");
        var telefono = teclado.nextLine();
        System.out.println("Ingrese email: ");
        var email = teclado.nextLine();

        var nuevoEstudiante = new Estudiante(nombre, apellido, telefono, email);

        var agregado = estudianteDAO.InsertarEstudiante(nuevoEstudiante);

        if (agregado) {
            System.out.println("Agregado: " + nuevoEstudiante);
        } else {
            System.out.println("No se pudo agregar estudiante.");
        }
    }

    private static void ActualizarEstudiante(Scanner teclado, EstudianteDAO estudianteDAO) {
        System.out.println("Ingrese id del estudiante: ");
        var id = Integer.parseInt(teclado.nextLine());

        System.out.println("Ingrese nombre: ");
        var nombre = teclado.nextLine();
        System.out.println("Ingrese apellido: ");
        var apellido = teclado.nextLine();
        System.out.println("Ingrese telefono: ");
        var telefono = teclado.nextLine();
        System.out.println("Ingrese email: ");
        var email = teclado.nextLine();

        var nuevoEstudiante = new Estudiante(id, nombre, apellido, telefono, email);

        var agregado = estudianteDAO.ActualizarEstudiante(nuevoEstudiante);

        if (agregado) {
            System.out.println("Actualizado: " + nuevoEstudiante);
        } else {
            System.out.println("No se pudo agregar estudiante.");
        }
    }

    private static void EliminarEstudiante(Scanner teclado, EstudianteDAO estudianteDAO) {
        System.out.println("Ingrese id del estudiante: ");
        var id = Integer.parseInt(teclado.nextLine());
        var estudiante = new Estudiante(id);
        var eliminado = estudianteDAO.ELiminarEstudiante(estudiante);
        if (eliminado) {
            System.out.println("Eliminado: " + estudiante);
        } else {
            System.out.println("No se pudo eliminar estudiante: " + estudiante);
        }
    }

    private static void Menu() {
        String menuOpciones =
                """
                **** Sistema de estudiantes ****
                1. Listar estudiantes
                2. Buscar estudiantes
                3. Agregar estudiantes
                4. Modificar estudiantes
                5. Eliminar estudiantes
                6. Salir
                
                Selecciona opcion: 
                """;
        System.out.print(menuOpciones);
    }
}
