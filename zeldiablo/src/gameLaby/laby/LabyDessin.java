package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    private static final int TAILLE_CASE = 20;

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu labyJeu = (LabyJeu) jeu;
        Labyrinthe laby = labyJeu.getLaby();

        GraphicsContext g = canvas.getGraphicsContext2D();

        g.setFill(Color.BLACK);
        g.fillRect(0, 0, laby.getLength() * TAILLE_CASE, laby.getLengthY() * TAILLE_CASE);

        for (int x = 0; x < laby.getLength(); x++) {
            for (int y = 0; y < laby.getLengthY(); y++) {
                if (laby.getMur(x, y)) {
                    g.setFill(Color.DARKGRAY);
                    g.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                }
            }
        }

        g.setFill(Color.RED);
        int px = laby.pj.getX();
        int py = laby.pj.getY();
        g.fillOval(px * TAILLE_CASE, py * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
    }
}