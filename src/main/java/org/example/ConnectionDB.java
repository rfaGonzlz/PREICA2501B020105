package org.example;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection getConnection() {
        // URL de conexión a la base de datos SQL Server.
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Profesores;encrypt=true;trustServerCertificate=true";

// Credenciales de acceso a la base de datos.
        String usuario = "rfagnzlz";
        String contraseña = "123456789";

        // Cargar el driver de SQL Server.
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            if (conexion != null) {
                System.out.println("✅ Conexión exitosa a la base de datos SQL Server.");
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




