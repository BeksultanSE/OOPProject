package data;

import data.interfaces.IDB;

import java.sql.*;
public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/simpledb";
        try {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionURL, "postgres", "0000");

            return con;
        }
        catch (SQLException e){
            System.out.println("Some SQL error: " + e);
            return null;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}