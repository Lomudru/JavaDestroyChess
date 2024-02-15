package fonctionnalite;

import classe.Joueur;

/** Vérifie si un joueur peut bouger */
public class VerifVictoireDefaite {
    public static boolean verifVictoireDefaite(int[][] plateau, Joueur enTrainDeJouer){
        if ((enTrainDeJouer.getCoordoneeX()-1 == -1 || plateau[enTrainDeJouer.getCoordoneeX() - 1][enTrainDeJouer.getCoordoneeY()] != 0) &&
                (enTrainDeJouer.getCoordoneeX()+1 == plateau.length || plateau[enTrainDeJouer.getCoordoneeX() + 1][enTrainDeJouer.getCoordoneeY()] != 0) &&
                (enTrainDeJouer.getCoordoneeY()-1 == -1 || plateau[enTrainDeJouer.getCoordoneeX()][enTrainDeJouer.getCoordoneeY() - 1] != 0) &&
                (enTrainDeJouer.getCoordoneeY()+1 == plateau[0].length || plateau[enTrainDeJouer.getCoordoneeX()][enTrainDeJouer.getCoordoneeY() + 1] != 0)){
            return false;
        }
        return true;
    }
}
