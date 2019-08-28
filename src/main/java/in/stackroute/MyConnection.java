package in.stackroute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://172.18.0.2:3306/demo";

    public static void registerDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        String username = "root";
        String password = "root";

        registerDriver();

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, username, password);
            System.out.println("Database connected.");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        return connection;
    }
}
