package fonctionnalite;

import classe.Joueur;

import java.util.Scanner;

public class DetruireBloc {

    /** Demande une case au joueur et la détruit */
    public static int[][] detruireBloc(int[][] plateau){
        // Initialise les variables utiles au déroulé du script
        Scanner scanner = new Scanner(System.in);
        boolean inDestruction = true;
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k"};
        // Boucle tant que la destruction ne s'est pas effectuée correctement
        while (inDestruction){
            // Demande quelle case détruire
            System.out.println("Quelle case voulez-vous détruire ?");
            char[] coordonnee = scanner.nextLine().toCharArray();
            // S'assure que les coordonnées entrées soient valides
            if (coordonnee.length == 2 && (Character.getNumericValue(coordonnee[1]) >= 0 && Character.getNumericValue(coordonnee[1]) <= 9)){
                String lettre = Character.toString(coordonnee[0]);
                int x = -1;
                int y = Character.getNumericValue(coordonnee[1]);
                for (int i = 0; i < alphabet.length; i++){
                    if (lettre.toLowerCase().equals(alphabet[i])){
                        x = i;
                        break;
                    }
                }
                // S'assure que les coordonnées entrées ne soient pas déjà détruites
                if (x != -1 && plateau[y][x] == 0){
                    // Détruit la case voulue et met fin à la boucle
                    plateau[y][x] = 1;
                    inDestruction = false;
                } else {
                    System.out.println("Erreur, la case est occupée");
                }
            } else {
                System.out.println("Coordonnée non valide");
            }
        }
        // Renvoie le plateau mis à jour après la destruction
        return plateau;
    }
}
