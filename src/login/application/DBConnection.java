package login.application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://ep-young-bonus-a8lofcew-pooler.eastus2.azure.neon.tech:5432/edunexus?sslmode=require";
            String user = "edunexus_owner";
            String password = "npg_TEpwl34HvFWt";

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
