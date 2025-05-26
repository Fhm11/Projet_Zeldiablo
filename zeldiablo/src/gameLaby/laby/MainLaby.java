package gameLaby.laby;

import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import moteurJeu.MoteurJeu;

public class MainLaby {
    public static void main(String[] args) {
        Jeu jeu = new LabyJeu();
        DessinJeu dessin = new LabyDessin();

        MoteurJeu.setFPS(60);
        MoteurJeu.setTaille(800, 600);
        MoteurJeu.launch(jeu, dessin);
    }
}
