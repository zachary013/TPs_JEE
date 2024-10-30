package bdd;

import java.util.Iterator;
import java.util.List;
import org.jdom2.Element;

public class selection_bdd {
    public selection_bdd() {}

    public boolean dejaExist(String N, String P) {
        try {
            xml file = new xml("src/main/resources/tp.xml");
            List<Element> listemodule = file.racine.getChildren("etudiant");
            for (Element courant : listemodule) {
                if (courant.getChild("prenom").getValue().equals(P) &&
                        courant.getChild("nom").getValue().equals(N)) {
                    return true;
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    public String identificateur(String N, String P) {
        String a = "";
        try {
            xml file = new xml("src/main/resources/tp.xml");
            List<Element> listemodule = file.racine.getChildren("etudiant");
            for (Element courant : listemodule) {
                if (courant.getChild("prenom").getValue().equals(P) &&
                        courant.getChild("nom").getValue().equals(N)) {
                    a = courant.getAttribute("id").getValue();
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return a;
    }
}