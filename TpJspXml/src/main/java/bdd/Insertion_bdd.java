package bdd;

import org.jdom2.Element;
import java.util.Random;

public class Insertion_bdd {
    public Insertion_bdd() {}

    int RandomId() {
        Random r = new Random();
        return r.nextInt(10000);
    }

    public void ajout_etudiant(String nom, String prenom, String mdp, String adresse) {
        xml fichier;
        try {
            fichier = new xml();
            Element etudiant = new Element("etudiant");
            fichier.add_noeud_xml(fichier.racine, etudiant, "");
            fichier.add_attribut_xml(etudiant, "id", RandomId() + "");

            fichier.add_noeud_xml(etudiant, new Element("nom"), nom);
            fichier.add_noeud_xml(etudiant, new Element("prenom"), prenom);
            fichier.add_noeud_xml(etudiant, new Element("mdp"), mdp);
            fichier.add_noeud_xml(etudiant, new Element("adresse"), adresse);

            fichier.save(fichier.chemin);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}