package org.example;

import java.sql.Connection;
import java.util.Scanner;


// Clase Profesor que hereda de la clase Persona y representa a un profesor con sus atributos y métodos.
public class Profesor extends Persona {

    // Atributos de la clase Profesor.
    private int contador = 0;
    private String asignatura;
    private Profesor[] profesores = new Profesor[50];
    Scanner sc = new Scanner(System.in);

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
//
//
//        String respuesta = "";
//        // Bucle para solicitar los datos del profesor hasta que el usuario decida no agregar más.
//        do {
//
//            System.out.println("Ingrese el nombre del profesor:");
//            profesor.setNombre(sc.nextLine());
//            System.out.println("Ingrese el apellido del profesor:");
//            profesor.setApellido(sc.nextLine());
//            System.out.println("Ingrese la fecha de nacimiento del profesor (dd/mm/yyyy):");
//            profesor.setFechaNacimiento(sc.nextLine());
//            System.out.println("Ingrese el género del profesor:");
//            profesor.setGenero(sc.nextLine());
//            System.out.println("Ingrese la estatura del profesor (en metros):");
//            profesor.setEstatura(sc.nextDouble());
//            System.out.println("Ingrese el peso kg del profesor:");
//            profesor.setPeso(sc.nextDouble());
//            sc.nextLine(); // Limpiar el buffer del scanner
//            System.out.println("Ingrese la asignatura que imparte el profesor:");
//            profesor.setAsignatura(sc.nextLine());
//
//
//            System.out.println("Desea agregar un nuevo profesor? (SI/NO)");
//            respuesta = sc.nextLine().toUpperCase();
//
//            if (respuesta.equals("SI")) {
//
//                DAO dao = new DAO();
//                Connection connection = new ConnectionDB().getConnection();
//                dao.guardar(profesor, connection);
//
//            }
//
//        } while (!respuesta.equals("NO"));


        if (contador < profesores.length) {
            profesores[contador] = profesor;
            contador++;
        } else {
            System.out.println("No se pueden agregar más profesores. Límite alcanzado.");
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