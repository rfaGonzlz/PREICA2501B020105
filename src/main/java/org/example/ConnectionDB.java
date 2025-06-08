package org.example;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection getConnection() {
        // URL de conexión a la base de datos postgres.
        String url = "jdbc:postgresql://localhost:5432/postgres";

// Credenciales de acceso a la base de datos.
        String usuario = "postgres";
        String contraseña = "12345";

        // Cargar el driver de postgres.
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            if (conexion != null) {
                System.out.println("✅ Conexión exitosa a la base de datos postgres.");
                return conexion;
            } else {
                System.out.println("⚠️ La conexión es nula. Revisa los parámetros.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos:");
            System.out.println(e.getMessage());
            return null;

        }

    }

    // Método para cerrar la conexión a la base de datos.
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("🔒 Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("❌ Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}




