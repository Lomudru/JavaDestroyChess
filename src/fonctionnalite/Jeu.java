package fonctionnalite;

import classe.Joueur;
import fonctionnalite.VerifVictoireDefaite;
import fonctionnalite.Scores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jeu {

    /** Affiche le tableau qui est entré en paramètre */
    public static void afficherTableau(int[][] tableau){
        // Initialise une variable nb pour les colonnes et les lignes
        int nbLignes = tableau.length;
        int nbColonnes = tableau[0].length;
        // Initialise une variable Alphabet pour les repères de colonnes
        String[] Alphabet = {"A","B","C","D","E","F","G","H","I","J","K"};
        System.out.printf("  ");
        for (int idLettres=0; idLettres < nbColonnes; idLettres++) {
            System.out.printf(Alphabet[idLettres]+" ");
        }
        System.out.println("");
        // Boucle sur toutes les lignes du tableau
        for (int idLignes = 0; idLignes < nbLignes; idLignes++){
            System.out.printf(idLignes + " ");
            // Boucle sur chaque case de la ligne actuelle
            for (int idColonnes = 0; idColonnes < nbColonnes; idColonnes++){
                // Si la case vaut 0, affiche un carré blanc
                if (tableau[idLignes][idColonnes] == 0) {
                    System.out.printf("⬜");
                }
                // Si la case vaut 1, affiche un carré noir
                if (tableau[idLignes][idColonnes] == 1) {
                    System.out.printf("⬛");
                }
                // Si la case vaut 2, soit le joueur 1, affiche un carré rouge
                if (tableau[idLignes][idColonnes] == 2) {
                    System.out.printf("\uD83D\uDFE5");
                }
                // Si la case vaut 3, soit le joueur 2, affiche un carré bleu
                if (tableau[idLignes][idColonnes] == 3) {
                    System.out.printf("\uD83D\uDFE6");
                }// Si la case vaut 2, soit le joueur 1, affiche un carré vert
                if (tableau[idLignes][idColonnes] == 4) {
                    System.out.printf("🟩");
                }
                // Si la case vaut 3, soit le joueur 2, affiche un carré jaune
                if (tableau[idLignes][idColonnes] == 5) {
                    System.out.printf("🟨");
                }
            }
            System.out.printf("\n");
        }
    }

    // Méthode pour vérifier si le pseudo est similaire à celui d'un joueur dans la liste
    private static boolean pseudoSimilaireAListe(String pseudo, List<Joueur> joueurs) {
        for (Joueur joueur : joueurs) {
            if (pseudo.equals(joueur.getPseudo())) {
                return true;
            }
        }
        return false;
    }

    /** Fonction qui prépare tout ce qui va se passer dans le jeu */
    public static void setupJeu(){
        int[][] plateau = {{0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0,0,0,0}};
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        Scores scores = new Scores();
        Scanner scannerJoueurs = new Scanner(System.in);
        // Demande aux joueurs combien il seront
        int nombreJoueurs = 0;
        while (nombreJoueurs < 2 || nombreJoueurs > 4) {
            System.out.println("Combien de joueur êtes vous?\n[2] [3] [4]");
            try {
                // Tentative de conversion de la chaîne en entier
                nombreJoueurs = Integer.parseInt(scannerJoueurs.nextLine());
            } catch (NumberFormatException e) {
                // Gestion de l'exception en cas d'échec de conversion
                System.out.println("veuillez entrer un chiffre entre 2 et 4");
            }
            if (nombreJoueurs < 2 || nombreJoueurs > 4) {
                System.out.println("veuillez entrer un chiffre entre 2 et 4");
            }
        }
        ArrayList<Joueur> listeJoueurs = new ArrayList<>();
        Joueur joueur = new Joueur();
        System.out.println("Pseudo du joueur 1");
        String pseudo = scannerJoueurs.nextLine();
        boolean existeDeja = false;
        // si un joueur ayant déjà jouer porte le meme pseudo que l'utilisateur, récupère ses paramètre
        for(int j = 0; j < scores.getDejaJouer().size(); j++){
            if (scores.getDejaJouer().get(j).getPseudo().equals(pseudo)){
                joueur = scores.getDejaJouer().get(j);
                existeDeja = true;
            }
        }
        if (!existeDeja){
            joueur.setPseudo(pseudo);
            scores.addDejaJouer(joueur);
        }
        listeJoueurs.add(joueur);
        for (int i = 1; i < nombreJoueurs; i++){
            joueur = new Joueur();
            while (pseudoSimilaireAListe(pseudo, listeJoueurs)){
                existeDeja = false;
                // Demande aux joueurs de choisir un nom
                System.out.println("Pseudo du joueur "+(i+1));
                pseudo = scannerJoueurs.nextLine();
                // s'assure qu'il n'u ait pas de doublons dans les pseudo
                if (pseudoSimilaireAListe(pseudo, listeJoueurs)){
                    System.out.println("Ce pseudo est déjà pris par un autre joueur euillez en choisir un autre");
                } else{
                    // si un joueur ayant déjà jouer porte le meme pseudo que l'utilisateur, récupère ses paramètre
                    for(int j = 0; j < scores.getDejaJouer().size(); j++){
                        if (scores.getDejaJouer().get(j).getPseudo().equals(pseudo)){
                            joueur = scores.getDejaJouer().get(j);
                            existeDeja = true;
                        }
                    }
                    if (!existeDeja){
                        joueur.setPseudo(pseudo);
                        scores.addDejaJouer(joueur);
                    }
                }
            }
            listeJoueurs.add(joueur);
        }
        System.out.println(listeJoueurs);
        // boucle sur les joueurs
        for (int i = 0; i < listeJoueurs.size(); i++){
            // Attribue une couleur aux joueurs
            listeJoueurs.get(i).setCouleur(i+2);
            // On met les coordonnées par défaut aux joueurs selon leurs nombres
            if ((nombreJoueurs == 2) || (nombreJoueurs == 4)){
                listeJoueurs.get(i).setCoordoneeX((4-((nombreJoueurs-2)/2))+i);
                listeJoueurs.get(i).setCoordoneeY(5);
            }
            if (nombreJoueurs == 3){
                listeJoueurs.get(i).setCoordoneeX(4);
                listeJoueurs.get(i).setCoordoneeY(4+i);
            }
            plateau[listeJoueurs.get(i).getCoordoneeX()][listeJoueurs.get(i).getCoordoneeY()] = listeJoueurs.get(i).getCouleur();
        }
        Jeu(plateau, listeJoueurs);
    }

    public static int aQuiDeJouer = 0;

    /** Fonction de déroulement du jeu */
    public static void Jeu(int[][] plateau, ArrayList<Joueur> listeJoueurs){
        // Initialise les variables utiles au déroulement du jeu
        Mouvement mouvementClasse = new Mouvement();
        int[][] mouvement;
        VerifVictoireDefaite verification = new VerifVictoireDefaite();
        ArrayList<Joueur> perdants = new ArrayList<>();
        Joueur gagnant = new Joueur();
        // Boucle le jeu tant que personne n'a gagné
        while (listeJoueurs.size() > 1){
            // Permet de déterminer de qui est le tour de jouer
            listeJoueurs.removeAll(perdants);
            for (Joueur joueurActuel : listeJoueurs){
                if (!(listeJoueurs.size() > 1)){
                    break;
                }
                System.out.print("\033[H\033[2J");  
                System.out.flush(); 
                System.out.println(listeJoueurs.size());
                afficherTableau(plateau);
                // Vérifie que le joueur n'a pas perdu, c'est-à-dire qu'il peut encore bouger
                joueurActuel.setMort(verification.VerifDefaite(plateau, joueurActuel));
                if (!joueurActuel.getMort()){
                    // Demande au joueur où est-ce qu'il veut bouger
                    System.out.println(joueurActuel.getPseudo() + ", à toi de jouer");
                    plateau = mouvementClasse.mouvement(plateau, joueurActuel);
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();  
                    afficherTableau(plateau);
                    // Demande au joueur quelle case il veut détruire
                    plateau = DetruireBloc.detruireBloc(plateau);
                } else {
                    perdants.add(joueurActuel);
                    if (listeJoueurs.size() > 1){
                        break;
                    }
                }
            }
        }
        gagnant = listeJoueurs.get(0);
        // Modifie les scores des joueurs selon leur victoire ou défaite
        gagnant.setScore(gagnant.getScore() + 5);
        // Félicite le gagnant et informe le perdant de la victoire et de la défaite
        System.out.println(gagnant.getPseudo() + ", bravo, vous avez gagné");
        for (Joueur perdant : perdants){
            System.out.printf(perdant.getPseudo() + ", ");
            perdant.setScore(perdant.getScore() - 2);
        }
        System.out.printf("vous avez perdue");
        Scanner scanner = new Scanner(System.in);
        String reponse = "1";
        while (!reponse.equals("0")) {
            System.out.println("\n[0] Revenir au menu");
            if ((!reponse.equals("0")) && (!reponse.equals("1"))){
                System.out.println("entrée incorrect!");
            }
            reponse = scanner.nextLine();
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
        }
    }
}

