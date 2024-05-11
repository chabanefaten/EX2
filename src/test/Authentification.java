package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Authentification {

    public static void main(String[] args) {
 
        String fichierEntree = "d:\\fichiers\\in.txt";

        try {
         
            BufferedReader lecteurFichier = new BufferedReader(new FileReader(fichierEntree));

            String ligne;
            boolean authentifie = false;

            while ((ligne = lecteurFichier.readLine()) != null) {
            
                String[] elements = ligne.split(" ");
                String login = elements[0];
                String motDePasse = elements[1];

                if (login.equals(saisirLogin()) && motDePasse.equals(saisirMotDePasse())) {
                    authentifie = true;
                    break;
                }
            }
            
            lecteurFichier.close();
            
            if (authentifie) {
                System.out.println("Authentification réussie");
            } else {
                System.out.println("Problème d'authentification");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

   
    public static String saisirLogin() throws IOException {
        BufferedReader lecteur = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entrez votre login : ");
        return lecteur.readLine();
    }

    public static String saisirMotDePasse() throws IOException {
        BufferedReader lecteur = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entrez votre mot de passe : ");
        return lecteur.readLine();
    }
}