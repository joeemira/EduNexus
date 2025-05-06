package login.application;

import java.sql.Connection;
import java.sql.SQLException;
import login.application.DBConnection; // ✅ Ensure this line is present

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.connect()) {
            if (conn != null) {
                System.out.println("Connected to PostgreSQL database!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
