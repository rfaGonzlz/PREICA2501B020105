package org.example;

// Clase persona que hereda de PersonaAbstract.
public class Persona extends PersonaAbstract{

    // Constructor por defecto.
    public Persona() {

    }

// Constructor con parámetros.
    public Persona(String nombre, String apellido, String fechaNacimiento, String genero, double estatura, double peso) {
        super(nombre, apellido, fechaNacimiento, genero, estatura, peso);
    }

    // Implementación de los métodos abstractos de la clase PersonaAbstrac.
    @Override
    public void agregar() {
        // Implementación del método para agregar.
    }
    @Override
    public void imprimirRegistros() {
        // Implementación del método para imprimir los registros guardados.
    }
}
