package fonctionnalite;

import classe.Joueur;
import fonctionnalite.Regles;
import java.util.Scanner;

public class Mouvement {
    /** Fonction de déplacement pour le joueur */
    public static int[][] mouvement(int[][] plateau, Joueur aFaireBouger){
        Scanner scanner = new Scanner(System.in);
        String direction;
        boolean inMouvement = true;
        Regles regles = new Regles();
        while (inMouvement){
            // Demande au joueur où il veut se déplacer et lui montre les paramètres du jeu
            System.out.println("Où voulez-vous vous diriger ?");
            System.out.println("Z: haut | Q: gauche | S: bas | D: droite | Regles: regles");
            direction = scanner.nextLine();
            // Lorsque le joueur appuie sur Z, il se déplace vers le haut
            if (direction.toLowerCase().equals("z") && aFaireBouger.getCoordoneeX()-1 != -1){
                if (plateau[aFaireBouger.getCoordoneeX()-1][aFaireBouger.getCoordoneeY()] == 0){
                    plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                    aFaireBouger.setCoordoneeX(aFaireBouger.getCoordoneeX()-1);
                    inMouvement = false;
                }else {
                    System.out.println("La case est déjà occupée");
                }
                // Lorsque le joueur appuie sur S, il se déplace vers le bas
            }else if (direction.toLowerCase().equals("s") && aFaireBouger.getCoordoneeX()+1 != plateau.length){
                if (plateau[aFaireBouger.getCoordoneeX()+1][aFaireBouger.getCoordoneeY()] == 0){
                    plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                    aFaireBouger.setCoordoneeX(aFaireBouger.getCoordoneeX()+1);
                    inMouvement = false;
                }else {
                    System.out.println("La case est déjà occupée");
                }
                // Lorsque le joueur appuie sur Q, il se déplace vers la gauche
                // On vérifie s'il peut se déplacer à gauche
            }else if (direction.toLowerCase().equals("q") && aFaireBouger.getCoordoneeY()-1 != -1){
                // On vérifie que la case est égale à 0
                if (plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()-1] == 0){
                    // On change la couleur où est placé le joueur à 0, c'est-à-dire en blanc
                    plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                    // On déplace le joueur de -1 en Y
                    aFaireBouger.setCoordoneeY(aFaireBouger.getCoordoneeY()-1);
                    inMouvement = false;
                }else {
                    System.out.println("La case est déjà occupée");
                }
                // Lorsque le joueur appuie sur D, il se déplace vers la droite
                // On vérifie s'il peut se déplacer à droite
            }else if (direction.toLowerCase().equals("d") && aFaireBouger.getCoordoneeY()+1 != plateau[0].length){
                // On vérifie que la case est égale à 0
                if (plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()+1] == 0){
                    // On change la couleur où est placé le joueur à 0, c'est-à-dire en blanc
                    plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                    // On déplace le joueur de +1 en Y
                    aFaireBouger.setCoordoneeY(aFaireBouger.getCoordoneeY()+1);
                    inMouvement = false;
                }else {
                    // Si la case où le joueur veut se déplacer est occupée par un autre, alors on affiche ce message
                    System.out.println("La case est déjà occupée");
                }
            }else if (direction.toLowerCase().equals("regles")){
                regles.regles();
            }else {
                // Si le joueur appuie sur une autre touche que Z, Q, S, D, alors on affiche ce message d'erreur et il peut recommencer
                System.out.println("Commande inconnue, veuillez réessayer");
            }
        }
        plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = aFaireBouger.getCouleur();
        return plateau;
    }
}
