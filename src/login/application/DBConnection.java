package login.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/edunexus";  // ← your database name
        String user = "postgres";         // ← your actual PostgreSQL username
        String password = "password"; // ← your actual password

        return DriverManager.getConnection(url, user, password);
    }
}
