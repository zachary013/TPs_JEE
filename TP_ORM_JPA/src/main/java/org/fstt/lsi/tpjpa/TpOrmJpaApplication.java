package org.fstt.lsi.tpjpa;

import org.fstt.lsi.tpjpa.dao.update.CategorieRepository;
import org.fstt.lsi.tpjpa.dao.update.ProduitRepository;
import org.fstt.lsi.tpjpa.entities.Categorie;
import org.fstt.lsi.tpjpa.entities.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpOrmJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpOrmJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CategorieRepository categorieRepository, ProduitRepository produitRepository) {
        return args -> {
            System.out.println("Initializing Database...");

            Categorie c1 = new Categorie("Ordinateurs");
            Categorie c2 = new Categorie("Imprimantes");
            Categorie c3 = new Categorie("Logiciels");

            c1 = categorieRepository.save(c1);
            c2 = categorieRepository.save(c2);
            c3 = categorieRepository.save(c3);

            produitRepository.save(new Produit("Imprimante Hp Laser", 2540, 30, c2));
            produitRepository.save(new Produit("MacBook 2021", 22000, 35, c1));
            produitRepository.save(new Produit("Scanner HPLX", 1640, 20, c2));

            System.out.println("Database initialized!");

            System.out.println("Fetching products containing 'H':");
            produitRepository.produitsParMc("%H%").forEach(p -> {
                System.out.println("Des: " + p.getDesignation());
                System.out.println("Prix: " + p.getPrix());
            });
        };
    }
}