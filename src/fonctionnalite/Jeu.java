package fonctionnalite;

import classe.Joueur;

import java.util.Random;
import java.util.Scanner;

public class Jeu {
    public static void afficherTableau(int[][] Tableau){
        //initialise une varibale nb pour les Colones et les Lignes
        int nbLignes=Tableau.length;
        int nbColones=Tableau[0].length;
        String[] Alphabet = {"  A ","B ","C ","D","E ","F ","G ","H ","I ","J","K"};
        for (int idLettres=0; idLettres < nbColones; idLettres++) {
            System.out.printf(Alphabet[idLettres]+"ㅤ");
        }
        System.out.printf("\n");
        for (int idLignes=0; idLignes < nbLignes; idLignes++){
            System.out.printf(idLignes+" ");
            for (int idColones=00; idColones < nbColones; idColones++){
                if (Tableau[idLignes][idColones] == 0) {
                    System.out.printf("⬜ ");
                }
                if (Tableau[idLignes][idColones] == 1) {
                    System.out.printf("⬛ ");
                }
                if (Tableau[idLignes][idColones] == 2) {
                    System.out.printf("\uD83D\uDFE5 ");
                }
                if (Tableau[idLignes][idColones] == 3) {
                    System.out.printf("\uD83D\uDFE6 ");
                }
            }
            System.out.printf("\n");
        }
    }

    /** Fonction qui prépare tout ce qui vas se passer dans le jeu */
    public static void setupJeu(int[][] plateau){
        Scanner scannerJoueurs = new Scanner(System.in);
        // Defini les joueurs et leurs attribue une couleurs
        Joueur joueur1 = new Joueur();
        System.out.println("Pseudo du joueur 1");
        joueur1.setPseudo(scannerJoueurs.nextLine());
        joueur1.setCouleur(2);
        Joueur joueur2 = new Joueur();
        System.out.println("Pseudo du joueur 2");
        joueur2.setPseudo(scannerJoueurs.nextLine());
        joueur2.setCouleur(3);
        // On crée un tableau avec les jouers afin d'en choisir un au hasard
        Joueur[] toutLesJoueurs = new Joueur[]{joueur1, joueur2};
        Random joueurAleatoire = new Random();
        // On en choisis un au hasard afin qu'il soit le premier a jouer et on defini le deuxieme joueur en fonction du premier
        int choixDuJoueurAleatoire = joueurAleatoire.nextInt(toutLesJoueurs.length);
        Joueur premierAJouer = toutLesJoueurs[choixDuJoueurAleatoire];
        Joueur deuxiemeAJouer;
        if (choixDuJoueurAleatoire == 1){
            deuxiemeAJouer = toutLesJoueurs[0];
        }else {
            deuxiemeAJouer = toutLesJoueurs[1];
        }
        // On met les coordonnée par default au premier joueur
        premierAJouer.setCoordoneeX(4);
        premierAJouer.setCoordoneeY(5);
        // On met les coordonnée par default au deuxième joueur
        deuxiemeAJouer.setCoordoneeX(5);
        deuxiemeAJouer.setCoordoneeY(5);
        plateau[premierAJouer.getCoordoneeX()][premierAJouer.getCoordoneeY()] = premierAJouer.getCouleur();
        plateau[deuxiemeAJouer.getCoordoneeX()][deuxiemeAJouer.getCoordoneeY()] = deuxiemeAJouer.getCouleur();
        Jeu(plateau,premierAJouer, deuxiemeAJouer);
    }

    /** Fonction de déroulement du jeu */
    public static int aQuiDeJouer = 0;
    public static void Jeu(int[][] plateau, Joueur premierJoueur, Joueur deuxiemeJoueur){
        Mouvement mouvementClasse = new Mouvement();
        int[][] mouvement;
        boolean inJeu = true;
        while (inJeu){
            // Donne une couleur aléatoire au joueur
            afficherTableau(plateau);
            // permet de déterminer qui joue aléatoirement en premier en début de partie
            if (aQuiDeJouer == 0){
                aQuiDeJouer = 1;
                System.out.println(premierJoueur.getPseudo() + " a toi de jouer");
                plateau = mouvementClasse.mouvement(plateau, premierJoueur);
                afficherTableau(plateau);
                plateau = DetruireBloc.detruireBloc(plateau);
            } else if (aQuiDeJouer == 1) {
                aQuiDeJouer = 0;
                System.out.println(deuxiemeJoueur.getPseudo() + " a toi de jouer");
                plateau = mouvementClasse.mouvement(plateau, deuxiemeJoueur);
                afficherTableau(plateau);
                plateau = DetruireBloc.detruireBloc(plateau);
            }
        }
    }
}
