/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cerification.beans;

/**
 *
 * @author yassinesalihi
 */
public class Certification {
    
    private int id;
    private String nom;
    private String organisme;
    private double cout;

    public Certification(int id, String nom, String organisme, double cout) {
        this.id = id;
        this.nom = nom;
        this.organisme = organisme;
        this.cout = cout;
    }

    public Certification(String nom, String organisme, double cout) {
        this.nom = nom;
        this.organisme = organisme;
        this.cout = cout;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }
    
      
    
    
    
    
}
