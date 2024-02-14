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
            setupJeu(plateauDeJeu);
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
   /** Fonction qui prépare tout ce qui vas se passer dans le jeu */
    public static void setupJeu(int[][] plateau){
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
        Jeu(plateau,premierAJouer, deuxiemeAJouer);
    }
    /** Fonction de déroulement du jeu */
    //Fonction de déroulement de jeu en tant que tel
    public static int aQuiDeJouer = 0;
    public static void Jeu(int[][] plateau, Joueur premierJoueur, Joueur deuxiemeJoueur){
        // On change le plateau afin d'y appliquer les coordonnée du joueur et on affiche le plateau

        // Donne une couleur aléatoire au joueur
        plateau[premierJoueur.getCoordoneeX()][premierJoueur.getCoordoneeY()] = premierJoueur.getCouleur();
        plateau[deuxiemeJoueur.getCoordoneeX()][deuxiemeJoueur.getCoordoneeY()] = deuxiemeJoueur.getCouleur();
        afficherTableau(plateau);
        // permet de déterminer qui joue aléatoirement en premier en début de partie
        if (aQuiDeJouer == 0){
            aQuiDeJouer = 1;
            System.out.println(premierJoueur.getPseudo() + " a toi de jouer");
            mouvement(plateau, premierJoueur, new Joueur[]{premierJoueur,deuxiemeJoueur});
        } else if (aQuiDeJouer == 1) {
            aQuiDeJouer = 0;
            System.out.println(deuxiemeJoueur.getPseudo() + " a toi de jouer");
            mouvement(plateau, deuxiemeJoueur, new Joueur[]{premierJoueur,deuxiemeJoueur});
        }
    }
    /** Fonction de déplacement pour le joueur */
    public static void mouvement(int[][] plateau, Joueur aFaireBouger, Joueur[] joueurs){
        // demande au joueur ou il veut se déplacé et on lui montre les settings du jeu
        Scanner scanner = new Scanner(System.in);
        System.out.println("Où voulez vous vous dirigez");
        System.out.println("Z: haut| Q: gauche| S: bas|D:droite");
        String direction = scanner.nextLine();
        // lorsque le joueur appui sur z ilse déplace vers la haut
        if (direction.toLowerCase().equals("z") && aFaireBouger.getCoordoneeX()-1 != -1){
            if (plateau[aFaireBouger.getCoordoneeX()-1][aFaireBouger.getCoordoneeY()] == 0){
                plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                aFaireBouger.setCoordoneeX(aFaireBouger.getCoordoneeX()-1);
            }else {
                System.out.println("La case est deja occuper");
                mouvement(plateau, aFaireBouger, joueurs);
            }
            // lorsque le joueur appui sur s ilse déplace vers la bas
        }else if (direction.toLowerCase().equals("s") && aFaireBouger.getCoordoneeX()+1 != plateau.length){
            if (plateau[aFaireBouger.getCoordoneeX()+1][aFaireBouger.getCoordoneeY()] == 0){
                plateau[aFaireBouger.getCoordoneeX()][aFaireBouger.getCoordoneeY()] = 0;
                aFaireBouger.setCoordoneeX(aFaireBouger.getCoordoneeX()+1);
            }else {
                System.out.println("La case est deja occuper");
                mouvement(plateau, aFaireBouger, joueurs);
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
            }else {
                System.out.println("La case est deja occuper");
                mouvement(plateau, aFaireBouger, joueurs);
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
            }else {
                // si la case ou le joueur veut se déplacé est occupé par un autre alors on affiche se message
                System.out.println("La case est deja occuper");
                mouvement(plateau, aFaireBouger, joueurs);
            }
        }else {
            // si le joueur appui sur une autre touche que Z Q S D alors on affiche se message d'erreur et il peut recommencer
            System.out.println("Commande inconnue, veuillez ressayer");
            mouvement(plateau, aFaireBouger, joueurs);
        }
        Jeu(plateau, joueurs[0], joueurs[1]);
    }
}
