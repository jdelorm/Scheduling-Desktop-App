package delorme.john.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author John DeLorme
 * JDBC method per webinar series to connect to the mysql database
 */

public class JDBC {

    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
    private static final String userName = "sqlUser"; // Username
    private static String password = "Passw0rd!"; // Password
    public static Connection connection;  // Connection Interface

    /**
     * Method that opens the connection to the database
     */

    public static void openConnection() {

        try {

            Class.forName(driver); // Locate Driver
            connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
            System.out.println("Connection successful!");

        }

        catch(Exception e) {

            System.out.println("Error:" + e.getMessage());

        }
    }

    /**
     * Method that closes the connection to the database
     */

    public static void closeConnection() {

        try {

            connection.close();
            System.out.println("Connection closed!");

        }

        catch(Exception e) {

            System.out.println("Error:" + e.getMessage());

        }
    }

    /**
     * Getter method for connection
     * @return
     */

    public static Connection getConnection() {

        return connection;
    }

    /**
     * Getter method for PreparedStatement
     * @return
     */

    public static PreparedStatement getPreparedStatement() {

        return statement;

    }

    private static PreparedStatement statement;

    /**
     * Setter method for PreparedStatement
     * @param connection
     * @param sqlDbStatement
     * @throws SQLException
     */

    public static void setPreparedStatement(Connection connection, String sqlDbStatement) throws SQLException {

        statement = connection.prepareStatement(sqlDbStatement);

    }
}


