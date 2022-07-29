/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.UserModel;

/**
 *
 * @author BABA SAIDOU DIEME
 */
public class user extends connexionDB {
   
     public boolean register(UserModel user) throws SQLException {
        String sql = "INSERT INTO user (nom, prenom, email, password, role) VALUES (?,?,?,?,?,?,?);";
        connect();
        PreparedStatement statement = null;
        boolean rowInserted = false;
        try{
            statement = connexion.prepareStatement(sql);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(2, user.getRole());
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