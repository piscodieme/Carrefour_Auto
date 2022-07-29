/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.VoitureModel;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author BABA SAIDOU DIEME
 */
public class voiture {
    
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public voiture(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    
    public boolean insertVoiture(VoitureModel voiture,HttpServletRequest request) throws SQLException, IOException, ServletException {
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("image");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        String sql = "INSERT INTO voitures (designation, description, prix, image, stock, categorie_idcategorie) VALUES (?,?,?,?,?,?);";
        connect();
        PreparedStatement statement = null;
        boolean rowInserted = false;
        try{
            statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, voiture.getDesignation());
            statement.setString(2, voiture.getDescription());
            statement.setDouble(3, voiture.getPrix());
            if (inputStream != null) {
                    // fetches input stream of the upload file for the blob column
                    statement.setBlob(4, inputStream);
                }
            statement.setInt(5, voiture.getStock());
            statement.setInt(6, voiture.getCategorie_id());
            rowInserted = statement.executeUpdate() > 0;
        }catch(SQLException e){
        }finally{
            try{
                if(statement != null)
                    statement.close();
            }catch(SQLException e){}
           
        }
        disconnect();
        return rowInserted;
    }

    public List<VoitureModel> getAllVoiture() throws SQLException {
        List<VoitureModel> listVoiture = new ArrayList<>();
        String sql = "SELECT * FROM voitures";
        connect();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = jdbcConnection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int matricule = resultSet.getInt("matricule");
                String designation = resultSet.getString("designation");
                String description = resultSet.getString("description");
                double prix = resultSet.getDouble("prix");
                Blob image = resultSet.getBlob("image");
                int stock = resultSet.getInt("stock");
                int categorie_id = resultSet.getInt("categorie_idcategorie");
                VoitureModel voiture = new VoitureModel(matricule, designation, description, prix, image, stock, categorie_id);
                listVoiture.add(voiture);
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
        
        
        disconnect();
        return listVoiture;
    }
    
    public VoitureModel voitures(int mat) throws SQLException {
        VoitureModel voiture = new VoitureModel() ;
        String sql = "SELECT * FROM voitures where matricule == mat ";
        connect();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = jdbcConnection.createStatement();
            resultSet = statement.executeQuery(sql);
        
            int matricule = resultSet.getInt("matricule");
            String designation = resultSet.getString("designation");
            String description = resultSet.getString("description");
            double prix = resultSet.getDouble("prix");
            Blob image = resultSet.getBlob("image");
            int stock = resultSet.getInt("stock");
            int categorie_id = resultSet.getInt("categorie_idcategorie");
            voiture = new VoitureModel(matricule, designation, description, prix, image, stock, categorie_id);
            
        }catch(SQLException e){
        }finally{
            try{
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
            }catch(SQLException e){}
        }
        disconnect();
        return voiture;
    }


}
