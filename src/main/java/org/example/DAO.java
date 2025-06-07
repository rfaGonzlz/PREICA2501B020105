package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

public class DAO {

    /**
     * Método para guardar un objeto Profesor en la base de datos.
     *
     * @param profesor   El objeto Profesor a guardar.
     * @param connection La conexión a la base de datos.
     */
    public void guardar(Profesor profesor, Connection connection) {
        // Script SQL para insertar un nuevo registro en la tabla Profesores.
        String sql = "INSERT INTO Profesores (nombre, apellido, fechaNacimiento, genero, estatura, peso, asignatura) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Preparar la sentencia SQL para evitar inyecciones SQL.
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, profesor.getNombre());
            pstmt.setString(2, profesor.getApellido());
            // Convertir la fecha de nacimiento de String a java.sql.Date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(profesor.getFechaNacimiento(), formatter);
            Date sqlDate = Date.valueOf(localDate);

            pstmt.setDate(3, sqlDate);
            pstmt.setString(4, profesor.getGenero());
            pstmt.setDouble(5, profesor.getEstatura());
            pstmt.setDouble(6, profesor.getPeso());
            pstmt.setString(7, profesor.getAsignatura());
            pstmt.executeUpdate();

            System.out.println("Guardado exitosamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar en la base de datos: " + e.getMessage());
        }
    }
}




