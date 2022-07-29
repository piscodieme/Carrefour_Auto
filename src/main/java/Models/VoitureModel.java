/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Blob;

/**
 *
 * @author BABA SAIDOU DIEME
 */
public class VoitureModel {
    protected int matricule;
    protected String designation;
    protected String description;
    protected double prix;
    protected Blob image;
    protected int stock;
    protected int categorie_id;
    
    // methods
    public VoitureModel (){}
    public VoitureModel(int matricule, String designation, String description, double prix,Blob image, int stock, int categorie_id) {
        this.matricule = matricule;
        this.designation = designation;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.stock = stock;
        this.categorie_id = categorie_id;
    }
    
     public int getMatricule() {
        return matricule;
    }

    public void setIdArticle(int matricule) {
        this.matricule = matricule;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    @Override
    public String toString() {
        return "voitureModel{" + "matricule=" + matricule + ", designation=" + designation + ", description=" + description + ", prix=" + prix + ", image=" + image + ", stock=" + stock + ", categorie_id=" + categorie_id + '}';
    }

}
