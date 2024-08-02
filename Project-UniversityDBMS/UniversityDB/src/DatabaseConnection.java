import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/University";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Method to establish a database connection
    public static Connection connect() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection using the connection details
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
            return null; // Return null if connection fails
        }
    }

    public static void main(String[] args) {
        // Attempt to establish a database connection
        Connection connection = connect();
        // Check if the connection was successful
        if (connection != null) {
            System.out.println("Successfully connected to the database!");
        } else {
            System.out.println("Database connection failed.");
        }
    }
}
