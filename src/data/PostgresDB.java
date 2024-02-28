package data;

import data.interfaces.IDB;

import java.sql.*;
public class PostgresDB implements IDB {
    private static PostgresDB instance;
    private Connection connection;

    private PostgresDB() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/simpledb";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL, "postgres", "Beksss06");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static PostgresDB getInstance(){
        try{
            if (instance == null) {
                instance = new PostgresDB();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}