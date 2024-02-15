package fonctionnalite;

import classe.Joueur;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Sauvegarde {
    /** Fonction pour sauvegarder les scores des joueurs */
    public static void sauvegarder(ArrayList<Joueur> listeASauvegarder){
        try {
            // On créer un fichier scores
            FileOutputStream fileOut = new FileOutputStream("scores");
            // On prend le chemin
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // On ecrit dans le fichier scores
            out.writeObject(listeASauvegarder);
            out.close();
            fileOut.close();
            System.out.println("Sauvegarde effectuer");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** Fonction qui lis la sauvegarde scores */
    public static ArrayList<Joueur> lireSauvegarde(){
        ArrayList<Joueur> arraylist= new ArrayList<Joueur>();
        try {
            // trouve le chemin vers le fichier
            FileInputStream fileIn = new FileInputStream("scores");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            arraylist = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return arraylist;
    }
}
