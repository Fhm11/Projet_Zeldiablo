package gameLaby.laby;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;


public class LabyDessin implements DessinJeu {

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu lj = (LabyJeu) jeu;
        Labyrinthe laby = lj.getLaby();

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int nbrLigne = laby.getLength();
        int nbrColonne = laby.getLengthY();
        int dimension = (int) (canvas.getWidth()/nbrColonne);

        for (int i=0;i<nbrLigne;i++){

            for (int j = 0;j<nbrColonne;j++){
                if (laby.getMur(i,j)){
                    gc.setFill(Color.BLACK);
                } else{
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(j*dimension,i*dimension,dimension,dimension);

            }

        }


    }
}