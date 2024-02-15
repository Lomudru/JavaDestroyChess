package fonctionnalite;

import classe.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

public class Scores {

    // Initialise la liste "dejaJouer" qui contient les scores de tous les joueurs
    public static ArrayList<Joueur> dejaJouer = new ArrayList<Joueur>();

    public static ArrayList<Joueur> getDejaJouer() {
        return dejaJouer;
    }

    public static void addDejaJouer(Joueur joueur) {
        Scores.dejaJouer.add(joueur);
    }

    public static void setDejaJouer(ArrayList<Joueur> dejaJouer) {
        Scores.dejaJouer = dejaJouer;
    }

    /** Affiche tous les scores dans l'ordre des parties jouées */
    public static void afficherScores(){
        Scanner scanner = new Scanner(System.in);
        // Si aucun joueur n'a encore de score, affiche "Aucun score disponible"
        if (dejaJouer.isEmpty()){
            System.out.println("Aucun score disponible");
            // Sinon, affiche le score des 10 premiers joueurs à avoir joué
        }else {
            for(int i = 0; i < dejaJouer.size() && i <= 10; i++){
                System.out.println(dejaJouer.get(i).getPseudo() + " : " + dejaJouer.get(i).getScore());
            }
            String reponse = "0";
            // tant que on ne demande pas de revenir au menu affiche les scores et demande le filtre de tri
            while (!reponse.equals("3")) {
                System.out.println("[0] trier par defaut   [1] trier par ordre croissant   [2] trier par ordre décroissant   [3] revenir au menu");
                reponse = scanner.nextLine();
                if (reponse.equals("0")){
                    for(int i = 0; i < dejaJouer.size() && i <= 10; i++){
                        System.out.println(dejaJouer.get(i).getPseudo() + " : " + dejaJouer.get(i).getScore());
                    }
                }
                if (reponse.equals("1")){
                    afficherScoresCroissant();
                }
                if (reponse.equals("2")){
                    afficherScoresDecroissant();
                }
            }
        }
    }
    /** Appliquer le tri croissant par insertion sur la liste dejaJouer */
    public static void afficherScoresCroissant(){
        Joueur[] tableau = dejaJouer.toArray(new Joueur[0]);
        for (int i = 1; i < tableau.length; i++) {
            Joueur temp = tableau[i];
            int j = i;
            // Déplacer les éléments plus grands que temp vers la droite
            while ((j != 0) && (temp.getScore() <= tableau[j - 1].getScore())) {
                tableau[j] = tableau[j - 1];
                j -= 1;
            }
            // Placer temp à la position correcte dans le tableau trié
            tableau[j] = temp;
        }
        for (Joueur joueur : tableau) {
            System.out.println(joueur.getPseudo() + " : " + joueur.getScore());
        }
    }


    /** Appliquer le tri decroissant par insertion sur la liste dejaJouer */
    public static void afficherScoresDecroissant(){
        Joueur[] tableau = dejaJouer.toArray(new Joueur[0]);
        for (int i = 1; i < tableau.length; i++) {
            Joueur temp = tableau[i];
            int j = i;
            // Déplacer les éléments plus grands que temp vers la droite
            while ((j != 0) && (temp.getScore() >= tableau[j - 1].getScore())) {
                tableau[j] = tableau[j - 1];
                j -= 1;
            }
            // Placer temp à la position correcte dans le tableau trié
            tableau[j] = temp;
        }
        for (Joueur joueur : tableau) {
            System.out.println(joueur.getPseudo() + " : " + joueur.getScore());
        }
    }

}