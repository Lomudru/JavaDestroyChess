import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Affiche le titre du jeu
        System.out.println("\n" +
                "████████▄     ▄████████    ▄████████     ███        ▄████████  ▄██████▄  ▄██   ▄    ▄████████    ▄█    █▄       ▄████████    ▄████████    ▄████████ \n" +
                "███   ▀███   ███    ███   ███    ███ ▀█████████▄   ███    ███ ███    ███ ███   ██▄ ███    ███   ███    ███     ███    ███   ███    ███   ███    ███ \n" +
                "███    ███   ███    █▀    ███    █▀     ▀███▀▀██   ███    ███ ███    ███ ███▄▄▄███ ███    █▀    ███    ███     ███    █▀    ███    █▀    ███    █▀  \n" +
                "███    ███  ▄███▄▄▄       ███            ███   ▀  ▄███▄▄▄▄██▀ ███    ███ ▀▀▀▀▀▀███ ███         ▄███▄▄▄▄███▄▄  ▄███▄▄▄       ███          ███        \n" +
                "███    ███ ▀▀███▀▀▀     ▀███████████     ███     ▀▀███▀▀▀▀▀   ███    ███ ▄██   ███ ███        ▀▀███▀▀▀▀███▀  ▀▀███▀▀▀     ▀███████████ ▀███████████ \n" +
                "███    ███   ███    █▄           ███     ███     ▀███████████ ███    ███ ███   ███ ███    █▄    ███    ███     ███    █▄           ███          ███ \n" +
                "███   ▄███   ███    ███    ▄█    ███     ███       ███    ███ ███    ███ ███   ███ ███    ███   ███    ███     ███    ███    ▄█    ███    ▄█    ███ \n" +
                "████████▀    ██████████  ▄████████▀     ▄████▀     ███    ███  ▀██████▀   ▀█████▀  ████████▀    ███    █▀      ██████████  ▄████████▀   ▄████████▀  \n" +
                "                                                   ███    ███                                                                                       \n");

        // Créer un scanner
        Scanner scanner = new Scanner(System.in);
        // On appelle le menu
        menu(scanner);
    }

    /** Affiche le menu et renvoie vers la fonction demandée */
    public static void menu(Scanner scanner) {
        // Afficher les options disponibles pour la navigation
        System.out.println("╭───────────────────────────╮");
        System.out.println("│  Que voulez-vous faire ?  │");
        System.out.println("├───────────────────────────┤");
        System.out.println("│ 1. Jouer                  │");
        System.out.println("│ 2. Scores                 │");
        System.out.println("│ 3. Règles                 │");
        System.out.println("│ 4. Quitter                │");
        System.out.println("╰───────────────────────────╯");

        // Demande à l'utilisateur de choisir une option
        String reponse = scanner.nextLine();
        if ((reponse.equals("1")) || reponse.toLowerCase().equals("jouer")) {
            // Si la réponse est 1 ou jouer, on envoie vers le jeu
            System.out.println("Jouer bien");
        } else if ((reponse.equals("2")) || reponse.toLowerCase().equals("scores")) {
            // Si la réponse est 2 ou scores, on affiche les scores
            System.out.println("Les scores");
        } else if ((reponse.equals("3")) || reponse.toLowerCase().equals("règles")) {
            // Si la réponse est 3 ou règles, on affiche les règles
            regles();
        } else if ((reponse.equals("4")) || reponse.toLowerCase().equals("quitter")) {
            // Si la réponse est 4 ou quitter, on dit au revoir et on arrête le code
            System.out.println("Au revoir");
            System.exit(0);
        } else {
            // Sinon, on précise que nous n'avons pas compris
            System.out.println("Commande non reconnue, veuillez réessayer");
        }
        // Et puis on rappelle la fonction
        menu(scanner);
    }
    /** Affiche les règles du jeu */
    public static void regles()
    {
        System.out.println("╭──────────────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("│  Règles                                                                                      │");
        System.out.println("├──────────────────────────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ Un joueur ne peut pas se déplacé en diagonale.                                               │");
        System.out.println("│ Si le joueur n'a plus la possibilité de se déplacé autour de lui, il a perdu.                │");
        System.out.println("│ Le joueur peut détruire une case lorsqu'il s'est déplacé.                                    │");
        System.out.println("│ La partie se termine lorsqu'il reste un seul survivant                                       │");
        System.out.println("│ Un joueur gagne 5 point lorsqu'il est le dernier survivant et perd 2 point lorsqu'il meurt   │");
        System.out.println("╰──────────────────────────────────────────────────────────────────────────────────────────────╯");
    }
}
