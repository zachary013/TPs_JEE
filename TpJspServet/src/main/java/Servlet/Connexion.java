package Servlet;

import java.sql.*;

public class Connexion {
    private Connection con;
    private Statement instructor;
    private ResultSet resultSet;

    // Constructor
    public Connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tpjspservlet", "root", "");
            instructor = con.createStatement();
            System.out.println("Connexion établie");
        } catch (ClassNotFoundException ex) {
            System.err.println("Problème de pilote");
        } catch (SQLException ex) {
            System.err.println("Base de données non trouvée ou requête incorrecte");
        }
    }

    // Method to read data
    public void lire(String requête) {
        try {
            resultSet = instructor.executeQuery(requête);
        } catch (SQLException ex) {
            System.err.println("Requête incorrecte: " + requête);
        }
    }

    // Method to update data
    public void miseAJour(String requête) {
        try {
            instructor.executeUpdate(requête);
        } catch (SQLException ex) {
            System.err.println("Requête incorrecte: " + requête);
        }
    }

    // Method to check for next result
    public boolean suivant() {
        try {
            return resultSet.next();
        } catch (SQLException ex) {
            return false;
        }
    }

    // Method to register a new user
    public void enregistrer(String login, String password) {
        miseAJour("INSERT INTO users (login, password) VALUES ('" + login + "', '" + password + "')");
    }

    // Method to modify user details
    public void modifier(String newLogin, String newPassword, String login, String password) {
        miseAJour("UPDATE users SET login = '" + newLogin + "', password = '" + newPassword +
                "' WHERE login = '" + login + "' AND password = '" + password + "'");
    }

    // Method to check if user already exists
    public boolean existeDeja(String login, String password) {
        lire("SELECT * FROM users WHERE login = '" + login + "' AND password = '" + password + "'");
        return suivant();
    }

    // Method to close the connection
    public void arrêt() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'arrêt de la connexion à la base de données");
        }
    }
}