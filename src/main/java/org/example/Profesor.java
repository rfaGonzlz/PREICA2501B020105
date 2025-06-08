package org.example;

import java.sql.Connection;
import java.util.Scanner;


// Clase Profesor que hereda de la clase Persona y representa a un profesor con sus atributos y métodos.
public class Profesor extends Persona {

    // Atributos de la clase Profesor.
    private int contador = 0;
    private String asignatura;
    private Profesor[] profesores = new Profesor[50];

    // Constructor por defecto que inicializa un objeto Profesor sin parámetros.
    public Profesor() {
    }

    // Constructor que recibe los parámetros necesarios para crear un objeto Profesor.
    public Profesor(String nombre, String apellido, String fechaNacimiento, String genero, double estatura, double peso, String asignatura) {
        super(nombre, apellido, fechaNacimiento, genero, estatura, peso);
        this.asignatura = asignatura;
    }

    // Getters y Setters para la asignatura.
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    // Metodo para agregar un profesor al array de profesores.
    public void agregar(Profesor profesor) {
        if (contador < profesores.length) {
            profesores[contador] = profesor;
            contador++;
        } else {
            System.out.println("No se pueden agregar más profesores. Límite alcanzado.");
        }
    }

    public void llenarAutomaticamente() {
        DAO dao = new DAO();
        Connection connection = new ConnectionDB().getConnection();
        for (int i = 0; i < profesores.length; i++) {
            Profesor p = new Profesor(
                    "Nombre" + (i + 1),
                    "Apellido" + (i + 1),
                    "01/01/1980",
                    i % 2 == 0 ? "Masculino" : "Femenino",
                    1.70 + (i % 10) * 0.01, // Estatura variada
                    70 + (i % 10),          // Peso variado
                    "Asignatura" + ((i % 5) + 1) // Asignaturas del 1 al 5
            );
            agregar(p);
            dao.guardar(p, connection);
        }
    }


    // Método para imprimir los registros de los profesores.
    public void imprimirRegistros() {

        System.out.println("\t----------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\tREGISTRO DE PROFESORES");
        System.out.println("\t----------------------------------------------------------------------------------------------------------------");

        // Encabezado de la tabla
        System.out.printf("\t%-15s %-15s %-25s %-13s %-15s %-10s %-15s \n",
                "Nombre", "Apellido", "Fecha de Nacimiento", "Género", "Estatura", "Peso", "Asignatura");

        System.out.println("\t----------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < contador; i++) {

            Profesor p = profesores[i];

            System.out.printf("\t%-15s %-20s %-20s %-14s %-14.5f %-10.2f %-15s\n",
                    p.getNombre().toUpperCase(), p.getApellido().toUpperCase(), p.getFechaNacimiento(),
                    p.getGenero().toUpperCase(), p.getEstatura(), p.getPeso(), p.asignatura.toUpperCase());
            System.out.println("\t----------------------------------------------------------------------------------------------------------------");
        }


    }

}