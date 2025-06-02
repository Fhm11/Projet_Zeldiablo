package gameLaby.laby;
import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) throws IOException {
        int width = 800;
        int height = 500;
        int pFPS = 10;

        // creation des objets
        LabyJeu jeu_laby = new LabyJeu();
        LabyDessin laby_dessin = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(height,width);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeu_laby, laby_dessin);
    }
}