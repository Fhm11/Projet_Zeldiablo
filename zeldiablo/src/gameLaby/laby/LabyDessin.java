package gameLaby.laby;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.util.List;

public class LabyDessin implements DessinJeu {

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu lj = (LabyJeu) jeu;
        Labyrinthe laby = lj.getLaby();
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int nbColonnes = laby.getLength(); // axe X
        int nbLignes = laby.getLengthY(); // axe Y
        int dimension = (int) (canvas.getWidth() / nbColonnes);

        for (int x = 0; x < nbColonnes; x++) {
            for (int y = 0; y < nbLignes; y++) {
                if (laby.getMur(x, y)) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(x * dimension, y * dimension, dimension, dimension);
            }
        }

        // Dessiner le personnage
        Perso p = lj.getPerso();
        if (p != null) {
            gc.setFill(Color.RED);
            gc.fillOval(p.getX() * dimension, p.getY() * dimension, dimension, dimension);
        }

        // Dessiner le monstre
        List<Monstre> monstres = lj.getMonstres();
        if (monstres != null) {
            gc.setFill(Color.PURPLE);
            for (Monstre m : monstres) {
                gc.fillOval(m.getX() * dimension, m.getY() * dimension, dimension, dimension);
            }
        }
    }
}
