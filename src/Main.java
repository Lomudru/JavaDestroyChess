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
import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
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
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        Regles regles = new Regles();
        Scores scores = new Scores();
        Sauvegarde sauvegarder = new Sauvegarde();
        // Afficher les options disponibles pour la navigation
        System.out.println(
    "╔═════════════════════════╗\n" +
    "║    Que veux tu faire ?  ║\n" +
    "╠═════════════════════════╣\n" +
    "║ 1. Jouer                ║\n" +
    "║ 2. Scores               ║\n" +
    "║ 3. Règles               ║\n" +
    "║ 4. Quitter              ║\n" +
    "╚═════════════════════════╝");

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
            boolean inQuitter = true;
            String sauvegarde = "annuler";
            while (inQuitter) {
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
                System.out.println("Voulez vous sauvegarder vos scores ?");
                System.out.println("oui | non | annuler");
                if (!(sauvegarde.toLowerCase().equals("annuler")) && !(sauvegarde.toLowerCase().equals("cancel"))){
                    System.out.println("commande non reconue");
                }
                sauvegarde = scanner.nextLine();
                if (sauvegarde.toLowerCase().equals("oui") || sauvegarde.toLowerCase().equals("yes")){
                    sauvegarder.sauvegarder(scores.getDejaJouer());
                    System.out.println("Au revoir");
                    System.exit(0);
                } else if (sauvegarde.toLowerCase().equals("non") || sauvegarde.toLowerCase().equals("no")) {
                    System.out.println("Au revoir");
                    System.exit(0);
                } else if (sauvegarde.toLowerCase().equals("annuler") || sauvegarde.toLowerCase().equals("cancel")) {
                    System.out.println("Retour au menu");
                    inQuitter = false;
                }
            }
        }else if ((reponse.toLowerCase().equals("rick"))){
            // Easter Egg petit
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=xvFZjo5PgG0"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ((reponse.toLowerCase().equals("petit"))){
            // Easter Egg petit
            try {
                Desktop.getDesktop().browse(new URI("https://cdn.discordapp.com/attachments/1206942782405738527/1208008876180508702/Capture_decran_2024-02-16_a_12.15.43.png?ex=65e1b8ef&is=65cf43ef&hm=7c0fb0be6616225721df462af298df783501f5516389c75d5db31e283a2c2747&"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Sinon, on précise que nous n'avons pas compris
            System.out.println("Commande non reconnue, veuillez réessayer");
        }
        // On rappelle la fonction pour revenir au menu
        menu(scanner);
    }
}

