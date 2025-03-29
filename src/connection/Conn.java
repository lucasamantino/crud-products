package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    private static final String url = System.getProperty("DB_URL");
    private static final String user = System.getProperty("DB_USER");
    private static final String pass = System.getProperty("DB_PASSWORD");

    private static Connection connection;

    public static Connection getConn () {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url,user,pass);
                return connection;
            } else {
                return connection;
            }
        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
            return null;
        }
    }

}
