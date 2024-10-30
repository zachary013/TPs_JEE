package bdd;

public class Personne {
    private String nom;
    private String prenom;
    private String motDePasse;
    private String adresse;

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    // Méthode d'enregistrement
    public boolean enregistrer() {
        selection_bdd selection = new selection_bdd();
        if (selection.dejaExist(nom, prenom)) {
            return false;
        } else {
            Insertion_bdd insertion = new Insertion_bdd();
            insertion.ajout_etudiant(nom, prenom, motDePasse, adresse);
            return true;
        }
    }

    public String identificateur() {
        selection_bdd selection = new selection_bdd();
        return selection.identificateur(nom, prenom);
    }
}
