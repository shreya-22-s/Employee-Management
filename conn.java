package employee.management.system;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
public class conn {
    Connection connection;
    Statement statement;
    public conn() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Try to connect to the database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/employeemanagement?useSSL=false&serverTimezone=UTC",
                    "root",
                    "Srishti@22"
            );

            // Create statement for executing queries
            statement = connection.createStatement();

            // Success message to verify connection
            System.out.println("Database connected successfully!");

        } catch (Exception e) {
            //  Show clear error message
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
