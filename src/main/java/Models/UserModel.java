/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author BABA SAIDOU DIEME
 */
public class UserModel {
    
    protected int idUser;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String username;
    protected String password;
    protected String sexe;
    protected String Role;
 
    
    //les methodes
    
    public UserModel (String nom, String prenom, String email, String username, String password, String sexe, String Role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.username = username;
        this.password = password;
        this.sexe = sexe;
        this.Role = Role;
    }
    
      public int getIdutilisateur() {
        return idUser;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idUser = idutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", username=" + username + ", password=" + password + ", sexe=" + sexe + ", Role=" + Role + '}';
    }

}
