package metier;
import java.util.List;
public class TestMetier {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        List<Produit> prods = metier.getProduitsParMC("H");
        if (prods.isEmpty()) {
            System.out.println("Aucun produit trouvé");
        } else {
            for (Produit p : prods) {
                System.out.println(p.getNomProduit() + " - " + p.getPrix());
            }
        }
    }
}
