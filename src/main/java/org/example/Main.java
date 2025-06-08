package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        // Crear un objeto Profesor y agregarlo a la lista
        Profesor profesor = new Profesor();


        // Establecer la conexión a la base de datos.
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();

        //crear un DAO y guardar el profesor en la base de datos
        DAO dao = new DAO();
        dao.guardar(profesor, connection);

        // Aquí podrías cerrar la conexión si es necesario
        connectionDB.closeConnection(connection);

        // Agregar el profesor al array y mostrar los registros.
        profesor.agregar();
        profesor.llenarAutomaticamente();
        profesor.imprimirRegistros();
    }
}
