/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.CategorieModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BABA SAIDOU DIEME
 */
public class categorie {
    
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public categorie(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    
     public boolean insertCategorie(CategorieModel categorie) throws SQLException {
        String sql = "INSERT INTO categorie (nomCategorie, description) VALUES (?,?);";
        connect();
        PreparedStatement statement= null;
        boolean rowInserted= false;
        try{
            statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, categorie.getNomCategorie());
            statement.setString(2, categorie.getDescription());
            rowInserted = statement.executeUpdate() > 0;
        }catch(SQLException e){
        }finally{
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException e){}
        }
        
        
        disconnect();
        return rowInserted;
    }

    public List<CategorieModel> getAllCategories() throws SQLException {
        List<CategorieModel> listCategorie = new ArrayList<>();
        String sql = "SELECT * FROM categorie";
        connect();
         Statement statement = null;
         ResultSet resultSet = null;
        try{
            statement = jdbcConnection.createStatement();
            resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idCategorie");
            String nomCategorie = resultSet.getString("nomCategorie");
            String description = resultSet.getString("description");
            CategorieModel categorie = new CategorieModel(id, nomCategorie, description);
            listCategorie.add(categorie);
        }
        }catch(SQLException e){
        }finally{
            try{
                if(resultSet!=null)
                    resultSet.close();
                if(statement!=null)
                    statement.close();
            }catch(SQLException ignore){
            }
        
        disconnect();
        }
       
        
        return listCategorie;
    }

    public boolean deleteCategorie(CategorieModel categorie) throws SQLException {
        String sql = "DELETE FROM categorie where idCategorie = ?";
        connect();
        PreparedStatement statement = null;
        boolean rowDeleted = false;
        try{
            statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, categorie.getIdCategorie());
            rowDeleted = statement.executeUpdate() > 0;
        }catch(SQLException e){
        }finally{
            try{
                if(statement != null)
                     statement.close();
            }catch(SQLException e){}
                
        }
       
       
        disconnect();
        return rowDeleted;

    }

    public boolean updateCategorie(CategorieModel categorie) throws SQLException {
        String sql = "UPDATE categorie SET nomCategorie = ?, description = ?";
        sql += " WHERE idcategorie = ?";
        connect();
        PreparedStatement statement = null;
         boolean rowUpdated = false;
        try{
            statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, categorie.getNomCategorie());
            statement.setString(2, categorie.getDescription());
            statement.setInt(3, categorie.getIdCategorie());
            rowUpdated = statement.executeUpdate() > 0;
        }catch(SQLException e){
        }finally{
            try{
                if(statement != null)
                     statement.close();
            }catch(SQLException e){}
        }
        disconnect();
        return rowUpdated;

    }

    public CategorieModel getOneCategorie(int id) throws SQLException {
        CategorieModel categorie = null;
        String sql = "SELECT * FROM categorie WHERE idcategorie = ?";

        connect();
        PreparedStatement statement = null ;
         ResultSet resultSet = null;
        try{
           statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nomCategorie = resultSet.getString("nomCategorie");
                String description = resultSet.getString("description");

                categorie = new CategorieModel(id, nomCategorie, description);
            } 
        }catch(SQLException e){
        }finally{
            try{
                if(statement != null)
                     statement.close();
                if(resultSet != null)
                    resultSet.close();
            }catch(SQLException e){}
        }
   
        return categorie;
    }
}
