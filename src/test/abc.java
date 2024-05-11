package test;

import java.io.*;

public class Authentification {
    public static void main(String[] args) {
        // Chemin du fichier d'entrée
        String fichierEntree = "d:\\fichiers\\in.txt";

        try {
            // Création des flux pour lire le fichier d'entrée
            BufferedReader lecteurFichier = new BufferedReader(new FileReader(fichierEntree));

            // Lecture du fichier ligne par ligne
            String ligne;
            boolean authentifie = false;

            // Lecture du fichier d'entrée
            while ((ligne = lecteurFichier.readLine()) != null) {
                // Diviser la ligne en login et mot de passe
                String[] elements = ligne.split(" ");
                String login = elements[0];
                String motDePasse = elements[1];

                // Comparaison des login et mot de passe saisis avec ceux du fichier
                if (login.equals(saisirLogin()) && motDePasse.equals(saisirMotDePasse())) {
                    authentifie = true;
                    break;
                }
            }

            // Fermeture du flux de lecture du fichier
            lecteurFichier.close();

            // Affichage du résultat de l'authentification
            if (authentifie) {
                System.out.println("Authentification réussie");
            } else {
                System.out.println("Problème d'authentification");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    // Méthode pour saisir le login
    public static String saisirLogin() throws IOException {
        BufferedReader lecteur = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entrez votre login : ");
        return lecteur.readLine();
    }

    // Méthode pour saisir le mot de passe
    public static String saisirMotDePasse() throws IOException {
        BufferedReader lecteur = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entrez votre mot de passe : ");
        return lecteur.readLine();
    }
}