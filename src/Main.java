import java.util.Random;
import java.util.Scanner;
import classe.Joueur;
import fonctionnalite.Jeu;
import fonctionnalite.Regles;
import fonctionnalite.Sauvegarde;
import fonctionnalite.Scores;
import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.*;
import java.io.File;

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

        // Crée un scanner
        Scanner scanner = new Scanner(System.in);
        Scores scores = new Scores();
        Sauvegarde sauvegarder = new Sauvegarde();
        File f = new File("scores");
        if(f.exists())
        {
            System.out.println("Voulez vous charger les scores ?");
            System.out.println("oui | non");
            boolean inChoix = true;
            while (inChoix){
                String reponse = scanner.nextLine();
                if (reponse.toLowerCase().equals("oui")){
                    scores.setDejaJouer(sauvegarder.lireSauvegarde());
                    inChoix = false;
                } else if (reponse.toLowerCase().equals("non")) {
                    inChoix = false;
                }else {
                    System.out.println("Commande non reconnue");
                }
            }
        }
        // Appelle le menu
        menu(scanner);
    }

    /** Affiche le menu et redirige vers la fonction demandée */
    public static void menu(Scanner scanner) {
        Regles regles = new Regles();
        Scores scores = new Scores();
        Sauvegarde sauvegarder = new Sauvegarde();
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
            // Si la réponse est 1 ou jouer, on redirige vers le jeu et génère le plateau
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
            Jeu jeu = new Jeu();
            jeu.setupJeu(plateauDeJeu);
        } else if ((reponse.equals("2")) || reponse.toLowerCase().equals("scores")) {
            // Si la réponse est 2 ou scores, on affiche les scores
            scores.afficherScores();
        } else if ((reponse.equals("3")) || reponse.toLowerCase().equals("règles")) {
            // Si la réponse est 3 ou règles, on affiche les règles
            regles.regles();
        } else if ((reponse.equals("4")) || reponse.toLowerCase().equals("quitter")) {
            // Si la réponse est 4 ou quitter, on dit au revoir et on arrête le programme
            System.out.println("Voulez vous sauvegarder vos scores ?");
            System.out.println("oui | non | annuler");
            String sauvegarde = scanner.nextLine();
            if (sauvegarde.toLowerCase().equals("oui") || sauvegarde.toLowerCase().equals("yes")){
                sauvegarder.sauvegarder(scores.getDejaJouer());
                System.out.println("Au revoir");
                System.exit(0);
            } else if (sauvegarde.toLowerCase().equals("non") || sauvegarde.toLowerCase().equals("no")) {
                System.out.println("Au revoir");
                System.exit(0);
            } else if (sauvegarde.toLowerCase().equals("annuler") || sauvegarde.toLowerCase().equals("cancel")) {
                System.out.println("Retour au menu");
            }
        } else {
            // Sinon, on précise que nous n'avons pas compris
            System.out.println("Commande non reconnue, veuillez réessayer");
        }
        // On rappelle la fonction pour revenir au menu
        menu(scanner);
    }
}

