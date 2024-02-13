import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Créer un scanner
        Scanner scanner = new Scanner(System.in);
        // On appelle le menu
        menu(scanner);
    }
    public static void menu(Scanner scanner){
        // Afficher les options disponible pour la navigation
        System.out.println("---------------------------");
        System.out.println("| Que voulez vous faire ? |");
        System.out.println("| 1. Jouer                |");
        System.out.println("| 2. Scores               |");
        System.out.println("| 3. Regles               |");
        System.out.println("| 4. Quitter              |");
        System.out.println("---------------------------");
        // Demande a l'utilisateur de choisir une option
        String reponse = scanner.nextLine();
        if ((reponse.equals("1")) || reponse.toLowerCase().equals("jouer")){
            // Si la reponse est 1 ou jouer, on envoie vers le jeu
            System.out.println("jouer bien");
        } else if ((reponse.equals("2")) || reponse.toLowerCase().equals("scores")) {
            // Si la reponse est 2 ou scores, on affiche les scores
            System.out.println("les scores");
        } else if ((reponse.equals("3")) || reponse.toLowerCase().equals("regles")) {
            // Si la reponse est 3 ou regles, on affiche les regles
            System.out.println("les regles");
        } else if ((reponse.equals("4")) || reponse.toLowerCase().equals("quitter")) {
            // Si la reponse est 4 ou quitter, on dit au revoir et on arrete le code
            System.out.println("Au revoir");
            System. exit(0);
        } else {
            // Sinon on précise que nous n'avons pas compris
            System.out.println("Commande non reconnue veuillez réessayer");
        }
        // Et puis on rappelle la fonction
        menu(scanner);
    }
}