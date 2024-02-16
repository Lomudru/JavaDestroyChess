package fonctionnalite;

import classe.Joueur;
import fonctionnalite.VerifVictoireDefaite;
import fonctionnalite.Scores;

import java.util.ArrayList;
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
                }
            }
            System.out.printf("\n");
        }
    }

    /** Fonction qui prépare tout ce qui va se passer dans le jeu */
    public static void setupJeu(int[][] plateau){
        Scores scores = new Scores();
        Scanner scannerJoueurs = new Scanner(System.in);
        // Demande aux joueurs de choisir un nom
        Joueur joueur1 = new Joueur();
        System.out.println("Pseudo du joueur 1");
        String pseudo1 = scannerJoueurs.nextLine();
        Joueur joueur2 = new Joueur();
        // S'assure que le joueur 2 choisisse un nom différent du joueur 1
        String pseudo2 = pseudo1;
        System.out.println("Pseudo du joueur 2");
        while (pseudo2.equals(pseudo1)){
            pseudo2 = scannerJoueurs.nextLine();
            if (pseudo2.equals(pseudo1)){
                System.out.println("Ce pseudo est déjà utilisé par le joueur 1. Choisissez-en un autre.");
            }
        }
        // Teste si le nom des joueurs existe déjà et si c'est le cas, récupère ce dernier
        boolean joueur1Existe = false;
        boolean joueur2Existe = false;
        for(int i = 0; i < scores.getDejaJouer().size(); i++){
            if (scores.getDejaJouer().get(i).getPseudo().equals(pseudo1)){
                joueur1 = scores.getDejaJouer().get(i);
                joueur1Existe = true;
            }
            else if (scores.getDejaJouer().get(i).getPseudo().equals(pseudo2)){
                joueur2 = scores.getDejaJouer().get(i);
                joueur2Existe = true;
            }
        }
        // Attribue une couleur aux joueurs
        joueur1.setCouleur(2);
        joueur2.setCouleur(3);
        // Si les joueurs n'ont jamais joué, les ajoute dans le tableau des scores
        if (!joueur1Existe){
            joueur1.setPseudo(pseudo1);
            scores.addDejaJouer(joueur1);
        }
        if (!joueur2Existe){
            joueur2.setPseudo(pseudo2);
            scores.addDejaJouer(joueur2);
        }
        // On crée un tableau avec les joueurs afin d'en choisir un au hasard
        Joueur[] tousLesJoueurs = new Joueur[]{joueur1, joueur2};
        Random joueurAleatoire = new Random();
        // On en choisit un au hasard afin qu'il soit le premier à jouer et on définit le deuxième joueur en fonction du premier
        int choixDuJoueurAleatoire = joueurAleatoire.nextInt(tousLesJoueurs.length);
        Joueur premierAJouer = tousLesJoueurs[choixDuJoueurAleatoire];
        Joueur deuxiemeAJouer;
        if (choixDuJoueurAleatoire == 1){
            deuxiemeAJouer = tousLesJoueurs[0];
        }else {
            deuxiemeAJouer = tousLesJoueurs[1];
        }
        // On met les coordonnées par défaut au premier joueur
        premierAJouer.setCoordoneeX(4);
        premierAJouer.setCoordoneeY(5);
        // On met les coordonnées par défaut au deuxième joueur
        deuxiemeAJouer.setCoordoneeX(5);
        deuxiemeAJouer.setCoordoneeY(5);
        // Place les joueurs sur le plateau et affiche ce dernier
        plateau[premierAJouer.getCoordoneeX()][premierAJouer.getCoordoneeY()] = premierAJouer.getCouleur();
        plateau[deuxiemeAJouer.getCoordoneeX()][deuxiemeAJouer.getCoordoneeY()] = deuxiemeAJouer.getCouleur();
        Jeu(plateau, premierAJouer, deuxiemeAJouer);
    }

    public static int aQuiDeJouer = 0;

    /** Fonction de déroulement du jeu */
    public static void Jeu(int[][] plateau, Joueur premierJoueur, Joueur deuxiemeJoueur){
        // Initialise les variables utiles au déroulement du jeu
        Mouvement mouvementClasse = new Mouvement();
        int[][] mouvement;
        VerifVictoireDefaite verification = new VerifVictoireDefaite();
        boolean inJeu = true;
        Joueur perdant = new Joueur();
        Joueur gagnant = new Joueur();
        // Boucle le jeu tant que personne n'a gagné
        while (inJeu){
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            afficherTableau(plateau);
            // Permet de déterminer de qui est le tour de jouer
            if (aQuiDeJouer == 0){
                aQuiDeJouer = 1;
                // Vérifie que le joueur n'a pas perdu, c'est-à-dire qu'il peut encore bouger
                inJeu = verification.verifVictoireDefaite(plateau, premierJoueur);
                if (inJeu){
                    // Demande au joueur où est-ce qu'il veut bouger
                    System.out.println(premierJoueur.getPseudo() + ", à toi de jouer");
                    plateau = mouvementClasse.mouvement(plateau, premierJoueur);
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();  
                    afficherTableau(plateau);
                    // Demande au joueur quelle case il veut détruire
                    plateau = DetruireBloc.detruireBloc(plateau);
                    gagnant = premierJoueur;
                } else {
                    perdant = premierJoueur;
                }
            } else if (aQuiDeJouer == 1) {
                aQuiDeJouer = 0;
                // Vérifie que le joueur n'a pas perdu, c'est-à-dire qu'il peut encore bouger
                inJeu = verification.verifVictoireDefaite(plateau, deuxiemeJoueur);
                if (inJeu){
                    // Demande au joueur où est-ce qu'il veut bouger
                    System.out.println(deuxiemeJoueur.getPseudo() + ", à toi de jouer");
                    plateau = mouvementClasse.mouvement(plateau, deuxiemeJoueur);
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();  
                    afficherTableau(plateau);
                    // Demande au joueur quelle case il veut détruire
                    plateau = DetruireBloc.detruireBloc(plateau);
                    gagnant = deuxiemeJoueur;
                } else {
                    perdant = deuxiemeJoueur;
                }
            }
        }
        // Modifie les scores des joueurs selon leur victoire ou défaite
        gagnant.setScore(gagnant.getScore() + 5);
        perdant.setScore(perdant.getScore() - 2);
        // Félicite le gagnant et informe le perdant de la victoire et de la défaite
        Scanner scanner = new Scanner(System.in);
        String reponse = "1";
        while (!reponse.equals("0")) {
            System.out.println(gagnant.getPseudo() + ", bravo, vous avez gagné");
            System.out.println(perdant.getPseudo() + ", vous avez perdu");
            System.out.println("[0] Revenir au menu");
            if ((!reponse.equals("0")) && (!reponse.equals("1"))){
                System.out.println("entrée incorrect!");
            }
            reponse = scanner.nextLine();
        }
    }
}
