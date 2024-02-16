package fonctionnalite;

import java.util.Scanner;

public class Regles {
    /** Affiche les règles du jeu */
    public static void regles(){
        Scanner scanner = new Scanner(System.in);
        String reponse = "1";
        while (!reponse.equals("0")) {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println(
            "╔══════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
            "║  Règles                                                                                      ║\n" +
            "╠══════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
            "║ Un joueur ne peut pas se déplacé en diagonale.                                               ║\n" +
            "║ Si le joueur n'a plus la possibilité de se déplacé autour de lui, il a perdu.                ║\n" +
            "║ Le joueur peut détruire une case lorsqu'il s'est déplacé.                                    ║\n" +
            "║ La partie se termine lorsqu'il reste un seul survivant                                       ║\n" +
            "║ Un joueur gagne 5 point lorsqu'il est le dernier survivant et perd 2 point lorsqu'il meurt   ║\n" +
            "╚══════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("[0] Revenir au menu");
            if ((!reponse.equals("0")) && (!reponse.equals("1"))){
                System.out.println("entrée incorrect!");
            }
            reponse = scanner.nextLine();
        }
    }
}
