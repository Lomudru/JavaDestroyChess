import java.util.Random;
import java.util.Scanner;
import classe.Joueur;
import javax.print.attribute.standard.JobOriginatingUserName;

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
            // Si la réponse est 1 ou jouer, on envoie vers le jeu et génère le plateau
            int[][] plateauDeJeu = {{0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0,0}};
            Jeu(plateauDeJeu);
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
    public static void afficherTableau(int[][] Tableau){
        //initialise une varibale nb pour les Colones et les Lignes
        int nbLignes=Tableau.length;
        int nbColones=Tableau[0].length;
        String[] Alphabet = {"  A ","B ","C ","D","E ","F ","H ","I ","J ","K","L"};
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
    /** Fonction de déroulement du jeu */
    //Fonction de déroulement de jeu en tant que tel
    public static void Jeu(int[][] plateau){
        // Defini les joueurs et leurs attribue une couleurs
        Joueur joueur1 = new Joueur();
        joueur1.setPseudo("Rouge");
        joueur1.setCouleur(2);
        Joueur joueur2 = new Joueur();
        joueur2.setPseudo("Bleu");
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
        // On change le plateau afin d'y appliquer les coordonnée du joueur et on affiche le plateau
        plateau[premierAJouer.getCoordoneeX()][premierAJouer.getCoordoneeY()] = premierAJouer.getCouleur();
        plateau[deuxiemeAJouer.getCoordoneeX()][deuxiemeAJouer.getCoordoneeY()] = deuxiemeAJouer.getCouleur();
        afficherTableau(plateau);
    }
}
