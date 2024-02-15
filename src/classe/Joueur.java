package classe;
/** La Classe des joueurs */
public class Joueur {
    int score = 0;
    String Pseudo;
    int coordoneeX;
    int coordoneeY;
    int couleur;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public int getCoordoneeX() {
        return coordoneeX;
    }

    public void setCoordoneeX(int coordoneeX) {
        this.coordoneeX = coordoneeX;
    }

    public int getCoordoneeY() {
        return coordoneeY;
    }

    public void setCoordoneeY(int coordoneeY) {
        this.coordoneeY = coordoneeY;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
}
