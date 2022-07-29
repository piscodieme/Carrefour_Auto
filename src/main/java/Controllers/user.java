/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BABA SAIDOU DIEME
 */
public class user {
    
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public user(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
   
     public boolean register(UserModel user) throws SQLException {
        String sql = "INSERT INTO user (nom, prenom, email, password, role) VALUES (?,?,?,?,?);";
        connect();
        PreparedStatement statement = null;
        boolean rowInserted = false;
        try{
            statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            rowInserted = statement.executeUpdate() > 0;
        }catch(SQLException e){}
        finally{
            try{
                if(statement != null)
                    statement.close();
            }catch(SQLException i){}
        }
       
        
        disconnect();
        return rowInserted;
    }
}