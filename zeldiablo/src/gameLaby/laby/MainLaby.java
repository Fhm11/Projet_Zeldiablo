package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import moteurJeu.MoteurJeu;

public class MainLaby {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        DessinJeu dessin = new DessinJeu()

        // Lancement du moteur de jeu
        MoteurJeu.setFPS(60);              // optionnel
        MoteurJeu.setTaille(800, 600);     // optionnel
        MoteurJeu.launch(jeu, dessin);
    }
}
