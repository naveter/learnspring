package JavaEEWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {
        // Note: Change the connection parameters accordingly.
        String hostName = "localhost";
        String dbName = "postgres";
        String userName = "postgres";
        String password = "123456";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException,
            ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        // URL Connection for MySQL:
        // Example:
        // jdbc:mysql://localhost:3306/simplehr
        String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}
