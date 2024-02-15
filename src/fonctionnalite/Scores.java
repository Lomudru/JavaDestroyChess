package fonctionnalite;

import classe.Joueur;

import java.util.ArrayList;

public class Scores {

    // Initialise la liste "dejaJouer" qui contient les scores de tous les joueurs
    public static ArrayList<Joueur> dejaJouer = new ArrayList<Joueur>();

    public static ArrayList<Joueur> getDejaJouer() {
        return dejaJouer;
    }

    public static void addDejaJouer(Joueur joueur) {
        Scores.dejaJouer.add(joueur);
    }

    /** Affiche tous les scores dans l'ordre des parties jouées */
    public static void afficherScores(){
        // Si aucun joueur n'a encore de score, affiche "Aucun score disponible"
        if (dejaJouer.isEmpty()){
            System.out.println("Aucun score disponible");
            // Sinon, affiche le score des 10 premiers joueurs à avoir joué
        }else {
            for(int i = 0; i < dejaJouer.size() && i <= 10; i++){
                System.out.println(dejaJouer.get(i).getPseudo() + " : " + dejaJouer.get(i).getScore());
            }
        }
    }
}
