package org.example;

// Clase abstracta que define los métodos a implementar.
public abstract class  PersonaAbstract{

    // Atributos de la clase PersonaAbstract.
    private String nombre, apellido, fechaNacimiento, genero;
    private double estatura,peso;

    // Constructor por defecto y constructor con parámetros.
    public PersonaAbstract() {
    }


    // Constructor con parámetros para inicializar los atributos.
    public PersonaAbstract(String nombre, String apellido, String fechaNacimiento, String genero,double estatura, double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estatura = estatura;
        this.peso = peso;
    }

    // Métodos getter y setter para acceder y modificar los atributos.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    // Métodos abstractos que deben ser implementados por las subclases.
    public void agregar(){}

    public void imprimirRegistros(){}
}
