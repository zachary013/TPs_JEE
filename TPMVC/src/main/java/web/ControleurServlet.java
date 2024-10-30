package web;

import metier.IMetierCatalogue;
import metier.MetierImpl;
import metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ControleurServlet extends HttpServlet {
    private IMetierCatalogue metier;

    @Override
    public void init() throws ServletException {
        metier = new MetierImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mc = request.getParameter("motCle");
        System.out.println("Mot clé: " + mc);
        List<Produit> prods = metier.getProduitsParMC(mc);
        System.out.println("Produits trouvés: " + prods.size());
        request.setAttribute("produits", prods);
        request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
    }
}