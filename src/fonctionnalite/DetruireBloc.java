package fonctionnalite;

import classe.Joueur;

import java.util.Scanner;

public class DetruireBloc {
    public static int[][] detruireBloc(int[][] plateau){
        Scanner scanner = new Scanner(System.in);
        boolean inDestruction = true;
        String[] Alphabet = {"a","b","c","d","e","f","g","h","i","j","k"};
        while (inDestruction){
            System.out.println("Quelle case voulez-vous détruire ?");
            char[] coordonee = scanner.nextLine().toCharArray();
            String lettre = Character.toString(coordonee[0]);
            int x = -1;
            int y = Character.getNumericValue(coordonee[1]);
            for (int i = 0; i < Alphabet.length; i++){
                if (lettre.toLowerCase().equals(Alphabet[i])){
                    x = i;
                    break;
                }
            }
            if (x != -1 && plateau[y][x] == 0){
                plateau[y][x] = 1;
                break;
            }else {
                System.out.println("Erreur, la case est occuper");
            }
        }
        return plateau;
    }
}
