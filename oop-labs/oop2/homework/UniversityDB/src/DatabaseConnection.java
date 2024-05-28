import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/University";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = connect();
        if (connection != null) {
            System.out.println("Successfully connected to the database!");
        } else {
            System.out.println("Database connection failed.");
        }
    }
}
