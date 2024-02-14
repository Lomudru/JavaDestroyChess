package fonctionnalite;

import classe.Joueur;

import java.util.Scanner;

public class Mouvement {
    /** Fonction de déplacement pour le joueur */
    public static int[][] mouvement(int[][] plateau, Joueur aFaireBouger, Joueur[] joueurs){
        Scanner scanner = new Scanner(System.in);
        String direction;
        boolean inMovement = true;
        while (inMovement){
            // demande au joueur ou il veut se déplacé et on lui montre les settings du jeu
            System.out.println("Où voulez vous vous dirigez");
            System.out.println("Z: haut| Q: gauche| S: bas|D:droite");
            direction = scanner.nextLine();
            // lorsque le joueur appui sur z ilse déplace vers la haut
            if (direction.toLowerCase().equals("z") && aFaireBouger.getCoordoneeX()-1 != -1){
                if (plateau[aFaireBouger.getCoordoneeX()-1][aFaireBouger.getCoordoneeY()] == 0){
                    plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                    aFaireBouger.setCoordoneeX(aFaireBouger.getCoordoneeX()-1);
                    inMovement = false;
                }else {
                    System.out.println("La case est deja occuper");
                }
                // lorsque le joueur appui sur s ilse déplace vers la bas
            }else if (direction.toLowerCase().equals("s") && aFaireBouger.getCoordoneeX()+1 != plateau.length){
                if (plateau[aFaireBouger.getCoordoneeX()+1][aFaireBouger.getCoordoneeY()] == 0){
                    plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                    aFaireBouger.setCoordoneeX(aFaireBouger.getCoordoneeX()+1);
                    inMovement = false;
                }else {
                    System.out.println("La case est deja occuper");
                }
                // lorsque le joueur appui sur q ilse déplace vers la gauche
                // on regarde si il peut se déplacé a gauche
            }else if (direction.toLowerCase().equals("q") && aFaireBouger.getCoordoneeY()-1 != -1){
                // on vérifie que la case est égal à 0
                if (plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()-1] == 0){
                    // on change la couleur ou est placer le joueur à 0 c'est à dire en blanc
                    plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                    // on déplace le joueur en -1 en
                    aFaireBouger.setCoordoneeY(aFaireBouger.getCoordoneeY()-1);
                    inMovement = false;
                }else {
                    System.out.println("La case est deja occuper");
                }
                // lorsque le joueur appui sur d ilse déplace vers la droite
                // on regarde si il peut se déplacé a droite
            }else if (direction.toLowerCase().equals("d") && aFaireBouger.getCoordoneeY()+1 != plateau[0].length ){
                // on vérifie que la case est égal à 0
                if (plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()+1] == 0){
                    // on change la couleur ou est placer le joueur à 0 c'est à dire en blanc
                    plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                    // on déplace le joueur en +1 en y
                    aFaireBouger.setCoordoneeY(aFaireBouger.getCoordoneeY()+1);
                    inMovement = false;
                }else {
                    // si la case ou le joueur veut se déplacé est occupé par un autre alors on affiche se message
                    System.out.println("La case est deja occuper");
                }
            }else {
                // si le joueur appui sur une autre touche que Z Q S D alors on affiche se message d'erreur et il peut recommencer
                System.out.println("Commande inconnue, veuillez ressayer");
            }
        }
        plateau[joueurs[0].getCoordoneeX()][joueurs[0].getCoordoneeY()] = joueurs[0].getCouleur();
        plateau[joueurs[1].getCoordoneeX()][joueurs[1].getCoordoneeY()] = joueurs[1].getCouleur();
        return plateau;
    }

}
