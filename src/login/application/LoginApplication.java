package login.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginApplication {

    public static String currentUserRole = "";
    public static int currentUserId = -1;

    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("src/login/icon/logo3.png");
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setIconImage(image.getImage());
        LoginFrame.setLocationRelativeTo(null);
    }

    public static boolean authenticate(String username, String password) {
        String sql = "SELECT id, role FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password); // 🔐 Reminder: Use hashed passwords in production

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                currentUserId = rs.getInt("id");
                currentUserRole = rs.getString("role");

                // 🔁 Store username and ID in Tocken for use elsewhere
                Tocken.name = username;
                Tocken.id = currentUserId;

                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
            return false;
        }
    }
}
