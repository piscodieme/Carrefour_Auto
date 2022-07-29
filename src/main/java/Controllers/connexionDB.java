/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author BABA SAIDOU DIEME
 */
public class connexionDB {
    
    protected String DBUrl = "jdbc:mysql://localhost:3306/ecommerce";
    protected String userName = "root";
    protected String password = "";
    protected Connection connexion; 
    
    public connexionDB(String dburl, String user, String password){
            
        this.DBUrl = dburl;
        this.userName = user;
        this.password = password;
            
    }
    //Methode de connexion à la base de données
    protected void connect() throws SQLException {
        if (connexion == null || connexion.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connexion = DriverManager.getConnection(DBUrl, userName, password);
        }
    }
    // Methode de déconnexion à la base de données
    protected void disconnect() throws SQLException {
        if (connexion != null && !connexion.isClosed()) {
            connexion.close();
        }
    }
    
    
}
