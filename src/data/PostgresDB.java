package data;

import data.interfaces.IDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class
PostgresDB implements IDB {
    private static final String connectionURL = "jdbc:postgresql://localhost:5432/simpledb";
    private static final String user = "postgres";
    private static final String password = "Beksss06";
    private static PostgresDB instance = null;
    private static Connection singleInstance = null;

    private PostgresDB() {
    }

    public static synchronized PostgresDB getInstance() {
        if (instance == null) {
            instance = new PostgresDB();
        }
        return instance;
    }
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (singleInstance == null || singleInstance.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                singleInstance = DriverManager.getConnection(connectionURL, user, password);
            } catch (SQLException e) {
                System.out.println("Database connection failure: " + e.getMessage());
                return null;
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver not found: " + e.getMessage());
                return null;
            }
        }
        return singleInstance;
    }
}
