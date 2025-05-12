package login.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

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
    String sql = "SELECT id, password, role FROM users WHERE username = ?";

    try (Connection conn = DBConnection.connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String storedHashedPassword = rs.getString("password");

            // 🔐 Compare entered password with hashed password
            if (BCrypt.checkpw(password, storedHashedPassword)) {
                currentUserId = rs.getInt("id");
                currentUserRole = rs.getString("role");

                Tocken.name = username;
                Tocken.id = currentUserId;

                return true;
            }
        }

        return false;

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        return false;
    }
}

}
