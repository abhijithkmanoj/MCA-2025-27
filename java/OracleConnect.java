import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnect {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            String url = "jdbc:oracle:thin:@//localhost:1521/XE";
            String user = "system";
            String password = "manager";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}