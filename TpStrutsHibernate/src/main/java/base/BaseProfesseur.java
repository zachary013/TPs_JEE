package base;

import hibernate.Professeur;
import java.io.Serializable;

public abstract class BaseProfesseur implements Serializable {
    public BaseProfesseur() { initialize(); }
    public BaseProfesseur(Integer id) { this.setId(id); initialize(); }
    protected void initialize() {}

    private int hashCode = Integer.MIN_VALUE;
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; this.hashCode = Integer.MIN_VALUE; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (!(obj instanceof Professeur)) return false;
        else {
            Professeur prof = (Professeur) obj;
            return (this.getId().equals(prof.getId()));
        }
    }

    public String toString() { return super.toString(); }
}
